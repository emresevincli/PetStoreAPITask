# PetStoreAPITask

This project was developed to create and run automated test cases on the Pet Store API. The project performs API tests
using Rest Assured and TestNG libraries.

<table>
  <tr>
    <td><img src="https://i.hizliresim.com/ta0fw1s.png" alt="Örnek PNG Resim" width="125" height="125" /></td>
    <td><img src="https://i.hizliresim.com/hxpfjh3.png" alt="Örnek PNG Resim" width="125" height="125" /></td>
    <td><img src="https://i.hizliresim.com/nlpy6w1.png" alt="Örnek PNG Resim" width="125" height="125" /></td>
  </tr>
</table>


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
|                   |   |-- Tags.java
|                   |-- methods
|                   |   |-- Methods.java
|                   |-- tests
|                       |-- PetstoreNegativeApiTests.java
|                       |-- PetstorePositiveApiTests.java
|-- pom.xml
```

---
# Dependencies

&rarr; This project uses the following dependencies:

**`TestNG`** : A framework for test automation.

**`Rest-Assured`** : A library for testing RESTful web services.

**`Lombok`** : A library to reduce boilerplate code in Java.

**`Gson`** : A library for converting Java objects to JSON and vice versa.

<br>

---

# Classes, Methods and Functions

## BaseTest.java

- This class serves as a base class that establishes the foundations of RestAssured-based tests and provides certain
  helper methods.

### Methods

- __`createValidPet()`__: Creates and returns a valid pet object.

- __`createInvalidPet()`__: Creates and returns an invalid pet object.

- __`checkStatusCode(Response response, Integer expectedStatusCode)`__: Checks the status code of the response. Compares
  it with the expected status code and notifies if there is an error.

- __`validateErrorMessage(Response response, String expectedMessage)`__ : Checks the error message in the response.
  Validates if the response contains an error message in JSON format and checks if it matches the expected message.

- __`setup()`__ : Called before the tests start and sets the base URI for RestAssured (https://petstore.swagger.io/v2).

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

## Tags.java

- This class is used to define the tags of pets and contains the `id` and `name` properties. The `Tags` class is useful
  for
  storing and accessing tags related to pets. Thanks to the Lombok library, getter and setter methods are automatically
  generated.

## Methods.java

- This class provides various helper methods to perform RESTful API requests and interacts with APIs using the
  RestAssured library.

### Methods

- __`postMethod(Pet pet)`__ : Sends a `Pet` object in JSON format via a POST request to the `/pet` endpoint and returns
  the response.

- __`getMethod(long id)`__ : Retrieves a pet with the specified ID via a GET request to the `/pet/{id}` endpoint and
  returns
  the response.

- __`putMethod(Pet pet)`__ : Sends a `Pet` object in JSON format via a PUT request to the `/pet` endpoint and returns the
  response.

- __`deleteMethod(long id)`__ : Deletes a pet with the specified ID via a DELETE request to the `/pet/{id}` endpoint and
  returns the response.

- __`deleteMethod(String id)`__ : Deletes a pet with the specified ID via a DELETE request to the `/pet/{id}` endpoint and
  returns the response.

#### <u>Detailed Description</u>

This class is used to perform CRUD (Create, Read, Update, Delete) operations on Pet objects. The methods send HTTP
requests to the specified endpoints using the RestAssured library and return the responses. The Gson library is used to
convert Pet objects to JSON format.

## PetstorePositiveApiTests.java

- This class is a test class that contains positive test scenarios for the Petstore API. It tests API requests and
  responses using the TestNG and RestAssured libraries.

### Methods

- __`testCreatePet_Positive()`__ : Sends a POST request to create a new pet with valid details and verifies that the pet's
  name and status in the response match the expected values.

- __`testGetPetById_Positive()`__ : Sends a GET request to retrieve a pet by its ID and verifies that the pet's name and
  status in the response match the expected values.

- __`testUpdatePet_Positive()`__ : Changes the pet's name and sends a PUT request to update it; verifies that the updated
  pet's name and status in the response match the expected values.

- __`testDeletePet_Positive()`__ : Sends a DELETE request to remove a pet by its ID and verifies that the response message
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

- __`testCreatePet_Negative()`__ : Sends a POST request to create a new pet with invalid details and verifies that the pet
  ID in the response does not match the expected value. It also checks the status code of the response.

- __`testGetPetById_Negative()`__ : Sends a GET request to retrieve a pet with an invalid ID and verifies that the status
  code of the response is 404. It also verifies that the response message contains "Pet not found".

- __`testUpdatePet_Negative()`__ : Sends a PUT request to update pet information with invalid details and verifies that
  the status code of the response is 405. It also verifies that the pet ID in the response does not match the expected
  value.

- __`testDeletePet_Negative()`__ : Sends a DELETE request to remove a pet with an invalid ID and verifies that the status
  code of the response is 404. It also verifies that the response message contains "Pet not found".

- __`testDeletePetWithLargeID_Negative`()__ : Sends a DELETE request to remove a pet with an excessively large ID and
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
 git clone https://github.com/emresevincli/PetStoreAPITask.git 
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
<img src="https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExd2xla2c3OW00cWQzbDlpa2YzbDFkZ3l2a3I5NXVpNG01YTdtYzFycyZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/ZVik7pBtu9dNS/giphy.webp" alt="Dans Eden Kedi GIF'i" />


## Comments

&rarr; Currently, two tests are failing:

- **`testCreatePet_Negative()`** : This test fails when attempting to create a new pet with
  invalid details. There is an error on the API side. Expected response code: 405, received: 200. <br>


- **`testUpdatePet_Negative()`** : This test fails when attempting to update pet information
  with invalid details. There is an error on the API side. Expected response code: 405, received: 200.

<img src="https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExMnpiaTNteGd3bGxsM3p0ZjdmeTE4dm40OHhoODVvc3prZzk2a2FuNCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/nrIj4ybdApT6zEtbtU/giphy.webp" alt="Dans Eden Kedi GIF'i" />
