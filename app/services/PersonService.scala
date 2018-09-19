package services

trait PersonService {
  def crear(person: Person): Future[Int]
  def consultar(idPerson: Long): Future[Option[Person]]
  def modificar(person: Person): Future[Person]
  def listar(): Future[Seq[Person]]
  def eliminar(idPerson: Long): Future[Int]
}
