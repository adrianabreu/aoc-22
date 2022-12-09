package aoc

import scala.io.Source
import scala.math.abs

object RopeBridge extends App {

  def traverse(input: Iterator[String], knots: Int = 1): Int = {
    val head = Head(0,0)
    val tail = Seq.fill(knots)(Tail(0,0))

    def loop(move: Iterator[String], visited: Set[(Int,Int)], head: Head, tail: Seq[Point]): Set[(Int, Int)] = {

        if (move.hasNext) {
            val line = move.next()
            val dir = line.split(" ")(0)
            val times = line.split(" ")(1).toInt

            val updated = (1 to times).foldLeft(
                (visited, head, tail)
            )((op, n) => {
                val tempHead = dir match {
                    case "U" => Head(op._2.x + 1, op._2.y)
                    case "D" => Head(op._2.x - 1, op._2.y)
                    case "R" => Head(op._2.x, op._2.y + 1)
                    case "L" => Head(op._2.x, op._2.y - 1)
                } 
                val tempTail = op._3.zipWithIndex.map{ case (p, index) => op._3.slice(0, index+1).fold(tempHead)((newP, n) => n.update(newP))}
                val newVisited = op._1 + ((tempTail.last.x, tempTail.last.y))
                (newVisited, tempHead, tempTail)
            })
            loop(move, updated._1, updated._2, updated._3)

        } 
        else
            visited

    }
    loop(input, Set(), head, tail).size
  }

  def solve1(input: Iterator[String]): Long =
    traverse(input)

  println(solve1(Source.fromResource("input9.txt").getLines))

  def solve2(input: Iterator[String]): Long =
    traverse(input, 9)

  println(solve2(Source.fromResource("input9.txt").getLines))

}

trait Point {
    val x: Int
    val y: Int
    def update(h: Point): Point
}
case class Head(x: Int, y: Int) extends Point {
    override def update(h: Point): Point = ???
}
case class Tail(x: Int, y: Int) extends Point {
    def update(h: Point): Point = {
        if (abs(h.x - x) <= 1 && abs(h.y - y) <= 1) Tail(x, y)
        else if (h.x == x) {
            if ((h.y - y) < 0) Tail(x,y - 1)
            else Tail(x, y + 1)
        }
        else if (h.y == y) {
            if ((h.x - x) < 0) Tail(x-1,y)
            else Tail(x+1, y)
        }
        else {
            val vDir = if ((h.x - x) < 0) -1 else 1
            val hDir = if ((h.y - y) < 0) -1 else 1
            Tail(x + vDir, y + hDir)
        }
    }
}