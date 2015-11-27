package rbtree

class RedBlackBST [K <: Comparable[K], V]{

  var root: Option[Node] = None

  private def isRed(node: Node): Boolean = {
    if (node == null)
      false
    else
      node.red
  }

  private def isRed(node: Option[Node]): Boolean = {
    node.map(_.red).getOrElse(true)
  }

  private def size(n: Option[Node]): Int = {
    n match {
      case Some(node) => size(node)
      case None => 0
    }
  }
  private def size(node: Node):Int = if (node == null) 0 else node.subtreeCount

  def size: Int = root match {
    case Some(n) => size(n)
    case None => 0
  }

  def get(key: K): Option[V] = {
    def get(fromNode: Option[Node]): Option[V] = {
      fromNode match {
        case Some(n) => {
          val cmp = n.key.compareTo(key)
          if (cmp < 0)
            get(n.left)
          else if (cmp > 0)
            get(n.right)
          else
            Some(n.value)
        }
        case None => None
      }
    }

    get(root)
  }

  def contains(key: K) = get(key) != None

  def put(key: K, value: V): Unit = {
    def put(fromNode: Option[Node]): Option[Node] = {
      fromNode match {
        case o@Some(n) => {
          val cmp = n.key.compareTo(key)
          if (cmp < 0)
            n.left = put(n.left)
          else if (cmp > 0)
            n.right = put(n.right)
          else
            n.value = value


          var toReturn:Option[Node] = o

          toReturn = if (isRed(n.right) && !isRed(n.left)) rotateLeft(o) else toReturn
          toReturn = if (isRed(n.left) && isRed(n.left.map(_.left).getOrElse(None)) ) rotateRight(toReturn) else toReturn
          toReturn = if (isRed(n.left) && isRed(n.right)) flipColors(toReturn) else toReturn

          toReturn
        }
        case None => Some(Node(key, value, None, None, true, 1))
      }
    }

    root = put(root)
  }

  private def rotateRight(h: Option[Node]): Option[Node] = {
    h match {
      case Some(hn) => {
        val x = hn.left
        x match {
          case o@Some(xn) => {
            hn.left = xn.right
            xn.right = h
            xn.red = hn.red
            xn.right.foreach(node => node.red = true)
            xn.subtreeCount = hn.subtreeCount
            hn.subtreeCount = size(hn.left) + size(hn.right) + 1
            o
          }
          case None => {
            None
          }
        }
      }
      case None => None
    }
  }



  private def rotateLeft(h: Option[Node]): Option[Node] = {
    h match {
      case Some(hn) => {
        val x = hn.right
        x match {
          case o@Some(xn) => {
            hn.right = xn.left
            xn.left = h
            xn.red = hn.red
            xn.left.foreach(node => node.red = true)
            xn.subtreeCount = hn.subtreeCount
            hn.subtreeCount = size(hn.left) + size(hn.right) + 1
            o
          }
          case None => {
            None
          }
        }
      }
      case None => None
    }
  }

  private def flipColors(h: Option[Node]): Option[Node] = {
    h match {
      case o@Some(hn) => {
        hn.red = !hn.red
        hn.left.foreach(node => node.red = !node.red)
        hn.right.foreach(node => node.red = !node.red)
        o
      }
      case None => None
    }
  }

  case class Node(key: K, var value: V, var left: Option[Node], var right: Option[Node], var red: Boolean,
                                         var subtreeCount: Int)
}


