package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {
  @tailrec
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n-1, n*acc)

  // The wrapper function isn't needed anymore
  val fact10 = trFact(10)

  // Default values come with their own set of challenges
  // Leading parameters with default values are misleading
  // to the compiler:
  // Either we:
  // 1. Pass every leading argument
  // 2. Name the argument

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving picture...")

  savePicture(format="bmp")
}
