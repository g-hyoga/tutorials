sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]):Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] = {
    if(as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }

  def tail[A](ds: List[A]): List[A] = ds match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def setHead[A](d: A, li: List[A]): List[A] = li match {
    case Nil => Cons(d, Nil)
    case Cons(x, xs) => Cons(d, Cons(x, xs))
  }

  def drop[A](l: List[A], n: Int): List[A] = {
    if (n <= 0) l
    else if (l == Nil) Nil
    else drop(List.tail(l), n-1)
  }

  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(x, xs) if f(x) => dropWhile(xs, f)
    case _ => l
  }

  def append[A](a1: List[A], a2: List[A]): List[A] = {
    a1 match {
      case Nil => a2
      case Cons(h, t) => Cons(h, append(t, a2))
    }
  }

  def init[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(_, Nil) => Nil
    case Cons(h, t) => Cons(h, init(t))
  }
}

object Exe3_1 {
  def main(args: Array[String]): Unit = {
    //val x = List(1, 2, 3, 4, 5) match {
    //  case Cons(x, Cons(2, Cons(4, _))) => x
    //  case Nil => 42
    //  case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    //}
    //println(x)

    println(List.tail(List(1, 2, 3)))
    println(List.setHead(0, List(1, 2, 3)))
    println(List.drop(List(1, 2, 3), 2))
    println(List.dropWhile(List(1, 2, 3), (x:Int) => x!=2))
    println(List.init(List(1, 2, 3)))
    println(List.append(List(1, 2, 3), List(1, 2, 3)))
  }
}

