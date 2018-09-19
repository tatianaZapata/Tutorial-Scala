package services

import javax.inject.{Inject, Singleton}
import tables.PersonsTable
import models.Person
import scala.concurrent.Future

@Singleton
class PersonServiceImpl @Inject() (dbConfigProvider: DatabaseConfigProvider) extends PersonService {
  import profile.api._
  private val persons = TableQuery[PersonsTable]
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  def crear(person: Person): Future[Int] = db.run(
    persons.map(p =>
      (p.name, p.lastName)) += (person.name, person.lastName)
  )

  def consultar(idPerson: Long): Future[Option[Person]] = db.run(
    persons.filter(_.id === id).result.headOption
  )

  def modificar(person: Person): Future[Int] = {
    val query = for { p <- persons
                      if p.id === person.id } yield p
    db.run(query.update(person))
  }

  def listar(): Future[Seq[Person]]= db.run { humans.result }

  def eliminar(idPerson: Long): Future[Int] = db.run(
    persons.filter(_.id === id).delete
  )
}
