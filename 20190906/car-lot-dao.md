# Car Lot DAO

This project involves the creation of a Java DAO for an existing databae structure.

## Structure
Your solution must have the following structural elements:

* Your solution must be in an IntelliJ project called ```CarLotDao-Firstname-Lastname``` where Firstname and Lastname are your first and last name respectively.
* Your solution must use JdbcTemplates and prepared statements.
* Your solution must contain a full set of unit/integration tests.

## Methodology

* You must utilize TDD and Red Green Refactor when developing this project.
* You must use Pivotal Tracker to track your tasks for this project.

## Requirements/Features

This project is a DAO and relational database that keeps track of cars on a car lot. 

* Your DAO API must allow callers to create, read, read all, update, and delete Cars in the system. The system must also allow callers to find Cars by Make and to find Cars by Color.
* Your solution must be based on the database created by the SQL script below.

```sql
create schema if not exists car_lot;
use car_lot;

create table if not exists car (
	id		INT NOT NULL AUTO_INCREMENT,
  make	VARCHAR(50) NOT NULL,
  model	VARCHAR(50) NOT NULL,
  year	VARCHAR(4) NOT NULL,
  color	VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
);
```

---

© 2019 Trilogy Education Services





