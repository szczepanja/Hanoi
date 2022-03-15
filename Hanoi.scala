import scala.collection.mutable
import scala.io.StdIn.readLine
import scala.sys.exit

object Hanoi extends App {
  val disks = Array(mutable.Stack[Int](0, 1, 2), mutable.Stack[Int](), mutable.Stack[Int]())

  def moveDisk(from: Int, to: Int): Unit = {
    if (disks(to).isEmpty || disks(from).head < disks(to).head) {
      disks(to).push(disks(from).head)
      disks(from) = disks(from).tail
    } else {
      println("Wrong move")
    }
  }

  def play(): Unit = {
    val x = readLine("Apply x: ").toInt
    val y = readLine("Apply y: ").toInt

    moveDisk(x, y)
    for (d <- disks) println(d)
  }

  println("You are playing Tower of Hanoi. Move elements to another Stack(from 0 to 2) starting from 0")
  while (true) {
    play()
  }
}