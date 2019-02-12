package pour

import io.vavr.collection.List
import io.vavr.collection.Set
import io.vavr.collection.Stream
import io.vavr.kotlin.hashSet
import io.vavr.kotlin.list
import io.vavr.kotlin.toVavrList
import kotlin.math.min

typealias State = List<Int>

interface Move {
    fun change(state: State): State
}

data class Empty(val glass: Int) : Move {
    override fun change(state: State): State {
        return state.update(glass, 0)
    }

    override fun toString(): String {
        return "Empty($glass)"
    }

}

data class Fill(val glass: Int, val capacity: List<Int>) : Move {
    override fun change(state: State): State {
        return state.update(glass, capacity[glass])
    }

    override fun toString(): String {
        return "Fill($glass)"
    }
}

data class Pour(val from: Int, val to: Int, val capacity: List<Int>) : Move {
    override fun change(state: State): State {
        val amount = min(state[from], capacity[to] - state[to])

        return state
                .update(from, state[from] - amount)
                .update(to, state[to] + amount)
    }

    override fun toString(): String {
        return "Pour($from,$to)"
    }
}

data class Path(val history: List<Move>, val endState: State) {
    fun extend(move: Move) = Path(history.prepend(move), move.change(endState))

    override fun toString(): String {
        return history.reverse().mkString(" ") + " ---> " + endState
    }
}

class Pouring(val capacity: List<Int>, val initialState: State) {
    private fun allMoves(): List<Move> {
        val emptyMoves: List<Move> = (0 until capacity.length()).map { Empty(it) }.toVavrList()
        val fillMoves: List<Move> = (0 until capacity.length()).map { Fill(it, capacity) }.toVavrList()
        val pourMoves: List<Move> = (0 until capacity.length()).flatMap { from ->
            (0 until capacity.length()).filter { to -> from != to }.map { to ->
                Pour(from, to, capacity)
            }
        }.toVavrList()

        return emptyMoves.appendAll(fillMoves).appendAll(pourMoves)
    }

    val moves = allMoves()
    val initialPath = Path(list(), initialState)

    fun from(paths: Set<Path>, explored: Set<State>): Stream<Set<Path>> {
        if (paths.isEmpty) {
            return Stream.empty()
        } else {
            val more = paths.flatMap { path ->
                moves.map { move ->
                    val next: Path = path.extend(move)
                    next
                }.filter { !explored.contains(it.endState) }
            }
            return Stream.cons(paths) { from(more, explored.addAll(more.map { it.endState })) }
        }
    }
    val pathSets = from(hashSet(initialPath), hashSet())

    fun solution(target: State): Stream<Path> {
        return pathSets.flatMap { it }.filter{ path -> path.endState == target}
    }
}

