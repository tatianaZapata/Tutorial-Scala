package PersonsTest

import models.Person
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import services.PersonService
import scala.concurrent.Future
import org.mockito.Mockito._

class PersonServiceSpec extends PlaySpec with MockitoSugar with GuiceOneAppPerSuite with ScalaFutures{

  val mockPersonService = mock[PersonService]

  "\n\nPersonService#CREAR" should {
    "Se creó una persona correctamente" in {
      //Arrange
        val person = mock[Person]
        when(mockPersonService.crear(person: Person)) thenReturn Future.successful(1)
      //Act
        val futureResult: Future[Int] = mockPersonService.crear(person)
        val result = futureResult.futureValue
      //Assert
        assert( result == 1)
    }
  }

  "\nPersonService#CONSULTAR" should {
    "Persona consultada correctamente" in {
      //Arrange
        val idPerson = 2L
        val person = mock[Person]
        when(mockPersonService.consultar(idPerson)) thenReturn Future.successful(Option(person))
      //Act
        val futureResult: Future[Option[Person]] = mockPersonService.consultar(idPerson)
        val result = futureResult.futureValue
      //Assert
        result mustBe a [Option[Person]]
    }
  }

  "\nPersonService#LISTAR" should {
    "Lista de personas" in {
      //Arrange
        val person1, person2 = mock[Person]
        val listPersons: List[Person] = List(person1, person2)
        when(mockPersonService.listar()) thenReturn Future.successful(listPersons)
      //Act
        val futureResult: Future[Seq[Person]] = mockPersonService.listar()
        val result = futureResult.futureValue
      //Assert
        result must have length 2
    }
  }
}