package com.RestApiPune;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class PostPractice {
public static void main (String[] args ) {
	System.out.println("Programe Start");
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String responce = given().queryParam("key","qaclick123").body("{\r\n"
			+ "  \"location\": {\r\n"
			+ "    \"lat\": -38.383494,\r\n"
			+ "    \"lng\": 33.427362\r\n"
			+ "  },\r\n"
			+ "  \"accuracy\": 50,\r\n"
			+ "  \"name\": \"Frontline house\",\r\n"
			+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
			+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
			+ "  \"types\": [\r\n"
			+ "    \"shoe park\",\r\n"
			+ "    \"shop\"\r\n"
			+ "  ],\r\n"
			+ "  \"website\": \"http://google.com\",\r\n"
			+ "  \"language\": \"French-IN\"\r\n"
			+ "}\r\n"
			+ "")
	.when().post("/maps/api/place/add/json").andReturn()
	.then().assertThat().statusCode(200).extract().asString();
	System.out.println("Response :"+responce);
	System.out.println("Programe End ");
}
}
