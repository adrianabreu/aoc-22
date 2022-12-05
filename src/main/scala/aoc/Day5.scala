package aoc

import scala.io.Source
import scala.collection.mutable.Stack

object CratesStack extends App {
  
  def getTopCrates(input: Iterator[String], multipleGrab: Boolean = false): String = {
    
    def toStack(input: Iterator[String], acc: Seq[List[Char]]): Seq[List[Char]] = {
      val curr = input.next()
      if (curr == "") acc.dropRight(1)
      else {
        val values = curr.toCharArray.sliding(3,4).map(_(1)).toList
        toStack(input, acc :+ values)
      }
    }
    var values = toStack(input, Seq()).transpose.map(l => l.filter(n => n != ' ').reverse)
    
    def toInstructions(input: Iterator[String], acc: Seq[Move]): Seq[Move] = {
      if (input.hasNext) {
        val pattern = "([0-9]+)".r
        val curr = input.next() 
        val matched = pattern.findAllMatchIn(curr).toList.map(_.matched.toInt)
        toInstructions(input, acc :+ Move(matched(0), matched(1) - 1, matched(2) - 1))
      } else {
        acc
      }
    }
    val moves = toInstructions(input, Seq())
    
    def loop(moves: Seq[Move], stack: Seq[Seq[Char]]): Seq[Seq[Char]] = {
      
      moves match {
        case head :: next => loop(next, stack.zipWithIndex.map{ case (el: List[Char], index: Int) => {
          if (index == head.from) el.dropRight(head.amount)
          else if (index == head.to) 
            if (multipleGrab == true) 
              el ++ stack(head.from).takeRight(head.amount)
            else el ++ stack(head.from).takeRight(head.amount).reverse
          else el
        }}) 
        case _ => stack
      }
    }
    val transformed = loop(moves, values)
    
    transformed.map(f => f.last).mkString
  }


  println(getTopCrates(Source.fromResource("input5.txt").getLines))
  println(getTopCrates(Source.fromResource("input5.txt").getLines, true))

}

case class Move(val amount: Int, val from: Int, val to: Int)