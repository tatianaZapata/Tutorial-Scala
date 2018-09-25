package models

import play.api.libs.json.{JsPath, Reads, Writes}
import play.api.libs.functional.syntax._

case class Person(id: Option[Long], name: String, lastName: String)

object Person {

  //Pasar de modelo a JsValue
  implicit val personWrites: Writes[Person] = (
    (JsPath \ "id").writeNullable[Long] and
    (JsPath \ "name").write[String] and
    (JsPath \ "lastName").write[String]
  )(unlift(Person.unapply))

  //Pasar de JsValue a modelo
  implicit val personReads: Reads[Person] = (
    (JsPath \ "id").readNullable[Long] and
    (JsPath \ "name").read[String] and
    (JsPath \ "lastName").read[String]
  )(Person.apply _)

}
