package graph

import scala.collection.IndexedSeq

class EdgeWeightedGraph(val verticies: Int) {
	val adj = IndexedSeq.fill(verticies)(List.empty[Edge])
}