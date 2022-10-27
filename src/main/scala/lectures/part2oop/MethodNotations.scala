package lectures.part2oop

import scala.annotation.targetName
import scala.language.postfixOps

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?"
    def isAlive : Boolean = true
    // Parentheses are necessary
    // apply can be overloaded!
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  // This is equivalent to the form above.
  // It's called infix notation or operator notation
  // It only works with methods with a single parameter
  // (For binary operators)
  println(mary likes "Inception")
  // "Operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  // We can also OVERLOAD the various operators!
  println(mary + tom)

  // ALL OPERATORS ARE METHODS!!!

  // Akka actors have ! ?

  // Prefix notation
  // (For unary operators)
  val x = -1
  val y = 1.unary_-
  println(x == y) // true
  // unary_ prefix only works with a few operators
  // - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply (special method name)
  println(mary.apply())
  // Whenever the compiler sees an object called
  // like a function it looks for an apply() implementation
  println(mary()) // equivalent!

  println(mary learnsScala)


}
