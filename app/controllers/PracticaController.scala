package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class PracticaController @Inject()(cc: ControllerComponents) (implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {
    def prueba200 = Action {
      Ok(views.html.reto2template("Mostrando página - 200"))
    }
    def error401 = Action {
      Unauthorized(views.html.reto2template("Error 401 - UNAUTHORIZED"))
    }
    def error500 = Action {
      InternalServerError(views.html.reto2template("Error 500 - INTERNAL_SERVER_ERROR"))
    }
    def pruebaPost = Action {
      Ok(views.html.reto2template("POST"))
    }
  }


