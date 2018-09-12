package services

import javax.inject.{Inject, Singleton}

import scala.concurrent.Future

@Singleton
class PersonServiceImpl @Inject() (dbConfigProvider: DatabaseConfigProvider) extends PersonService {

  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  def crear(person: Person): Future[Int]{

  }
  def consultar(idPerson: Long): Future[Person]{

  }
  def modificar(person: Person): Future[Person]{

  }
  def listar(): Future[Seq[Person]]{

  }
  def eliminar(idPerson: Long): Future[Int]{

  }
}
