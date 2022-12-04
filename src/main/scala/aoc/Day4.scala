package aoc

import scala.io.Source

object SectionAssignments extends App {
  
  def findPairsFullyContained(input: Iterator[String]): Int = {
    input.map(l => {
      def toRange(p: String): Range = {
        val pair = p.split("-")
        (pair(0).toInt).to((pair(1).toInt))
      }

      val pairs = l.split(",").map(toRange(_))

      (pairs(0).contains(pairs(1).start) && pairs(0).contains(pairs(1).end)) || 
      (pairs(1).contains(pairs(0).start) && pairs(1).contains(pairs(0).end)) 
    }).count(p => p == true)
  }

  def findPairsPartitallyContained(input: Iterator[String]): Int = {
    input.map(l => {
      def toRange(p: String): Range = {
        val pair = p.split("-")
        (pair(0).toInt).to((pair(1).toInt))
      }

      val pairs = l.split(",").map(toRange(_))

      (pairs(0).contains(pairs(1).start) || pairs(0).contains(pairs(1).end)) || 
      (pairs(1).contains(pairs(0).start) || pairs(1).contains(pairs(0).end)) 
    }).count(p => p == true)
  }

  println(findPairsFullyContained(Source.fromResource("input4.txt").getLines))
  println(findPairsPartitallyContained(Source.fromResource("input4.txt").getLines))

}