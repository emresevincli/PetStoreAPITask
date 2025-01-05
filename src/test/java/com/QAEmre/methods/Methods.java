package com.QAEmre.methods;

import com.QAEmre.classes.Pet;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Methods {

    public Response postMethod(Pet pet) {
        Gson gson = new Gson();
        String jsonBody = gson.toJson(pet);

        Response response = given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(jsonBody)
                .when()
                .log().all()
                .request("POST", "/pet")
                .then()
                .extract().response().prettyPeek();

        return response;
    }

    public Response getMethod(long id) {
        Response response = given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .log().all()
                .request("GET", "/pet/" + id)
                .then()
                .extract().response();

        return response;
    }

    public Response putMethod(Pet pet) {
        Gson gson = new Gson();
        String jsonBody = gson.toJson(pet);

        Response response = given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(jsonBody)
                .when()
                .log().all()
                .request("PUT", "/pet")
                .then()
                .extract().response();

        return response;
    }

    public Response deleteMethod(long id) {

        Response response = given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .log().all()
                .request("DELETE", "/pet/" + id)
                .then()
                .extract().response();

        return response;
    }

    public Response deleteMethod(String id) {

        Response response = given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .log().all()
                .request("DELETE", "/pet/" + id)
                .then()
                .extract().response();

        return response;
    }
}