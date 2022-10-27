package lectures.part2oop

object GenericsList extends App {
  val listOfIntegers: MyLinkedList[Int] = Empty
  val listOfString: MyLinkedList[String] = Empty

  val myLinkedList = new Cons(1, Empty).add(4).add(5)
  println(myLinkedList.tail.head)
  println(myLinkedList.printElements)
  println(myLinkedList.map(new MyTransformer[Int, Int] {
    override def transform(a: Int): Int = a * 2
  }))

  println(myLinkedList.filter(new MyPredicate[Int] {
    override def test(a: Int): Boolean = a != 4
  }))

  println(myLinkedList.flatMap(new MyTransformer[Int, MyLinkedList[Int]] {
    override def transform(a: Int): MyLinkedList[Int] = Empty.add(a + 10).add(a)
  }))



  abstract class MyLinkedList[+A] {
    def add[B >: A](element: B): MyLinkedList[B]

    def head: A // first elt of the list

    def tail: MyLinkedList[A] // remainder of the list

    def isEmpty: Boolean

    def printElements: String

    override def toString: String = s"[$printElements]"

    def map[B](transformer: MyTransformer[A, B]): MyLinkedList[B]

    def flatMap[B](transformer: MyTransformer[A, MyLinkedList[B]]): MyLinkedList[B]

    def filter(predicate: MyPredicate[A]): MyLinkedList[A]

    def ++[B >: A](list: MyLinkedList[B]): MyLinkedList[B]
  }

  object Empty extends MyLinkedList[Nothing] {
    // Initially we set all to ???, which returns scala.Nothing
    // throw exceptions return scala.Nothing
    def head: Nothing = throw new NoSuchElementException

    def tail: MyLinkedList[Nothing] = throw new NoSuchElementException

    def isEmpty: Boolean = true

    def add[B >: Nothing](element: B): MyLinkedList[B] = new Cons(element, Empty)

    def printElements: String = ""

    def map[B](transformer: MyTransformer[Nothing, B]): MyLinkedList[B] = Empty

    def flatMap[B](transformer: MyTransformer[Nothing, MyLinkedList[B]]): MyLinkedList[B] = Empty

    def filter(predicate: MyPredicate[Nothing]): MyLinkedList[Nothing] = Empty

    def ++[B >: Nothing](list: MyLinkedList[B]): MyLinkedList[B] = list

  }

  class Cons[+A](h: A, t: MyLinkedList[A]) extends MyLinkedList[A] {
    def head: A = h

    def tail: MyLinkedList[A] = t

    def isEmpty: Boolean = false

    def add[B >: A](element: B): MyLinkedList[B] = new Cons(element, this)

    def printElements: String = {
      if (t.isEmpty) s"$h"
      else s"$h ${t.printElements}"
    }

    def map[B](transformer: MyTransformer[A, B]): MyLinkedList[B] = {
      new Cons(transformer.transform(h), t.map(transformer))
    }

    def flatMap[B](transformer: MyTransformer[A, MyLinkedList[B]]): MyLinkedList[B] = {
      transformer.transform(h) ++ t.flatMap(transformer)
    }

    def filter(predicate: MyPredicate[A]): MyLinkedList[A] = {
      if (predicate.test(h)) new Cons(h, t.filter(predicate))
      else t.filter(predicate)
    }

    def ++[B >: A](list: MyLinkedList[B]): MyLinkedList[B] = new Cons(h, t ++ list)
    
  }

  // Contravariant in T
  trait MyPredicate[-T] {
    def test(t: T): Boolean
  }

  // Contravariant in A
  trait MyTransformer[-A, B] {
    def transform(a: A): B
  }


}
