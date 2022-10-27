package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 11)
  println(person)
  println(s"Age: ${person.age}")
  println(s"X: ${person.x}")
  person.greet()
  person.greet("Daniel")

  // This fails! Class parameters are NOT FIELDS
  // If we want a field we need to add the keyword val or var
  //println(person.name)

  val author = new Writer("Charles", "Dickens", 1812)
  // == on objects discriminates instances
  val impostor = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(impostor))

  val counter = new Counter

  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print

}
// Constructor
class Person(name: String, val age: Int) {
  // Class Body, not an expression per-se

  // this val x is available as a class field!
  val x = 2
  // Executed at instantiation
  println("Creating person...")

  // Name is not a class name but is available in the class definition
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  // We can overload methods: same name but
  // different signatures
  // = different # of parameters or different parameter type
  def greet(): Unit = println(s"Hi, I'm ${this.name}")

  // Multiple Constructors
  // An auxiliary constructor can only call other constructors
  // The Scala way is to supply default parameters
  // to the main constructor
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName: String = s"$firstName $surname"
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Counter(val count: Int = 0) {
  // if a field defines getters and setters we just
  // define it as a val
  //def count = n // This is bad practice!
  // This method respects immutability:
  // instances are fixed,
  // whenever you need to modify an instance
  // you need to return a new instance
  def inc = {
    println("Incrementing...")
    new Counter(count+1)
  }
  def dec = {
    println("Decrementing...")
    new Counter(count-1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }
  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(count)

}

