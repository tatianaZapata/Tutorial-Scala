package tables;

import models.Person
import slick.jdbc.MySQLProfile.api._
import slick.lifted.ProvenShape

class Persons(tag: Tag) extends Table[Person](tag, _tableName = "Persons") {
  def id : Rep[Option[Long]] = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  def name : Rep[String] = column[String]("name")
  def lastName : Rep[String]= column[String]("lastName")
  def * : ProvenShape[Person] = (id, name, lastName) <> ((Person.apply _).tupled, Person.unapply)
}