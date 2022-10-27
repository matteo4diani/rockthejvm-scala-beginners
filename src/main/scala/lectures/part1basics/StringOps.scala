package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2)) //zero-indexed
  println(str.substring(0, 5))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.length)

  val numberString = "45"
  val number = numberString.toInt
  // +: prepend
  // :+ append
  println('a' +: numberString  :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // String Interpolators
  // S-INTERPOLATORS
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val birthdayGreeting = s"Hello my name is $name and I will be turning ${age + 1}"
  println(greeting)

  // F-INTERPOLATORS
  val speed = 1.2f
  // F-INTERPOLATORS interpolate with printf decorators
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)
  // F-Interpolators check for compile errors
  val x = 1.1f
  //val str = f"$x%3d"

  // RAW INTERPOLATORS
  println(raw"This is a \n newline") // This gets printed!

  val escaped = "This is a \n newline" // This gets rendered!
  println(raw"$escaped")

}
