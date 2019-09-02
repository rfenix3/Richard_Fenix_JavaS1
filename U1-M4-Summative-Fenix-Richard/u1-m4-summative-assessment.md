# Summative Assessment: Spring Boot and REST 

In this assessment, you will build a simple REST web service.

## Structure
Your solution must have the following structural elements:

* Your solution must be in an IntelliJ project called `U1-M4-Summative-Lastname-Firstname`.
* Your project must be built using Spring Boot and Spring MVC. Initialize your project using ```start.spring.io```.
* Your project must have an in-memory DAO that follows the pattern shown in this module.
* Your REST API must accept and return data in JSON format where appropriate.
* Your REST API must be documented with Swagger. Save the `.yaml` file in the root of your project directory.

## Requirements/Features

This web service is a quote-of-the-day, word-of-the-day, and magic 8-ball service. You must implement and document the following REST APIs:

* Quote API:
  * URI: /quote
  * Method: GET
  * Request Body: None
  * Response Body: Quote
* Quote Object:
  * Author
  * Quote

* Word API
  * URI: /word
  * Method: GET
  * Request Body: None
  * Response Body: Definition
* Definition Object:
  * Word
  * Definition

* Magic 8-ball API:
  * URI: /magic
  * Method: POST
  * Request Body: Question
  * Response Body: Answer
* Answer Object:
  * Question
  * Answer

### Additional Requirements
* Your service must contain at least 10 quotes. Quotes must be served up at random.
* Your service must contain at least 10 words and their corresponding definitions. Words and definitions must be served up at random.
* Your service must contain at least 6 different magic 8-ball responses. 8-ball answers must be served up at random.

---
© 2019 Trilogy Education Services
