package utils

import javax.inject.Inject
import play.api.mvc._
import play.api.libs.json._
import scala.concurrent.ExecutionContext
import play.api.mvc.Results._

class Validations @Inject() (parser: PlayBodyParsers) (implicit exec: ExecutionContext){

  //Analizar y validar el json
  def validateJson[A : Reads] = parser.json.validate(
    _.validate[A].asEither.left.map(e => BadRequest(JsError.toJson(e)))
  )
}
