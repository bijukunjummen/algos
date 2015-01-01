package demo

sealed trait Lst[+A]

case object Nl extends Lst[Nothing]

case class Cns[+A](head: A, tail: Lst[A]) extends Lst[A]

object Lst {
  def sum(ints: Lst[Int]): Int = ints match {
    case Nl => 0
    case Cns(x, xs) => x + sum(xs)
  }
  
  def product(ds: Lst[Double]): Double = ds match {
    case Nl => 1.0
    case Cns(0.0, _) => 0.0
    case Cns(x, xs) => x * product(xs)
  }
  
  def apply[A](as: A*): Lst[A] = {
    if (as.isEmpty) Nl
    else Cns(as.head, apply(as.tail:_*))
  }
  
  def dropWhile[A](l: Lst[A], f: A => Boolean): Lst[A] = {
    l match {
      case Cns(x, xs) => if (f(x)) dropWhile(xs, f) else xs
      case Nl => Nl
    }
  }

}

class Person(val name: String, val address: String)

object Person {
  def apply(n: String, a: String) = new Person(n, a)
  def unapply(p: Person) = Some(p.name, p.address)
}