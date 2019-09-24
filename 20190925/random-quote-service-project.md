# Random Quote Service Project

The purpose of this project is to give you experience setting up a Spring Cloud configuration server and a web service that is a client of the configuration server from scratch.

## Requirements

1. Create a new Spring Cloud Config Server project called ```firstname-lastname-cloud-config-server``` using the Spring Initializr by following the steps outlined in the lesson. Have the server run on port 9999 and have it use the Git repository that you created in class to store the configuration files for client applications.

2. Create a new Spring Boot REST web service called ```firstname-lastname-random-quote-service```. This web service must meet the following requirements:

   * It uses the Config Server created in the previous step for all of its configuration settings.
   
   * It runs on port 2244
   
   * It contains the following endpoint:

   ```java
   URI: /quote
   HTTP Method: GET
   Request Body: None
   Response Body: Quote (String) 
   ```

   * The endpoint should randomly return one of the following eight quotes:
   
      * To me programming is more than an important practical art. It is also a gigantic undertaking in the foundations of knowledge. - Grace Hopper
      
      * Programs must be written for people to read, and only incidentally for machines to execute. - Hal Ableson
      
      * Don't call me the mother of the internet. - Radia Perlman
      
      * When I first started using the phrase software engineering, it was considered to be quite amusing. They used to kid me about my radical ideas. Software eventually and necessarily gained the same respect as any other discipline. - Margaret Hamilton
      
      * Machines take me by surprise with great frequency. - Alan Turing
      
      * The function of good software is to make the complex appear simple. - Grady Booch
      
      * An API that isn't comprehensible isn't usable. - James Gosling
      
      * I'm not a great programmer; I'm just a good programmer with great habits. - Martin Fowler

## Hints

* Consider using an array or ArrayList to store the quotes.

* Consider using a random number to help you choose the quote to return.
