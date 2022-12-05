package aoc

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.io.Source

class CratesStackSpec extends AnyFlatSpec with Matchers {

  "The CratesStack object" should "return the top crate for each stack" in {
    CratesStack.getTopCrates(Source.fromResource("input5.txt").getLines) shouldEqual "CMZ"
  }

    "The CratesStack object" should "return the top crate for each stack on 9001 way" in {
    CratesStack.getTopCrates(Source.fromResource("input5.txt").getLines, true) shouldEqual "MCD"
  }

}
