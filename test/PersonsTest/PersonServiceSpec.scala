package PersonsTest

import models.Person
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.Application
import play.api.inject.bind
import play.api.inject.guice.GuiceApplicationBuilder
import services.PersonService
import scala.concurrent.Future
import org.scalatest.Matchers._

class PersonServiceSpec extends PlaySpec with MockitoSugar with GuiceOneAppPerSuite with ScalaFutures{

  override def fakeApplication(): Application = new GuiceApplicationBuilder()
    .overrides(bind[PersonService].to[PersonServiceMock])
    .build()

  val personService = app.injector.instanceOf(classOf[PersonService])

  "PersonService#crear" should {
    "Se creó una persona correctamente" in {
      // val personServices = mock[PersonServiceImpl]
      val person = mock[Person]
      val futureResult: Future[Int] = personService.crear(person)
      val result = futureResult.futureValue
      // result should equal(1)
      assert( result == 1)
    }
  }

  "PersonService#consultar" should {
    "No existe la persona consultada" in {
      val idPerson = 1L
      val person = mock[Person]
      val futureResult: Future[Option[Person]] = personService.consultar(idPerson)
      val result = futureResult.futureValue
      // result should equal(None)
      assert( result == None)
    }
  }

  "PersonService#listar" should {
    "Lista de personas" in {
      val person = mock[Person]
      val futureResult: Future[Seq[Person]] = personService.listar()
      val result = futureResult.futureValue
      result should have length 0
    }
  }
}