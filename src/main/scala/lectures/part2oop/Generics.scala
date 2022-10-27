package lectures.part2oop

object Generics extends App {
  // generic classes
  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
  }
  class MyMap[Key, Val]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]
  val map = new MyMap[String, List[Int]]
  val emptyList = MyList.empty[Int]

  // generic methods
  object MyList {
    // Companions have access to each others private attributes!
    def empty[A]: MyList[A] = ???

    // Variance problem:
    // If Cat extends Animal,
    // does List[Cat] extend List[Animal]?
    class Animal
    class Cat extends Animal
    class Dog extends Animal
    // 1. Yes, List[Cat] extends List[Animal] = COVARIANCE
    class CovariantList[+A]
    val animal: Animal = new Cat
    val animalList: CovariantList[Animal] = new CovariantList[Cat] // This works because +A makes CovList covariant
    //animalList.add(new Dog) // HARD QUESTION!!! For a covariant list this does not work!

    // 2. No = INVARIANCE
    class InvariantList[A]
    val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

    // 3. Hell No = CONTRAVARIANCE
    class ContravariantList[-A]
    val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

    // Example:
    class Trainer[-A]
    // If a generalist can satisfy my needs,
    // I can use contravariance
    val trainer: Trainer[Cat] = new Trainer[Animal]

    // Bounded types <: (accept subtype) >: (accept supertype)
    class Cage[A <: Animal](animal: A)
    val cage = new Cage(new Dog)
  }
}
