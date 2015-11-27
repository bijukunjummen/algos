package bal

class BST[K, V]  {

  var root: Option[Node] = None

  def get(k: K)(implicit ord: Ordering[K]): Option[V] = {
    def get(fromNode: Option[Node]): Option[V] = {
      fromNode match {
        case o@Some(n) => {
          val cmp = ord.compare(k, n.key)

          if (cmp == 0) {
            Some(n.value)
          } else if (cmp < 0) {
            get(n.left)
          } else {
            get(n.right)
          }
        }
        case None => {
          None
        }
      }
    }

    get(root)
  }

  def put(k: K, v: V)(implicit ord: Ordering[K]): Unit = {
    def put(fromNode: Option[Node]): Option[Node] = {
      fromNode match {
        case o@Some(n) => {
          val cmp = ord.compare(k, n.key)

          if (cmp == 0) {
            n.value = v
          } else if (cmp < 0) {
            n.left = put(n.left)
          } else {
            n.right = put(n.right)
          }
          o
        }
        case None => Some(new Node(k, v, 1, None, None))
      }
    }

    root = put(root)
  }

  case class Node(key: K, var value: V, var n: Int, var left: Option[Node], var right: Option[Node])

}
