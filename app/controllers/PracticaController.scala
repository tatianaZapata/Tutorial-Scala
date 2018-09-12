package controllers

import play.api.libs.json._
import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class PracticaController @Inject()(cc: ControllerComponents) (implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {
    def prueba200 = Action {
      val testJsString: JsString = new JsString("test")
      val testJsNumber: JsNumber = new JsNumber(30)
      println("JsString: "+ testJsString)
      println("JsNumber: "+ testJsNumber)

      val jsonTest: JsValue = Json.parse("""
      {
        "name" : "Watership Down",
        "location" : {
          "lat" : 51.235685,
          "long" : -1.309197
        },
        "residents" : [ {
          "name" : "Fiver",
          "age" : 4,
          "role" : null
        }, {
          "name" : "Bigwig",
          "age" : 6,
          "role" : "Owsla"
        } ]
      }
      """)

      println(jsonTest)

      //Buscar valores en json
      val lat = (jsonTest \ "location" \ "lat").get
      println("Obteniendo valor lat: " + lat)
      val name = jsonTest("name")
      println("Obteniendo valor name: " + name)

      //Validate
      val nameResult: JsResult[String] = (jsonTest \ "name").validate[String]

      // Pattern matching
      nameResult match {
        case s: JsSuccess[String] => println("Name: " + s.get)
        case e: JsError => println("Errors: " + JsError.toJson(e).toString())
      }

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



