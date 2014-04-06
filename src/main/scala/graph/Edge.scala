package graph

class Edge(v: Int, w: Int, weight: Double) {
	def either = v
	def other(vertex: Int) = if (vertex == v) w else v
}