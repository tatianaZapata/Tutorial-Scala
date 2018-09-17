package services

import javax.inject.{Inject, Singleton}
import tables.PersonsTable

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

  def consultar(idPerson: Long): Future[Person]{

  }
  def modificar(person: Person): Future[Person]{

  }
  def listar(): Future[Seq[Person]]{

  }
  def eliminar(idPerson: Long): Future[Int]{

  }
}
