package lectures.part1basics

object Functions extends App {
  // The compiler can infer the return type
  def myFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(myFunction("Hello", 77))

  def myParameterlessFunction(): Int = 42
  println(myParameterlessFunction())

  // Curly braces are not necessary with correct indentation
  // Scala allows me to define recursive functions
  // In recursive functions we need to explicit the return type
  // Which can also be Unit
  def myRepeatedFunction(a: String, n: Int): String =
    if (n == 1) a
    else a + myRepeatedFunction(a, n-1)

  // When you need loops in a functional language, use recursion
  println(myRepeatedFunction("ashu", 10))

  // We need side-effects when we want to perform actions
  // that have nothing to do with the computation itself
  def myFunctionWithSideEffects(str: String): Unit = println(str)

  myFunctionWithSideEffects("Scala")

  // Code-blocks allow for private val, var and functions

  def myBigFunction(n: Int): Int = {
    def mySmallerFunction(a: Int, b: Int): Int = a + b

    mySmallerFunction(n, n-1)
  }

  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)

  println(factorial(1))
  println(factorial(2))
  println(factorial(3))

  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)

  println(fibonacci(1))
  println(fibonacci(2))
  println(fibonacci(3))
  println(fibonacci(4))
  println(fibonacci(5))

  def isPrime(n: Int): Boolean =
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else if (t == n) isPrimeUntil(t-1)
      else n % t != 0 && isPrimeUntil(t-1)
    isPrimeUntil(n)

  println(isPrime(13))
  println(isPrime(13*17))






}
