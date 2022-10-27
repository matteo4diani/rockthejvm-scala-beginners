package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit =
    println("by value: " + x)
    println("by value: " + x)

  def calledByName(x: => Long): Unit =
    println("by name: " + x)
    println("by name: " + x)

  // Evaluate System.nanoTime(), use it throughout the function
  calledByValue(System.nanoTime())
  // In Call-By-Name the expression is passed LITERALLY
  // (like an eval with validation)
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34) // This breaks!
  printFirst(34, infinite()) // This works!

}
