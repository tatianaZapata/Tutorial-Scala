package tables;

import models.Person
import slick.jdbc.MySQLProfile.api._
import slick.lifted.ProvenShape

class PersonsTable(tag: Tag) extends Table[Person](tag, "persons") {
  def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def lastName = column[String]("name")

  //def * : ProvenShape[Person] = (id, name, lastName) <> ((Person.apply _).tupled, Person.unapply)
  def * = (id, name, lastName) <> (Person.tupled, Person.apply _, Person.unapply _)
}