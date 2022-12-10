package aoc

import scala.io.Source
import scala.math.abs

object SignalStrength extends App {

  def getSignalStrenght(input: Iterator[String]): (Seq[Int], Seq[Char]) = {
    val X = 1
    val cycles = 1
    val crtSize = 240

    def loop(x: Int, cycle: Int, prevLine: Option[String], strengths: Seq[Int], pixels: Seq[Char]): (Seq[Int], Seq[Char]) = {
        val cyclesToKeep = Seq(20,60,100,140,180,220)
        if (cycle > crtSize)
            (strengths, pixels)
        else {
            val newStrenghts = if (cyclesToKeep.contains(cycle)) strengths:+ (x*cycle) else strengths
            val newPixels = if (abs(((cycle - 1) % 40) - x) <= 1) pixels :+ '#' else pixels :+ '.'
            val newCycle = cycle + 1
            val newLine = if(prevLine.isDefined) None else {
                val line = input.next()
                if (line.startsWith("noop")) None else Some(line)
            }
            val newX = if (prevLine.isDefined) x + prevLine.get.split(" ")(1).toInt else x

            loop(newX, newCycle,newLine, newStrenghts, newPixels)
        }


    }
    loop(X,cycles, None, Seq(), Seq())
  }

  def solve1(input: Iterator[String]): Long =
    getSignalStrenght(input)._1.sum

  def solve2(input: Iterator[String]): String =
    getSignalStrenght(input)._2.sliding(40, 40).map(f => f.mkString).mkString("\n")

  println(solve1(Source.fromResource("input10.txt").getLines))

  println(solve2(Source.fromResource("input10.txt").getLines))

}