package utils

import javax.inject.Inject
import models.Person
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Reads._
import scala.concurrent.ExecutionContext
import play.api.mvc.Results._

class Validations @Inject() (parser: PlayBodyParsers) (implicit exec: ExecutionContext){

  //Convertir modelo a JsValue
  implicit val personWrites: Writes[Person] = (
    (JsPath \ "id").write[Long] and
    (JsPath \ "name").write[String] and
    (JsPath \ "lastName").write[String]
  )(unlift(Person.unapply))

  //Convertir JsValue a modelo
  implicit val personReads: Reads[Person] = (
    (JsPath \ "id").read[Long] and
    (JsPath \ "name").read[String]and
    (JsPath \ "lastName").read[String]
  )(Person.apply _)

  //Analizar y validar el json
  def validateJson[A : Reads] : BodyParser[A] = parser.json.validate(
    _.validate[A].asEither.left.map(e => BadRequest(JsError.toJson(e)))
  )

}
