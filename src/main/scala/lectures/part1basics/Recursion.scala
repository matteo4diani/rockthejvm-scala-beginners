package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: BigInt): BigInt =
    if (n <= 1) 1
    else n * factorial(n-1)

  // With recursive functions we
  // risk stack overflow errors
  // factorial(5000) fails miserably.
  // Having a single call to factorialHelper
  // in the else branch makes the call stack small
  def betterFactorial(n: BigInt): BigInt =
    @tailrec
    def factorialHelper(x: BigInt, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator) // TAIL RECURSION!!!
    // Tail Recursion = use recursive call as the LAST expression
    // Adding the @tailrec annotation tells Scala
    // that the function should be tail recursive,
    // if it's not we get a warning.
    factorialHelper(n, 1)

  println(betterFactorial(20000)) // This works!
  //println(factorial(20000)) // This breaks!

  def isPrime(n: Int): Boolean =
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t-1, (n % t != 0 || t == n) && isStillPrime)

    isPrimeTailRec(n, true)

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int =
    // As a rule of thumb,
    // we need as many accumulators as recursive calls
    @tailrec
    def fibonacciTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fibonacciTailRec(i+1, last + nextToLast, last)

    if (n <= 2) 1
    else fibonacciTailRec(2, 1, 1)

  println(fibonacci(8))


}
