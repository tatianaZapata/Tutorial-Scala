package services

trait CalculatorService {

  def sumar(n1: Int, n2: Int): Int
  def restar(n1: Int, n2: Int): Int
  def multiplicar(n1: Int, n2: Int): Int
  def dividir(n1: Int, n2: Int): Int

}
