package com.QAEmre.base;

import com.QAEmre.classes.Category;
import com.QAEmre.classes.Pet;
import com.QAEmre.classes.Tags;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.Collections;
import java.util.List;

public class BaseTest {

    public static final long VALID_ID = 1548561542;
    public static final Category VALID_CATEGORY = new Category(1, "Dog");
    public static final String VALID_NAME = "Cango";
    public static final List<String> VALID_PHOTOURLS = List.of("www.resim.com/");
    public static final List<Tags> VALID_TAGS = List.of(new Tags(1, "cute"));
    public static final String VALID_STATUS = "available";

    public static Pet createValidPet() {
        Pet validPet = new Pet();
        validPet.setId(VALID_ID);
        validPet.setCategory(VALID_CATEGORY);
        validPet.setName(VALID_NAME);
        validPet.setPhotoUrls(VALID_PHOTOURLS);
        validPet.setTags(VALID_TAGS);
        validPet.setStatus(VALID_STATUS);

        return validPet;
    }

    public static final long INVALID_ID = -1;
    public static final Category INVALID_CATEGORY = new Category(0, null);
    public static final String INVALID_NAME = null;
    public static final List<String> INVALID_PHOTOURLS = Collections.emptyList();
    public static final List<Tags> INVALID_TAGS = Collections.emptyList();
    public static final String INVALID_STATUS = null;
    public static final String INVALID_LARGE_ID = "54245245214141414182542";

    public static Pet createInvalidPet() {
        Pet invalidPet = new Pet();
        invalidPet.setId(INVALID_ID);
        invalidPet.setCategory(INVALID_CATEGORY);
        invalidPet.setName(INVALID_NAME);
        invalidPet.setPhotoUrls(INVALID_PHOTOURLS);
        invalidPet.setTags(INVALID_TAGS);
        invalidPet.setStatus(INVALID_STATUS);

        return invalidPet;
    }

    public void checkStatusCode(Response response, Integer expectedStatusCode) {
        Assert.assertEquals(response.statusCode(), expectedStatusCode, "There is an error on the API side. Expected response code: " + expectedStatusCode + ", received: " + response.statusCode());
    }

    public void validateErrorMessage(Response response, String expectedMessage) {
        String responseBody = response.getBody().asString();
        if (!responseBody.isEmpty() && response.getContentType().contains("application/json")) {
            JsonPath json = response.jsonPath();
            Assert.assertTrue(json.getString("message").contains(expectedMessage), "Error message does not match");
        } else {
            System.out.println("Response body is empty or not in JSON format");
        }
    }

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
}