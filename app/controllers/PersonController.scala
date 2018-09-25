package controllers

import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}
import services.PersonServiceImpl

import scala.concurrent.ExecutionContext
import models.Person
import play.api.libs.json._
import play.api.libs.json.Json
import play.api.libs.functional.syntax._
import utils.Validations

class PersonController @Inject()(cc: ControllerComponents, personService: PersonServiceImpl, validations: Validations)(implicit executionContext: ExecutionContext) extends AbstractController(cc){
/*
  def create = Action.async {
    request => {
      personService.crear(request.body).map(code => {
        Ok(s"A human spawned")
      })
    }
  }
  def list = Action.async {
    personService.listar().map { persons =>
      Ok(Json.toJson(persons))
    }
  }*/
}
