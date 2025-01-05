# PetStoreAPITask

This project was developed to create and run automated test cases on the Pet Store API. The project performs API tests
using Rest Assured and TestNG libraries.
---

## Project Structure

```plaintext
PetStoreAPITask
|-- .idea
|-- src
|   |-- test
|       |-- java
|           |-- com
|               |-- QAEmre
|                   |-- base
|                   |   |-- BaseTest.java
|                   |-- classes
|                   |   |-- Category.java
|                   |   |-- Pet.java
|                   |   |-- PhotoUrls.java
|                   |   |-- Tags.java
|                   |-- methods
|                   |   |-- Methods.java
|                   |-- tests
|                       |-- PetstoreNegativeApiTests.java
|                       |-- PetstorePositiveApiTests.java
|-- pom.xml
```

---

# Classes, Methods and Functions

## BaseTest.java

- This class serves as a base class that establishes the foundations of RestAssured-based tests and provides certain
  helper methods.

### Methods

- __createValidPet()__: Creates and returns a valid pet object.

- __createInvalidPet()__: Creates and returns an invalid pet object.

- __checkStatusCode(Response response, Integer expectedStatusCode)__: Checks the status code of the response. Compares
  it with the expected status code and notifies if there is an error.

- __validateErrorMessage(Response response, String expectedMessage)__ : Checks the error message in the response.
  Validates if the response contains an error message in JSON format and checks if it matches the expected message.

- __setup()__ : Called before the tests start and sets the base URI for RestAssured (https://petstore.swagger.io/v2).

#### <u>Detailed Description</u>

This class provides functions such as creating valid and invalid data to be used while performing API tests, validating
the status codes of the responses, and validating error messages. The helper methods help avoid repetitive code and make
the tests more organized.

## Category.java

- This class is used to define the categories of pets and contains the `id` and `name` properties. The `Category` class
  is
  useful for determining which category a pet belongs to. Thanks to the Lombok library, getter and setter methods are
  automatically generated.

## Pet.java

- This class is used to define various properties of pets and contains `id`, `category`, `name`, `photoUrls`, `tags`,
  and `status`
  properties. The `Pet` class provides a representation of pets in the database or API. Thanks to the Lombok library,
  getter and setter methods are automatically generated.

## PhotoUrls.java

- This class is used to define the photo URLs of pets and contains the `photoUrls` property. The `PhotoUrls` class is
  useful
  for storing and accessing photos of pets. Thanks to the Lombok library, getter and setter methods are automatically
  generated.

## Tags.java

- This class is used to define the tags of pets and contains the `id` and `name` properties. The `Tags` class is useful
  for
  storing and accessing tags related to pets. Thanks to the Lombok library, getter and setter methods are automatically
  generated.

## Methods.java

- This class provides various helper methods to perform RESTful API requests and interacts with APIs using the
  RestAssured library.

### Metotlar

- __postMethod(Pet pet)__ : Sends a `Pet` object in JSON format via a POST request to the `/pet` endpoint and returns
  the response.

- __getMethod(long id)__ : Retrieves a pet with the specified ID via a GET request to the `/pet/{id}` endpoint and
  returns
  the response.

- __putMethod(Pet pet)__ : Sends a `Pet` object in JSON format via a PUT request to the `/pet` endpoint and returns the
  response.

- __deleteMethod(long id)__ : Deletes a pet with the specified ID via a DELETE request to the `/pet/{id}` endpoint and
  returns the response.

- __deleteMethod(String id)__ : Deletes a pet with the specified ID via a DELETE request to the `/pet/{id}` endpoint and
  returns the response.

#### <u>Detailed Description</u>

This class is used to perform CRUD (Create, Read, Update, Delete) operations on Pet objects. The methods send HTTP
requests to the specified endpoints using the RestAssured library and return the responses. The Gson library is used to
convert Pet objects to JSON format.

## PetstorePositiveApiTests.java

- This class is a test class that contains positive test scenarios for the Petstore API. It tests API requests and
  responses using the TestNG and RestAssured libraries.

### Methods

- __testCreatePet_Positive()__ : Sends a POST request to create a new pet with valid details and verifies that the pet's
  name and status in the response match the expected values.

- __testGetPetById_Positive()__ : Sends a GET request to retrieve a pet by its ID and verifies that the pet's name and
  status in the response match the expected values.

- __testUpdatePet_Positive()__ : Changes the pet's name and sends a PUT request to update it; verifies that the updated
  pet's name and status in the response match the expected values.

- __testDeletePet_Positive()__ : Sends a DELETE request to remove a pet by its ID and verifies that the response message
  includes the pet's ID.

#### <u>Detailed Description</u>

This class is used to perform positive test scenarios on the Petstore API, with each test method sending specific API
requests and verifying the responses. The `Reporter` class is used to report test steps, and the `Assert` class is used
to
make comparisons with the expected values.

## PetstoreNegativeApiTests.java

- This class is a test class that contains negative test scenarios for the Petstore API. It tests API requests and
  responses using the TestNG and RestAssured libraries.

### Methods

- __testCreatePet_Negative()__ : Sends a POST request to create a new pet with invalid details and verifies that the pet
  ID in the response does not match the expected value. It also checks the status code of the response.

- __testGetPetById_Negative()__ : Sends a GET request to retrieve a pet with an invalid ID and verifies that the status
  code of the response is 404. It also verifies that the response message contains "Pet not found".

- __testUpdatePet_Negative()__ : Sends a PUT request to update pet information with invalid details and verifies that
  the status code of the response is 405. It also verifies that the pet ID in the response does not match the expected
  value.

- __testDeletePet_Negative()__ : Sends a DELETE request to remove a pet with an invalid ID and verifies that the status
  code of the response is 404. It also verifies that the response message contains "Pet not found".

- __testDeletePetWithLargeID_Negative()__ : Sends a DELETE request to remove a pet with an excessively large ID and
  verifies that the status code of the response is 404. It also verifies that the response message contains "
  java.lang.NumberFormatException".

#### <u>Detailed Description</u>

This class is used to perform negative test scenarios on the Petstore API, with each test method sending specific API
requests and verifying the responses. The Reporter class is used to report test steps, and the Assert class is used to
make comparisons with the expected values.

---

## Setup

After cloning the project to your local machine, follow the steps below to install the necessary dependencies:

1. Clone the project:

```bash
 git clone https://github.com/kullaniciadi/proje-adi.git 
``` 

2. Install the required dependencies:

```bash 
 mvn install 
 ```

3. Run the tests:

```bash 
 mvn test 
 ```

---

## Test Reporting

- When the tests are run, the test results will be generated in the `target/surefire-reports` directory. In this
  directory, there is an `index.html` file where you can examine the test results in detail. You can view the test
  reports
  by opening this file in a browser.

---

## Comments

&rarr; Currently, two tests are failing:

- <span style="color: red;">testCreatePet_Negative()</span>: This test fails when attempting to create a new pet with
  invalid details. There is an error on the API side. Expected response code: 405, received: 200. <br>


- <span style="color: red;">testUpdatePet_Negative()</span>: This test fails when attempting to update pet information
  with invalid details. There is an error on the API side. Expected response code: 405, received: 200.

