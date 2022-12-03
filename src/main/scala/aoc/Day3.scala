package aoc

import scala.io.Source

object RuckSack extends App {
  
  def sumPrioritiesOfSharedItems(input: Iterator[String]): Int = {
    input.map(l => {
      val sharedItems = Seq(l.substring(0, l.length / 2), l.substring(l.length / 2)).map(_.split("").toSet).reduce((a,b) => a.intersect(b))

      def itemToPoints(p: Char): Int = {
        if (p.isUpper) {
          p - 'A' + 27
        } else {
          p - 'a' + 1
        }
      }
      sharedItems.map(s => itemToPoints(s.charAt(0))).sum
    }).sum
  }

  def sumPrioritiesOfBadgesItems(input: Iterator[String]): Int = {
    input.grouped(3).map(e => {
      val badge = e.map(_.toSet).reduce((a,b) => a.intersect(b))

      def itemToPoints(p: Char): Int = {
        if (p.isUpper) {
          p - 'A' + 27
        } else {
          p - 'a' + 1
        }
      }
      itemToPoints(badge.head)
    }).sum
  }
  println(sumPrioritiesOfSharedItems(Source.fromResource("input3.txt").getLines))
  println(sumPrioritiesOfBadgesItems(Source.fromResource("input3.txt").getLines))

}