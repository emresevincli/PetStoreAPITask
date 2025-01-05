package com.QAEmre.tests;

import com.QAEmre.base.BaseTest;
import com.QAEmre.classes.Pet;
import com.QAEmre.methods.Methods;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Reporter;

public class PetstorePositiveApiTests extends BaseTest {
    Methods methods = new Methods();
    private static final Pet PET = createValidPet();

    @Test(priority = 1, description = "Steps:\n1. Send a POST request to create a new pet with valid details.\n2. Validate the status code is 200.\n3. Verify that the pet name and status in the response match the expected values.")
    public void testCreatePet_Positive() {
        Reporter.log("Step 1: Sending a POST request to create a new pet with valid details.<br>");
        Response response = methods.postMethod(PET);
        JsonPath json= response.jsonPath();

        Reporter.log("Step 2: Validating the status code is 200.<br>");
        checkStatusCode(response,200);

        Reporter.log("Step 3: Verifying that the pet name and status in the response match the expected values.<br>");
        Assert.assertEquals(json.getString("name"), PET.getName());
        Assert.assertEquals(json.getString("status"), PET.getStatus());
    }

    @Test(priority = 2, description = "Steps:\n1. Send a GET request to retrieve the pet by its ID.\n2. Validate the status code is 200.\n3. Verify that the pet name and status in the response match the expected values.")
    public void testGetPetById_Positive() {
        Reporter.log("Step 1: Sending a GET request to retrieve the pet by its ID.<br>");
        Response response = methods.getMethod(PET.getId());
        JsonPath json= response.jsonPath();

        Reporter.log("Step 2: Validating the status code is 200.<br>");
        checkStatusCode(response,200);

        Reporter.log("Step 3: Verifying that the pet name and status in the response match the expected values.<br>");
        Assert.assertEquals(json.getString("name"), PET.getName());
        Assert.assertEquals(json.getString("status"), PET.getStatus());
    }

    @Test(priority = 3, description = "Steps:\n1. Modify the pet's name.\n2. Send a PUT request to update the pet's information.\n3. Validate the status code is 200.\n4. Verify that the updated pet name and status in the response match the expected values.")
    public void testUpdatePet_Positive() {
        Reporter.log("Step 1: Modifying the pet's name.<br>");
        PET.setName(UPDATENAME);

        Reporter.log("Step 2: Sending a PUT request to update the pet's information.<br>");
        Response response = methods.putMethod(PET);
        JsonPath json= response.jsonPath();

        Reporter.log("Step 3: Validating the status code is 200.<br>");
        checkStatusCode(response,200);

        Reporter.log("Step 4: Verifying that the updated pet name and status in the response match the expected values.<br>");
        Assert.assertEquals(json.getString("name"), UPDATENAME);
        Assert.assertEquals(json.getString("status"), PET.getStatus());
    }

    @Test(priority = 4, description = "Steps:\n1. Send a DELETE request to remove the pet by its ID.\n2. Validate the status code is 200.\n3. Verify that the response message contains the pet's ID.")
    public void testDeletePet_Positive() {
        Reporter.log("Step 1: Sending a DELETE request to remove the pet by its ID.<br>");
        Response response = methods.deleteMethod(PET.getId());
        JsonPath json= response.jsonPath();

        Reporter.log("Step 2: Validating the status code is 200.<br>");
        checkStatusCode(response,200);

        Reporter.log("Step 3: Verifying that the response message contains the pet's ID.<br>");
        Assert.assertEquals(json.getString("message"), String.valueOf(PET.getId()));
    }
}
