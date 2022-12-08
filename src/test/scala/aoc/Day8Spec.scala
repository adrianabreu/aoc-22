package aoc

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.io.Source

class TreeTopSpec extends AnyFlatSpec with Matchers {

  "The TreeTop object" should "return the visible trees" in {
    TreeTop.solve1(Source.fromResource("input8.txt").getLines) shouldEqual 21
  }


  "The TreeTop object" should "calculate the scenic score" in {
    TreeTop.solve2(Source.fromResource("input8.txt").getLines) shouldEqual 8
  }

}
