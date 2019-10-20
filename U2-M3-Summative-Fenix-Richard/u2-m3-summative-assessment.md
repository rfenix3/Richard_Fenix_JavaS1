# U2 M3 Summative Assessment

The purpose of this assessment is for you to demonstrate your ability to apply Spring security to an existing application and deploy it to PWS.

## Requirements

This assessment is based on the Game Store Capstone Project that you completed for Unit 1. If you were unable to complete any of the features of that project, you must complete them before beginning this assessment.

### Security Rules

Apply the following security rules to your Game Store application:

* Searching:
  * Any user (both authenticated and unauthenticated) can search for products.
* Updates:
  * Any staff member can update a product.
* Create:
  * Only Managers and above can create new products.
* Delete
  * Only Admin users can delete a product.

### Users

You are responsible for creating users and assigning roles so that you can verify your security configuration.

### Deployment

After implementing the above changes and verifying that they work locally you must deploy your application to PWS and demonstrate that it is working on that platform.

Note: 
Use the './mvnw -DskipTests=true package' command to build and package our app(or service()) before we push it to PWS. This command is calling Maven to do this and excluding the test files.