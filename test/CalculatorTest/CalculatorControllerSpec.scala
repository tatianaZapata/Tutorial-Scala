package CalculatorTest

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneServerPerSuite
import play.api.test.FakeRequest
import play.api.http.Status
import play.api.test.Helpers._

class CalculatorControllerSpec  extends PlaySpec with GuiceOneServerPerSuite{

  "Calculator routes#SUMA" should {
    "Suma ejecutada correctamente" in {
      //Arrange
        val request = FakeRequest(GET, "/calculadora/suma?n1=1&n2=2")
      //Act
        val result = route(app, request).get
      //Assert
        contentAsString(result) mustBe "El resultado de la suma es: 3"
    }

    "Bad request suma" in {
      //Arrange
        val request = FakeRequest(GET, "/calculadora/suma?n1=1")
      //Act
        val result = route(app, request).get
      //Assert
        assert(status(result) == Status.BAD_REQUEST)
    }
  }

  "Calculator routes#RESTA" should {
    "Resta ejecutada correctamente" in {
      //Arrange
        val request = FakeRequest(GET, "/calculadora/resta?n1=1&n2=2")
      //Act
        val result = route(app, request).get
      //Assert
        contentAsString(result) mustBe "El resultado de la resta es: -1"
    }

    "Bad request resta" in {
      //Arrange
        val request = FakeRequest(GET, "/calculadora/resta?n1=1")
      //Act
        val result = route(app, request).get
      //Assert
        assert(status(result) == Status.BAD_REQUEST)
    }
  }

  "Calculator routes#MULTIPLICACIÓN" should {
    "Multiplicación ejecutada correctamente" in {
      //Arrange
        val request = FakeRequest(GET, "/calculadora/multiplicacion?n1=5&n2=2")
      //Act
        val result = route(app, request).get
      //Assert
        contentAsString(result) mustBe "El resultado de la multiplicación es: 10"
    }

    "Bad request multiplicación" in {
      //Arrange
        val request = FakeRequest(GET, "/calculadora/multiplicacion?n1=5")
      //Act
        val result = route(app, request).get
      //Assert
        assert(status(result) == Status.BAD_REQUEST)
    }
  }

  "Calculator routes#DIVISIÓN" should {
    "División ejecutada correctamente" in {
      //Arrange
        val request = FakeRequest(GET, "/calculadora/division?n1=10&n2=2")
      //Act
        val result = route(app, request).get
      //Assert
        contentAsString(result) mustBe "El resultado de la división es: 5"
    }

    "Bad request división" in {
      //Arrange
        val request = FakeRequest(GET, "/calculadora/division?n1=10")
      //Act
        val result = route(app, request).get
      //Assert
        assert(status(result) == Status.BAD_REQUEST)
    }
  }

}
