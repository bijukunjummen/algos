package euler.notworking

import org.scalatest.FunSuite
import scala.collection.immutable.Stream.consWrapper

class Problem015TestNotWorking extends FunSuite with Solver {
  val startPos = Position(0, 0)
  val goalPos = Position(20, 20)
  val grid = Grid(20, 20)

  test("Lattice paths") {
    pathsFromStart.take(10).foreach(println)
  }
}

trait Lattice {
  sealed abstract class Move
  case object Right extends Move
  case object Down extends Move

  case class Position(r: Int, c: Int) {
    def down = copy(r + 1, c)
    def right = copy(r, c + 1)
    def nextMoves: List[(Position, Move)]  = {
      (down, Down) :: (right, Right) :: Nil
    }
    def legalMoves = nextMoves filter { case (p,m) => p.isLegal }
    def isLegal = (r <= grid.nr && c <= grid.nc)
  }

  case class Grid(nr: Int, nc: Int)
  val startPos: Position
  val goalPos: Position
  val grid: Grid
}

trait Solver extends Lattice {
  def done(p: Position) = (p == goalPos)
  def neighborsWithHistory(p: Position, history: List[Move]): Stream[(Position, List[Move])] = {
    p.legalMoves.toStream.map {case (p, m) => (p, m :: history)}
  }
  
  def from(initial: Stream[(Position, List[Move])]): Stream[(Position, List[Move])] = {
    if (initial.isEmpty) Stream.empty
    else {
      val more = for {
        (p, h) <- initial
        next <- neighborsWithHistory(p, h)
      } yield next
      initial #::: from(more)
    }
  }
  
  lazy val pathsFromStart = from(List((startPos, List())).toStream)
  lazy val pathsToGoal = for {
    (p, h) <- pathsFromStart
    if (p == goalPos)
  } yield (p, h)
}