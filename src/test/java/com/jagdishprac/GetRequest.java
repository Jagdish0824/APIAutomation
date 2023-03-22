package com.jagdishprac;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class GetRequest {

	public static void main(String[] args) {
    RestAssured.baseURI =": https://rahulshettyacademy.com";
    given().queryParam("key", "qaclick123").body("{\r\n"
    		+ "    \"place_id\":\"928b51f64aed18713b0d164d9be8d67f\"\r\n"
    		+ "}\r\n"
    		+ "")
    .when()
    .delete("/maps/api/place/delete/json")
    .then().assertThat().statusCode(200);
	}

}
