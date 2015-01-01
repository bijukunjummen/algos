package bucket

case class Pouring(capacity: Vector[Int], initialState: Vector[Int]){
	type State = Vector[Int]
	
	trait Move {
	  def change(state: State): State
	}
	
	case class Pour(from: Int, to: Int) extends Move {
	  def change(state: State) = {
	    val amount = state(from) min (capacity(to) - state(to))
	    state updated (from, state(from) - amount)  updated (to, state(to) + amount)
	  }
	}
	
	class Path(history: List[Move], val endState: State) {
	  def extend(move: Move) = new Path(move :: history, move change endState)
	  override def toString = (history.reverse mkString " ") + "--->" + endState 
	}

	val glasses = 0 until capacity.length
	
	val moves = for {
	  from <- glasses
	  to <- glasses
	  if (from != to)
	} yield Pour(from, to)
	
	val initialPath = new Path(Nil, initialState)
	
	def from(paths: Set[Path], explored: Set[State]): Stream[Set[Path]] = {
	  if (paths.isEmpty) Stream.empty
	  else {
	    val more = for {
	      path <- paths
	      next <- moves map path.extend
	      if !(explored contains next.endState)
	    } yield next
	    paths #:: from(more, explored ++ (more map (_.endState)))
	  }
	}
	
	val pathSets = from(Set(initialPath), Set(initialState))
	
	def solution(target: State): Stream[Path] = {
    for {
      pathSet <- pathSets
      path <- pathSet
      if (path.endState == target)
    } yield path
  }
	
}