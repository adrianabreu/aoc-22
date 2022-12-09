package aoc

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.io.Source

class RopeBridgeSpec extends AnyFlatSpec with Matchers {

  "Rope Bridge object" should "return the positions visited at least once" in {
    RopeBridge.solve1(Source.fromResource("input9.txt").getLines) shouldEqual 13
  }
  "Rope Bridge object" should "return the positions visited at least once when there are 9 knots" in {
    RopeBridge.solve2(Source.fromResource("input9.txt").getLines) shouldEqual 1
  }

}
