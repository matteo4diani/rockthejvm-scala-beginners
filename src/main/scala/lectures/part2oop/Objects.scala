package lectures.part2oop

object Objects extends App {
  // Scala does NOT have
  // class-level functionality (static)
  // the static functionality
  // of a class goes in an object.
  // This pattern is called
  // Companion
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false
    // Factory Pattern in Scala
    def apply(name: String): Person = new Person(name)
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }
  class Person(val name: String) {
    // instance-level functionality
  }
  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val mary = Person("Mary")
  val john = Person("John")
  println(mary == john)
  val bobby = Person(mary, john)
  println(bobby.name)

  // Scala Applications
  // A Scala App is only a Scala object
  // with a very important method
  // def main(args: Array[String]): Unit
  // Since Scala targets the JVM
  // the entry-point MUST be
  // a static void main(String[] args)
}
