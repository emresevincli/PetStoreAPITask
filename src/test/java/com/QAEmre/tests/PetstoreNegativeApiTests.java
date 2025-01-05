package com.QAEmre.tests;

import com.QAEmre.base.BaseTest;
import com.QAEmre.classes.Pet;
import com.QAEmre.methods.Methods;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Reporter;

public class PetstoreNegativeApiTests extends BaseTest {
    Methods methods = new Methods();

    @Test(priority = 5, description = "Steps:\n1. Create a pet object with invalid details (e.g., negative ID).\n2. Send a POST request to create the pet.\n3. Check the response status code and log the message accordingly.\n4. Validate that the pet ID in the response is not -1.")
    public void testCreatePet_Negative() {

        Reporter.log("Step 1: Create a pet object with invalid details (e.g., negative ID).<br>");
        Pet invalidPet = createInvalidPet();

        Reporter.log("Step 2: Send a POST request to create the pet.<br>");
        Response response = methods.postMethod(invalidPet);

        Reporter.log("Step 3: Validate that the pet ID in the response is not -1.<br>");
        JsonPath json = response.jsonPath();
        long id = json.getLong("id");
        Assert.assertFalse(id == INVALID_ID);

        Reporter.log("Step 4: Check the response status code and log the message accordingly.<br>");
        checkStatusCode(response, 405);
    }

    @Test(priority = 6, description = "Steps:\n1. Send a GET request to retrieve a pet by an invalid ID.\n2. Validate the status code is 404.\n3. Verify that the response message contains 'Pet not found'.")
    public void testGetPetById_Negative() {

        Reporter.log("Step 1: Send a GET request to retrieve a pet by an invalid ID.<br>");
        Response response = methods.getMethod(INVALID_ID);

        Reporter.log("Step 2: Validate the status code is 404.<br>");
        checkStatusCode(response, 404);

        Reporter.log("Step 3: Verify that the response message contains 'Pet not found'.<br>");
        validateErrorMessage(response, "Pet not found");
    }

    @Test(priority = 7, description = "Steps:\n1. Create a pet object with invalid details (e.g., invalid Id, empty required fields).\n2. Send a PUT request to update the pet.\n3. Check the response status code and log the message accordingly.\n4. Validate that the response status code is 405 (Validation exception).")
    public void testUpdatePet_Negative() {

        Reporter.log("Step 1: Create a pet object with invalid details (e.g., invalid Id, empty required fields).<br>");
        Pet invalidPet = createInvalidPet();
        Reporter.log("Step 2: Send a PUT request to update the pet.<br>");
        Response response = methods.putMethod(invalidPet);

        Reporter.log("Step 3: Validate that the pet ID in the response is not -1.<br>");
        JsonPath json = response.jsonPath();
        long id = json.getLong("id");
        Assert.assertFalse(id == INVALID_ID);

        Reporter.log("Step 4: Check the response status code and log the message accordingly.<br>");
        checkStatusCode(response, 405);
    }

    @Test(priority = 8, description = "Steps:\n1. Send a DELETE request to remove a pet by an invalid ID.\n2. Validate the status code is 404.\n3. Verify that the response message contains 'Pet not found' if the response body is in JSON format.")
    public void testDeletePet_Negative() {

        Reporter.log("Step 1: Send a DELETE request to remove a pet by an invalid ID.<br>");
        Response response = methods.deleteMethod(INVALID_ID);

        Reporter.log("Step 2: Validate the status code is 404.<br>");
        checkStatusCode(response, 404);

        Reporter.log("Step 3: Verify that the response message contains 'Pet not found' if the response body is in JSON format.<br>");
        validateErrorMessage(response, "Pet not found");

    }

    @Test(priority = 9, description = "Steps:\n1. Send a DELETE request to remove a pet by providing an invalid, extremely large ID.\n2. Confirm the status code is 404 to indicate the resource was not found.\n3. Ensure the response message contains 'java.lang.NumberFormatException' if the response body is in JSON format.")
    public void testDeletePetWithLargeID_Negative() {

        Reporter.log("Step 1: Send a DELETE request to remove a pet by a very large ID value to trigger a NumberFormatException.<br>");
        Response response = methods.deleteMethod(INVALID_LARGE_ID);

        Reporter.log("Step 2: Validate the status code is 404.<br>");
        checkStatusCode(response, 404);

        Reporter.log("Step 3: Verify that the response message contains 'java.lang.NumberFormatException' if the response body is in JSON format.<br>");
        validateErrorMessage(response, "java.lang.NumberFormatException");

    }

}
