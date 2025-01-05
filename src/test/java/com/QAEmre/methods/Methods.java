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

        return given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(jsonBody)
                .when()
                .log().all()
                .request("POST", "/pet")
                .prettyPeek();

    }

    public Response getMethod(long id) {
        return given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .log().all()
                .request("GET", "/pet/" + id)
                .prettyPeek();

    }

    public Response putMethod(Pet pet) {
        Gson gson = new Gson();
        String jsonBody = gson.toJson(pet);

        return given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(jsonBody)
                .when()
                .log().all()
                .request("PUT", "/pet")
                .prettyPeek();

    }

    public Response deleteMethod(long id) {

        return given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .log().all()
                .request("DELETE", "/pet/" + id)
                .prettyPeek();

    }

    public Response deleteMethod(String id) {

        return given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .log().all()
                .request("DELETE", "/pet/" + id)
                .prettyPeek();

    }
}