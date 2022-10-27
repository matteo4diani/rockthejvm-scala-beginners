package lectures.part2oop

object Inheritance extends App{

  class Animal {
    val creatureType: String = "wild"
    def eat = println("munchmunch")
    private def nom = println("nomnom")
    protected def baz = println("bazbaz")

  }

  // Scala offers single class inheritance
  // meaning you can only extend one class.
  // A sealed class can only be extended in the file
  // where its declared
  sealed class Cat extends Animal {
    // Prevent overrides with final
    final def crunch: Unit = {
      baz
      println("crunchcrunch")
    }
  }

  val cat = new Cat

  cat.eat // This succeeds because public (no mod) is inherited
  //cat.nom // This fails because nom is private
  //cat.baz // This fails because baz is protected
  cat.crunch // This succeeds because inside the child protected methods are allowed

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)
  // We can override fields directly in the constructor
  // This is equivalent, just syntactic sugar
  // A final class cannot be extended
  final class Dog(override val creatureType: String) extends Animal {
    //override val creatureType: String = "domesticated" // This is valid!
    override def eat = {
      // SUPER
      super.eat
      println("chafchaf")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // Type Substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  // Although unknownAnimal is declared as Animal,
  // being a dog he "chafchaf"s while eating
  unknownAnimal.eat // chafchaf
}
