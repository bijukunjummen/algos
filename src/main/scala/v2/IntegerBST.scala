package v2

class IntegerBST[V] {
  var root:Option[Node[V]] = None
  
  def put(key: Int, value: V): Unit =  {
    root = put(root, key, value)
  }
  
  def put(node: Option[Node[V]], key: Int, value: V): Option[Node[V]] = {
    node match {
      case Some(n) => {
        val cmp = key - n.key
        if (cmp == 0) {
          n.value = value
          node
        }else if (cmp < 0) {
          n.left = put(n.left, key, value)
          node
        }else {
          n.right = put(n.right, key, value)
          node
        }
      }
      case None => Some(new Node[V](key, value, None, None))
    }
    
  }
  
  def get(key: Int): V = {
	get(root, key).getOrElse(null.asInstanceOf[V])
  }
  
  def get(node: Option[Node[V]], key: Int): Option[V] = {
    node match {
      case Some(n) => {
        val cmp = key - n.key
        if (cmp == 0) {
          Some(n.value)
        }else if (cmp < 0) {
          get(n.left, key)
        }else {
          get(n.right, key)
        }       
      }
      case None => None
    }
  }
}

class Node[V](val key: Int, var value:V, var left: Option[Node[V]], var right: Option[Node[V]]) 