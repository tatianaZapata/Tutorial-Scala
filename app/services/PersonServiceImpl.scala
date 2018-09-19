package services

import javax.inject.{Inject, Singleton}
import tables.PersonsTable
import models.Person
import play.api.db.slick.DatabaseConfigProvider
import scala.concurrent.Future
import slick.jdbc.JdbcProfile

@Singleton
class PersonServiceImpl @Inject() (dbConfigProvider: DatabaseConfigProvider) extends PersonService {

  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._ //Instanciar BD
  import profile.api._ //Consultas a BD
  private val persons = TableQuery[PersonsTable]

  def crear(person: Person): Future[Int] = db.run(
    persons.map(p =>
      (p.name, p.lastName)) += (person.name, person.lastName)
  )

  def consultar(idPerson: Long): Future[Option[Person]] = db.run(
    persons.filter(_.id === idPerson).result.headOption
  )

  def modificar(person: Person): Future[Int] = {
    val query = for { p <- persons
                      if p.id === person.id } yield p
    db.run(query.update(person))
  }

  def listar(): Future[Seq[Person]]= db.run { persons.result }

  def eliminar(idPerson: Long): Future[Int] = db.run(
    persons.filter(_.id === idPerson).delete
  )
}
