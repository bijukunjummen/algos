import json._
val data = JObj(Map(
  "firstName" -> JStr("John"),
  "lastName" -> JStr("Smith"),
  "address" -> JObj(Map(
    "street" -> JStr("6 Baker St"),
    "state" -> JStr("NY"),
    "zip" -> JNum(10021)
  ))
))



def showJson(json: Json): String = {
  json match {
    case JObj(bindings) => {
      val assocs = bindings.map(t => t match {
        case (k, v) => "\"" + k + "\": " + showJson(v)
      })

      "{" + (assocs mkString( ","))
    }
  }
}