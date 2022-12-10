package aoc

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.io.Source

class SignalStrengthSpec extends AnyFlatSpec with Matchers {

  "Signal strenght object" should "sum the signal strengths at certain positions" in {
    SignalStrength.solve1(Source.fromResource("input10.txt").getLines) shouldEqual 13140
  }

  "Signal strenght object" should "print the galimatias" in {
    SignalStrength.solve2(Source.fromResource("input10.txt").getLines)
  }

}
