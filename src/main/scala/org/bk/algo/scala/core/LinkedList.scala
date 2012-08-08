package org.bk.algo.scala.core

class LinkedList[T]{
  private var first:Node[T] = null;
  private var last:Node[T] = null;
  private var size:Int = 0;
  
  def insertAtBeginning(item:T):Unit = {
    if (first==null){
      first = new Node(item, null, null);
      last = first;
    }else{
      var oldFirst = first;
      first = new Node(item, oldFirst, null);
      oldFirst.prev = first;
    }
    size = size + 1;
  }
  
  def getSize() = size;
}

class Node[T](val item:T, var next:Node[T], var prev:Node[T])

