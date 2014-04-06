package v1

class IntegerBST[V] {
  var root: Node[V] = _
  def put(key: Int, value: V): Unit = {
    root = put(root, key, value)
  }

  def put(node: Node[V], key: Int, value: V): Node[V] = {
    if (node == null) {
      new Node[V](key, value, null, null)
    } else {
      val cmp = key - node.key
      if (cmp == 0) {
        node.value = value
        node
      } else if (cmp < 0) {
        node.left = put(node.left, key, value)
        node
      } else {
        node.right = put(node.right, key, value)
        node
      }
    }
  }

  def get(key: Int): V = {
    get(root, key)
  }

  def get(node: Node[V], key: Int): V = {
    if (node != null) {
      val cmp = key - node.key

      if (cmp == 0) {
        node.value
      } else if (cmp < 0) {
        get(node.left, key)
      } else {
        get(node.right, key)
      }
    } else {
      null.asInstanceOf[V]
    }
  }
}

class Node[V](val key: Int, var value: V, var left: Node[V], var right: Node[V]) 