package controllers

import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}
import services.CalculatorServiceImpl

class CalculatorController @Inject()(cc: ControllerComponents, calculatorService: CalculatorServiceImpl) extends AbstractController (cc){

  def sumar(n1: Int, n2: Int) = Action {
    val result = calculatorService.sumar(n1, n2)
    Ok("El resultado de la suma es: " + result)
  }

  def restar(n1: Int, n2: Int) = Action {
    val result = calculatorService.restar(n1, n2)
    Ok("El resultado de la resta es: " + result)
  }

  def multiplicar(n1: Int, n2: Int)= Action {
    val result = calculatorService.multiplicar(n1, n2)
    Ok("El resultado de la multiplicación es: " + result)
  }

  def dividir(n1: Int, n2: Int)= Action {
    val result = calculatorService.dividir(n1, n2)
    Ok("El resultado de la división es: " + result)
  }

}
