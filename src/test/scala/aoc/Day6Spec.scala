package aoc

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.io.Source

class PacketMarkerSpec extends AnyFlatSpec with Matchers {

  "The PacketMarker object" should "return the index of the first start" in {
    PacketMarker.getFirstStartIndex(Source.fromResource("input6.txt").mkString, 4) shouldEqual 7
  }

  "The PacketMarker object" should "return the index of the first start for messages" in {
    PacketMarker.getFirstStartIndex(Source.fromResource("input6.txt").mkString, 14) shouldEqual 19
  }
}
