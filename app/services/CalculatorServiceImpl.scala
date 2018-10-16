package services

class CalculatorServiceImpl extends CalculatorService {

  override def sumar(n1: Int, n2: Int): Int = {
    return n1 + n2
  }

  override def restar(n1: Int, n2: Int): Int = {
    return n1 - n2
  }

  override def multiplicar(n1: Int, n2: Int): Int = {
    return n1 * n2
  }

  override def dividir(n1: Int, n2: Int): Int = {
    return n1 / n2
  }

}
