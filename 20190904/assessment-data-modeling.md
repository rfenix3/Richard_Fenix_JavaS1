# Data Modeling: Amazon.com

This is a group activity in which you are to design a basic data model for Amazon.com using the techniques covered in the lesson. The instructor and TAs will be available to answer questions. Make sure you ask!!!

## Structure
Your solution must have the following structural elements:

* Your database design must be documented using a Draw.io ER diagram
* One ER diagram per team is sufficient
* Each team member must submit their own response to the reflection questions along with a copy of the group ERD.

## Methodology

Follow the basic process outlined in the lesson:

1. Start with the entities that must be tracked
1. Determine what attributes of those entitites are important
1. Determine the relationship needed between tables
1. Determine the data types of all attributes
1. Document everything in the ER diagram

Tip:

* Start small and then add tables
* Keep your design as flexible as possible in case new requirements arise

## Reflection Questions

1. What was the most difficult part of this model?
   The most difficult part for me was identifying the data relationships that needs to be established to come up with a normalized design.

1. What change along the way presented the biggest challenge?
   The change that presented the biggest challenge was coming up with bridge table between customer table and address table, and another bridge table between CustomerOrder table and Product table as the tasks needed much thought whether they will be good design or not.

1. How difficult or easy was it to change your model midstream?
  I still considered it easy to change my model midstream due to the simple design at this point. I imagine it would be much more difficult to implement any change in a production setting wherein there can be a hundred or more table and with live data on them.

1. Where there any columns on which your team didn't agree on a data type?
  None.

---

© 2019 Trilogy Education Services





