package PersonsTest

import models.Person
import services.PersonService
import scala.concurrent.Future

class PersonServiceMock extends PersonService{

  override def crear(person: Person): Future[Int] = Future.successful(1)
  override def consultar(idPerson: Long): Future[Option[Person]] = Future.successful(None)
  override def modificar(person: Person): Future[Int] = Future.successful(1)
  override def listar(): Future[Seq[Person]] = Future.successful(List())
  override def eliminar(idPerson: Long): Future[Int] = Future.successful(1)

}
