package lectures.part2oop

object AbstractDataTypes extends App {
  // abstract
  // An abstract class cannot be instantiated
  abstract class Animal {
    val creatureType: String // no value, so this is abstract
    def eat: Unit // no impl, so this is also abstract
  }
  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("chafchaf")
  }

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Reptile"
    def eat: Unit = println("chompchomp")
    def eat(animal: Animal): Unit = println(s"I'm a $creatureType and I'm eating a ${animal.creatureType}")
  }

  // traits
  // A trait can be inherited along classes
  trait Carnivore {
    def eat(animal: Animal): Unit // this method is also abstract
    val preferredMeal: String = "fresh meat" // non-abstract member!
  }

  trait ColdBlooded {
  }

  // 1. Traits cannot have constructor parameters
  // 2. Multiple traits may be inherited by the same class
  // 3. Traits = behaviors, abstract class = type of thing

  // Scala Type Hierarchy

  // We start from scala.Any, private
  // scala.AnyRef extends Any. AnyRef ~ java.lang.Object
  println(scala.AnyRef)
  // List, String, Set, etc. extend AnyRef
  // scala.Null extends all this
  val list: List[Any] = null
  val set: Set[Any] = null
  println(null)
  // scala.AnyVal extends Any. AnyVal ~ java primitive types
  // Int, Unit, Boolean, Float
  // val int: Int = null // This fails fails because null doesn't extend AnyVal
  // Derived from all this, we have scala.Nothing! Subtypes everything in Scala
  // Its not even null, not even None, pure nothingness.

  val myList = new Cons(1, Empty)
  val newList = myList.add(4).add(5)
  println(newList.tail.head)
  println(newList.printElements)
}

abstract class MyList {

  def head: Int // first elt of the list
  def tail: MyList // remainder of the list
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String
  override def toString: String = s"[$printElements]"
}

object Empty extends MyList {
  // Initially we set all to ???, which returns scala.Nothing
  // throw exceptions return scala.Nothing
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)
  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)
  def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}
