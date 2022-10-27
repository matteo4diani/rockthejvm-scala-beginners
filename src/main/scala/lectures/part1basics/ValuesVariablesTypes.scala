package lectures.part1basics

object ValuesVariablesTypes extends App {

  // VALUES (IMMUTABLE)
  // val are immutable
  val x: Int = 42
  println(x)
  // compiler infers types
  val y = 42
  println(y)
  println(x == y) // true
  // semicolons are allowed but discouraged
  val myString: String = "hello";
  val myBoolean: Boolean = false
  val myChar: Char = 'a'
  val myInt: Int = x
  val myShort: Short = 4613
  val myLong: Long = 3423420404320400777L
  val myFloat: Float = 2.0f
  val myDouble: Double = 3.14

  // VARIABLES (MUTABLE)
  var myVariable: Int = 4
  // side-effects are allowed
  myVariable = 5
}
