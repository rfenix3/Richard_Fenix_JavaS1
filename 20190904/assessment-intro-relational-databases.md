# Introduction to Relational Databases

Respond to the following reflection questions.

* Why is it important to have a good understanding of the underlying business when creating a data model?
  When creating a data model, it is important for us to understand the business' needs at the onset as our data model should be able to answer key business-related questions using our data model in an efficient way. Our data model should have the right level of detail to avoid unnecessary storage of useless data that translate to cost savings and time savings. For instance, a car wash company would only need the type of car (being washed) in its data model. It doesn't need to store car engine specification anymore. While a car repair shop would need engine specification detail including an engine's individual parts. 
With the proper data model design, our application should be able to run queries that can extract and create important reports and key performance indicators(KPI's) that the business deem important, without putting too much strain on the system. 

* Compare and contrast data and metadata.
Data is the information we store while metadata are the information about the data. Metadata is data about data. Examples of metadata are String, Numeric, Primary Key, Foreign Key, Not Null. 

* What is the difference between an entity and an attribute?
An entity is a table that stores records in a database. Attributes are part of tables. They are the column names of tables.

* What is a primary key?
In a RDBMS, Primary keys are attributes of table. Primary keys should be unique and not null. They uniquely identify a row in a table.

* What is a foreign key?
In a RDMS, Foreign keys are table columns that references a primary key in another table. Their value should exist in a primary key table.

* What is the purpose of relationships in a relational database?
Relationships in a relational database allows us to design efficient storage of information. The relationships in a relationship database allows us to link different tables through primary keys and foreign keys, thus enabling us to run SQL to extract and manipulate database data more easily.

* What does a row represent in a relational database?
A row is also called a tuple. It is a single record in a relational database table.

---

© 2019 Trilogy Education Services





