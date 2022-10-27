package lectures.part2oop

import lectures.part2oop.GenericsList.MyLinkedList

import scala.language.postfixOps

object AnonymousClasses extends App {
  abstract class Animal {
    def eat: Unit
  }
  // We can instantiate anonymous classes
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahaha")
  }
  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, I'm $name")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Yo, I'm Jimbo")
  }

  jim sayHi



  /*
  [1, 2, 3].map(n * 2) = [2, 4, 6]
  [1, 2, 3, 4].filter(n % 2) = [2, 4]
  [1, 2, 3].flatMap(n => [n, n + 1]) = [1, 2, 2, 3, 3, 4]
  */
  val myList = GenericsList.Empty.add(1).add(2).add(3)
  println(myList.toString)


}
