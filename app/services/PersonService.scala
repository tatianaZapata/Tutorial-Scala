package services

import models.Person
import scala.concurrent.Future

trait PersonService {
  def crear(person: Person): Future[Int]
  def consultar(idPerson: Long): Future[Option[Person]]
  def modificar(person: Person): Future[Int]
  def listar(): Future[Seq[Person]]
  def eliminar(idPerson: Long): Future[Int]
}
