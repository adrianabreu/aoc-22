package aoc

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.io.Source

class CaloriesSpec extends AnyFlatSpec with Matchers {

  "The Calories object" should "find the most calories carried by an elf" in {
    Calories.getMaxCalories(Source.fromResource("input1.txt").getLines) shouldEqual 24000
  }

    "The Calories object" should "find the sum of the calories of the elf and the backups" in {
    Calories.getSumTop3(Source.fromResource("input1.txt").getLines) shouldEqual 45000
  }
}
