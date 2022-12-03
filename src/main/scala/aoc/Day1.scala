package aoc

import scala.io.Source

object Calories extends App {
  
    def getMaxCalories(input: Iterator[String]): Int = {
    loop(input, 0, Seq()).max
  }

  def getSumTop3(input: Iterator[String]): Int = {
    loop(input, 0, Seq()).sortWith((a: Int,b: Int) => a > b).take(3).sum
  }

  def loop(i: Iterator[String], curr: Int, elves: Seq[Int]): Seq[Int] = {
    if (i.hasNext) {
      val e = i.next
      e match {
        case "" => loop(i, 0, elves :+ curr)
        case _ => loop(i, curr + e.toInt, elves)
      }
    
    } else {
      elves :+ curr
    }
  }

  println(getMaxCalories(Source.fromResource("input1.txt").getLines))
  println(getSumTop3(Source.fromResource("input1.txt").getLines))
}
