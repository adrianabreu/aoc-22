package aoc

import scala.io.Source
import scala.math.pow

object TreeTop extends App {

  def getVisible(input: Iterator[String]): Int = {
    val lines = input.mkString("\n").split("\n").toSeq.map(_.split("").toSeq.map(_.toInt))

    def isVisible(x: Int,  y: Int): Int = {
      if (x == 0 || y == 0 || x == (lines.size - 1) || y == (lines.head.size - 1)) {
        1
      }
      else {
        val lookLeft = (0 until y).map(c => lines(x)(c)).max
        val lookTop = (0 until x).map(r => lines(r)(y)).max
        val lookRight = ((y + 1) until lines.head.size).map(c => lines(x)(c)).max
        val lookDown = ((x + 1) until lines.size).map(r => lines(r)(y)).max
        if (lookLeft < lines(x)(y) || lookTop < lines(x)(y) || lookRight < lines(x)(y) || lookDown < lines(x)(y) ) {
          1
        } else {
          0
        }
      }

    }

    lines.zipWithIndex.map{ case(line, r) => line.zipWithIndex.map{case (e, c) => isVisible(r,c)}.sum}.sum
  }

  def getScenicScore(input: Iterator[String]): Int = {
    val lines = input.mkString("\n").split("\n").toSeq.map(_.split("").toSeq.map(_.toInt))

    def getScene(x: Int,  y: Int): Int = {
        val lookLeft = (0 until y).map(c => lines(x)(c)).reverse.toList
        val lookTop = (0 until x).map(r => lines(r)(y)).reverse.toList
        val lookRight = ((y + 1) until lines.head.size).map(c => lines(x)(c)).toList
        val lookDown = ((x + 1) until lines.size).map(r => lines(r)(y)).toList

        (lookLeft.span(p => p < lines(x)(y)) match {case (h, t) => h ::: t.take(1)}).size * 
        (lookTop.span(p => p < lines(x)(y)) match {case (h, t) => h ::: t.take(1)}).size * 
        (lookRight.span(p => p < lines(x)(y)) match {case (h, t) => h ::: t.take(1)}).size * 
        (lookDown.span(p => p < lines(x)(y)) match {case (h, t) => h ::: t.take(1)}).size
      }

    lines.zipWithIndex.map{ case(line, r) => line.zipWithIndex.map{case (e, c) => getScene(r,c)}.max}.max
  }

  def solve1(input: Iterator[String]): Long =
    getVisible(input)

  println(solve1(Source.fromResource("input8.txt").getLines))


  def solve2(input: Iterator[String]): Long =
    getScenicScore(input)

  println(solve2(Source.fromResource("input8.txt").getLines))
}

