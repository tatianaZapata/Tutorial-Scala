package controllers

import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}
import services.PersonServiceImpl
import scala.concurrent.ExecutionContext
import models.Person
import utils.Validations
import play.api.libs.json._
import models.Person.personReads

class PersonController @Inject()(cc: ControllerComponents, personService: PersonServiceImpl, validations: Validations)(implicit executionContext: ExecutionContext) extends AbstractController(cc){

  def insert = Action.async(validations.validateJson[Person]) {
    request => {
      personService.crear(request.body).map(code => {
        Ok("Se creó una persona correctamente")
      })
    }
  }

  def select(id: Long) = Action.async{
    personService.consultar(id).map(person => {
      if (person.isEmpty){
        NotFound("No existe la persona consultada")
      }else{
        println("------- Consultar: " + person)
        Ok(Json.toJson(person))
      }
    })
  }

  def update =  Action.async(validations.validateJson[Person]) {
    request => {
      personService.modificar(request.body).map(code => {
        Ok("Se modificó la persona correctamente")
      })
    }
  }

  def delete(id: Long) =  Action.async {
    personService.eliminar(id).map(code => {
      Ok("Se modificó la persona correctamente")
    })
  }

  def list = Action.async {
    personService.listar().map( personsList => {
      Ok(Json.toJson(personsList))
    })
  }

}
