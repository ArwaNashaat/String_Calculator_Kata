package com.example.stringcalculatorkata;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StringCalculatorKataServiceControllerTest {

    @BeforeEach
    public void setUp() {
        RestAssured.port = 8080;
    }

    @Test
    public void hitAddAPIWillReturnTheSumOfTwoNumbers() {
        given().
                body("1,3,6,10").
                when().
                post("/add").
                then().
                statusCode(200).
                and().
                body("add.sum",equalTo(Integer.parseInt("20")));
    }
}
