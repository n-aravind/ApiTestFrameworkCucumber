package com.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseLogSpecification;

import java.util.Properties;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ApiTestSteps {

    private RequestSpecification requestSpecification;
    private Response response;
    Properties properties;

    @When("^a api is invoked$")
    public void aApiIsInvoked() throws Throwable {
        properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/config.properties"));
        response = when().get(properties.getProperty("testUrl"));
    }

    @Then("^it returns (\\d+) http code$")
    public void itReturnsHttpCode(int returnCode) throws Throwable {
        response.then().statusCode(returnCode);

    }
}
