package pour

import io.vavr.collection.List
import io.vavr.collection.Set
import io.vavr.collection.Stream
import io.vavr.kotlin.hashSet
import io.vavr.kotlin.list
import io.vavr.kotlin.toVavrList
import kotlin.math.min

data class Cup(val level: Int, val capacity: Int) {
    override fun toString(): String {
        return "Cup($level/$capacity)"
    }
}

typealias State = List<Cup>

interface Move {
    fun change(state: State): State
}

data class Empty(val glass: Int) : Move {
    override fun change(state: State): State {
        val cup = state[glass]
        return state.update(glass, cup.copy(level = 0))
    }

    override fun toString(): String {
        return "Empty($glass)"
    }
}

data class Fill(val glass: Int) : Move {
    override fun change(state: State): State {
        val cup = state[glass]
        return state.update(glass, cup.copy(level = cup.capacity))
    }

    override fun toString(): String {
        return "Fill($glass)"
    }
}

data class Pour(val from: Int, val to: Int) : Move {
    override fun change(state: State): State {
        val cupFrom = state[from]
        val cupTo = state[to]
        val amount = min(cupFrom.level, cupTo.capacity - cupTo.level)

        return state
                .update(from, cupFrom.copy(cupFrom.level - amount))
                .update(to, cupTo.copy(level = cupTo.level + amount))
    }

    override fun toString(): String {
        return "Pour($from,$to)"
    }
}

data class Path(val initialState: pour.State, val endState: State, val history: List<Move>) {
    fun extend(move: Move) = Path(initialState, move.change(endState), history.prepend(move))

    override fun toString(): String {
        return history.reverse().mkString(" ") + " ---> " + endState
    }
}

class Pouring(private val initialState: State) {
    private fun allMoves(): List<Move> {
        val count = initialState.length()
        val emptyMoves: List<Move> = (0 until count).map { Empty(it) }.toVavrList()
        val fillMoves: List<Move> = (0 until count).map { Fill(it) }.toVavrList()
        val pourMoves: List<Move> = (0 until count).flatMap { from ->
            (0 until initialState.length()).filter { to -> from != to }.map { to ->
                Pour(from, to)
            }
        }.toVavrList()

        return emptyMoves.appendAll(fillMoves).appendAll(pourMoves)
    }

    private val moves = allMoves()
    private val initialPath = Path(initialState, initialState, list())

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
        return pathSets.flatMap { it }.filter { path -> path.endState == target }
    }
}