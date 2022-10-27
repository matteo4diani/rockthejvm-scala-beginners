package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // RHS is an expression
  println(x)
  println(2 + 3 * 4)
  // MATH: + - * /
  // BITWISE: & | ^ (XOR)
  // BITWISE: << >> >>> (right shift with zero extension,
  // specific to Scala)
  // RELATIONAL: == != > < <= >=
  // LOGIC: ! && ||
  // VARIABLE MODIFIERS (SIDE-FX): += -= *= /=
  var myVariable = 2
  myVariable /= 2
  println(myVariable)
  // Instructions (DO) VS Expressions (VALUE)
  // IF expression
  // In Scala IF is an expression, not an instruction
  // thus it returns a value by default
  val myCondition = true
  val myConditionedValue = if(myCondition) 5 else 3
  println(myConditionedValue)
  println(if(myCondition) 5 else 3)

  // THIS IS BAD PRACTICE IN SCALA!!!
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // Everything in Scala is an expression
  // Only definitions (val, class, object, package)
  // are not expressions

  val weirdValue = (myVariable = 3) // Unit === void
  println(weirdValue) // () <- This is Unit, the empty set
  // Side-FX in Scala are just expressions that return Unit

  val myWhile = while (i < 10) {
    println(i)
    i += 1
  }
  println(myWhile) // ()

  // Code blocks
  // Code blocks are special kinds of expressions

  val myCodeBlock = {
    val t = 2
    val z = t + 1
    if (z > 2) "hello" else "goodbye"
  }
  println(myCodeBlock)
  // The value of the block is the value of its last expression
  // So the type of myCodeBlock is String
}
