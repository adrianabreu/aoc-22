package aoc

import scala.io.Source
import scala.collection.mutable.Stack

object PacketMarker extends App {
  
  def getFirstStartIndex(input: String, packetSize: Int): Int = {
    input.toCharArray.sliding(packetSize,1).map( w => w.toSet.size == packetSize).zipWithIndex.find(p => p._1 == true).get._2 + packetSize
  }


  println(getFirstStartIndex(Source.fromResource("input6.txt").mkString, 4))
  println(getFirstStartIndex(Source.fromResource("input6.txt").mkString, 14))
 
}