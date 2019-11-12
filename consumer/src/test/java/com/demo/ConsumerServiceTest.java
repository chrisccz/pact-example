package com.demo;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "producer-service", port="9090")
public class ConsumerServiceTest {

    private final OpenApiValidationFilter validationFilter = new OpenApiValidationFilter("http://localhost:8080/v2/api-docs");

    @Pact(provider="producer-service",  consumer = "consumer-service")
    public RequestResponsePact createPact(PactDslWithProvider builder){
        return builder
                .given("start")
                .uponReceiving("producer service test interaction")
                    .path("/message")
                    .method("GET")
                .willRespondWith()
                    .status(200)
                .matchHeader("Content-Type", APPLICATION_JSON_VALUE)
                    .body("{\"message\": \"Hello\"}")
                .toPact();
    }

    @Test
    public void testThatMessageServiceReceivesMessage(MockServer mockserver){
        given()
                .filter(validationFilter)
        .when()
            .get(mockserver.getUrl() +"/message")
        .then()
            .statusCode(200)
            .body("message", equalTo("Hello"));
    }



}
