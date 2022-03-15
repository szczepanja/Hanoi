import scala.collection.mutable
import scala.io.StdIn.readLine
import scala.sys.exit
import Console.{BOLD, GREEN, MAGENTA, RED, RESET, UNDERLINED}

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
        Console.println(s"${RESET} ${RED} Wrong operator ${RESET}")
      }
    }
  }

  def initialState(): Unit = {
    Console.println(s"${RESET} ${GREEN} ${UNDERLINED} You are playing Tower of Hanoi. Move element to another Stack(from 0 to 2) starting from 0 ${RESET}")
    renderStacks()
  }

  def isGameFinished(): Unit = {
    if (disks(0).isEmpty && disks(1).isEmpty) {
      Console.println(s"${RESET} ${BOLD} ${MAGENTA} Congrats you won!!! 🥳🥳🥳 ${RESET}")
      exit()
    }
  }

  def renderStacks(): Unit = {
    for (d <- disks) println(s"${RESET} $d")
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
