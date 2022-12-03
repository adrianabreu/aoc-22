package aoc

import scala.io.Source

object Strategy extends App {
  
  def getTotalScore(input: Iterator[String]): Int = {
    input.map(l => {
      val plays = l.split(" ")

      def playToShape(p: String): Shape = {
        p match {
          case "X" | "A" => Rock
          case "Y" | "B" => Paper
          case "Z" | "C" => Scissor
        }
      }
      playToShape(plays(1)).score(playToShape(plays(0)))
    }).sum
  }

  def getElfStrategyScore(input: Iterator[String]): Int = {
    input.map(l => {
      val plays = l.split(" ")

      def playToShape(p: String): Shape = {
        p match {
          case "A" => Rock
          case "B" => Paper
          case "C" => Scissor
        }
      }

      def actionToShape(s: Shape, p: String): Shape = {
        (s, p) match {
          case (a, "Y") => a
          case (Rock, "X") => Scissor
          case (Rock, "Z") => Paper
          case (Paper, "X") => Rock
          case (Paper, "Z") => Scissor
          case (Scissor, "X") => Paper
          case (Scissor, "Z") => Rock
        }
      }

      val otherPlayerShape = playToShape(plays(0))
      actionToShape(otherPlayerShape, plays(1)).score(otherPlayerShape)
    }).sum
  }

  println(getTotalScore(Source.fromResource("input2.txt").getLines))
  println(getElfStrategyScore(Source.fromResource("input2.txt").getLines))

}

trait Shape {
  val points: Int

  def score(o: Shape): Int
}

case object Rock extends Shape {
  
  override val points: Int = 1
  
  override def score(o: Shape): Int = 
    o match {
      case Rock => points + 3
      case Paper => points + 0
      case Scissor => points + 6
    }
  
}

case object Paper extends Shape {
  
  override val points: Int = 2
  
  override def score(o: Shape): Int = 
    o match {
      case Rock => points + 6
      case Paper => points + 3
      case Scissor => points + 0
    }
  
}

case object Scissor extends Shape {
  
  override val points: Int = 3
  
  override def score(o: Shape): Int = 
    o match {
      case Rock => points + 0
      case Paper => points + 6
      case Scissor => points + 3
    }
  
}