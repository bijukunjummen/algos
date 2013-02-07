package org.bk.algo.scala.core
import org.scalatest.FunSuite

class LinkedListTest extends FunSuite {
	test("linked list add to beginning"){
	  val list = new LinkedList[Int]();
	  list.insertAtBeginning(10);
	  list.insertAtBeginning(20);
	  println(list.getSize())
	}
}