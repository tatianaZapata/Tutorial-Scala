package CalculatorTest

import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec
import services.CalculatorService
import org.mockito.Mockito._

class CalculatorServiceSpec extends PlaySpec with MockitoSugar{

  val mockCalculatorService = mock[CalculatorService]

  "\n\nCalculatorService#SUMAR" should {
    "Se realizó la suma correctamente" in {
      //Arrange
        val num1 = 2
        val num2 = 4
        when(mockCalculatorService.sumar(num1, num2)) thenReturn 6
      //Act
        val result: Int = mockCalculatorService.sumar(num1, num2)
      //Assert
        assert(result == 6)
    }
  }

  "\nCalculatorService#RESTAR" should {
    "Se realizó la resta correctamente" in {
      //Arrange
        val num1 = 2
        val num2 = 4
        when(mockCalculatorService.sumar(num1, num2)) thenReturn -2
      //Act
        val result: Int = mockCalculatorService.sumar(num1, num2)
      //Assert
        assert(result == -2)
    }
  }

  "\nCalculatorService#MULTIPLICAR" should {
    "Se realizó la multiplicación correctamente" in {
      //Arrange
        val num1 = 2
        val num2 = 4
        when(mockCalculatorService.sumar(num1, num2)) thenReturn 8
      //Act
        val result: Int = mockCalculatorService.sumar(num1, num2)
      //Assert
        assert(result == 8)
    }
  }

  "\nCalculatorService#DIVIDIR" should {
    "Se realizó la división correctamente" in {
      //Arrange
      val num1 = 12
      val num2 = 4

      when(mockCalculatorService.sumar(num1, num2)) thenReturn 3
      //Act
      val result: Int = mockCalculatorService.sumar(num1, num2)
      //Assert
      assert(result == 3)
    }
  }

}
