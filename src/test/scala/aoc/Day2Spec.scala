package aoc

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.io.Source

class StrategySpec extends AnyFlatSpec with Matchers {

  "The Strategy object" should "calculate the score" in {
    Strategy.getTotalScore(Source.fromResource("input2.txt").getLines) shouldEqual 15
  }

  "The Strategy object" should "calculate the score wit hthe proper elf strategy" in {
    Strategy.getElfStrategyScore(Source.fromResource("input2.txt").getLines) shouldEqual 12
  }
}
