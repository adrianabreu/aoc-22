package aoc

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.io.Source

class SectionAssignmentsSpec extends AnyFlatSpec with Matchers {

  "The SectionAssignments object" should "find the pairs that do overlap completely" in {
    SectionAssignments.findPairsFullyContained(Source.fromResource("input4.txt").getLines) shouldEqual 2
  }

  "The SectionAssignments object" should "calculate the sections that overlap" in {
    SectionAssignments.findPairsPartitallyContained(Source.fromResource("input4.txt").getLines) shouldEqual 4
  }
}
