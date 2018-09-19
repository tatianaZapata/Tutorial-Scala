package controllers

import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}
import services.PersonServiceImpl
import scala.concurrent.ExecutionContext
import models.Person

class PersonController @Inject()(cc: ControllerComponents, personService: PersonServiceImpl) (implicit executionContext: ExecutionContext) extends AbstractController(cc){

  def crear = Action.async(parserValidation.validateJson[Person]) {
    request => {
      personService.crear(request.body).map(code => {
        Ok("Persona guardada")
      })
    }
  }

}
