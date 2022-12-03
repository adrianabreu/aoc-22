package aoc

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.io.Source

class RuckSackSpec extends AnyFlatSpec with Matchers {

  "The Rucksack object" should "calculate the sum of the priorities of the shared items" in {
    RuckSack.sumPrioritiesOfSharedItems(Source.fromResource("input3.txt").getLines) shouldEqual 157
  }

    "The Rucksack object" should "calculate the sum of the priorities of badges items" in {
    RuckSack.sumPrioritiesOfBadgesItems(Source.fromResource("input3.txt").getLines) shouldEqual 70
  }
}
