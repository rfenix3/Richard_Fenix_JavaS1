# Swagger Assessments

Document the following REST APIs using OpenAPI 3.0,0 and the Swagger Editor. 

## Structure
Your solution must have the following structural elements:

* Use OpenAPI 3.0.0
* Use YAML
* Save each API in the YAML file specified in the requirements below


## Requirements/Features
Document each of the following REST APIs using OpenAPI 3.0.0, YAML, and the Swagger Editor

### Hello, REST

* Filename
  * helloRestService-lastname-firstname.yaml

* URL: /hello/{name}
* HTTP Method: GET
* RequestBody: None
* Response: "Hello, {name}"


### Day Converter

* Filename
  * dayConverter-lastname-firstname.yaml

* URL: /day/{dayNumber}
* HTTP Method: GET
* RequestBody: None
* Response: The name of the day that the number converts to
* Error: if the input is out of range

### Month Converter

* Filename
  * monthConverter-lastname-firstname.yaml

* URL: /day/{monthNumber}
* HTTP Method: GET
* RequestBody: None
* Response: The name of the month that the number converts to
* Error: if the input is out of range


### REST Calculator

* Filename
  * restCalculator-lastname-firstname.yaml

* URL: /add
* HTTP Method: POST
* RequestBody: JSON object with operand1 and operand2
* Response: Sum of operand1 and operand2
* Error: if missing operand or if operands are not both numbers

* URL: /mult
* HTTP Method: POST
* RequestBody: JSON object with operand1 and operand2
* Response: Product of operand1 and operand2
* Error: if missing operand or if operands are not both numbers

* URL: /subtract
* HTTP Method: POST
* RequestBody: JSON object with operand1 and operand2
* Response: Difference of operand1 and operand2
* Error: if missing operand or if operands are not both numbers

* URL: /divide
* HTTP Method: POST
* RequestBody: JSON object with operand1 and operand2
* Response: Quotient of operand1 and operand2
* Error: if missing operand or if operands are not both numbers


### Weather API

* Filename
  * weatherAPI-lastname-firstname.yaml

* URL: /temp/{zipcode}
* HTTP Method: GET
* RequestBody: None
* Response: JSON object:
  * Temperature
    * fahrenheit 
    * celsius


* URL: /conditions/{zipcode}
* HTTP Method: GET
* RequestBody: None
* Response: JSON object:
  * Conditions
    * Temperature
      * fahrenheit 
      * celsius
    * wind speed
    * wind direction
    * skies (i.e sunny, cloudy, partly sunny, etc)
    * precipitation (i.e. rain, snow, mist, none)






