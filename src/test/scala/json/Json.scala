package json

sealed trait Json

case class JSeq(elems: List[Json]) extends Json

case class JObj(bindings: Map[String, Json]) extends Json

case class JNum(num: Double) extends Json

case class JStr(str: String) extends Json

case class JBool(b: Boolean) extends Json

case object JNull extends Json

