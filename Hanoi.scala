import scala.collection.mutable
import scala.io.StdIn.readLine
import scala.sys.exit

object Hanoi extends App {
  val disks = Array(mutable.Stack[Int](0, 1, 2), mutable.Stack[Int](), mutable.Stack[Int]())

  def moveDisk(from: Int, to: Int): Unit = {
    try {
      if (disks(to).isEmpty || disks(from).head < disks(to).head) {
        disks(to).push(disks(from).head)
        disks(from) = disks(from).tail
      }
    } catch {
      case i: ArrayIndexOutOfBoundsException => {
        println("Wrong operator")
      }
    }
  }

  def initialState(): Unit = {
    println("You are playing Tower of Hanoi. Move elements to another Stack(from 0 to 2) starting from 0")
    renderStacks()
  }

  def isGameFinished(): Unit = {
    if (disks(0).isEmpty && disks(1).isEmpty) {
      println("Congrats you won")
      exit()
    }
  }

  def renderStacks(): Unit = {
    for (d <- disks) println(d)
  }

  def play(): Unit = {
    val x = readLine("Apply element you want to move: ").toInt
    val y = readLine("Choose number of Stack where you want to move element: ").toInt

    moveDisk(x, y)
    renderStacks()
    isGameFinished()
  }

  initialState()
  while (true) {
    play()
  }
}
