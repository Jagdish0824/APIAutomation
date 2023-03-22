package com.RestApiPune;
import static io.restassured.RestAssured.given;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PostRequestPr {

	public static void main(String[] args) {
     // Given()
	//	When();
	// Then();
		
	 RestAssured.baseURI="https://rahulshettyacademy.com";
	String response = given().log().all().queryParam("key", "qaclick123")
	 .header("Content-Type","application/json").body(Payload.AddPlaceAPI())
	 .when().post("/maps/api/place/add/json")
	 .then().log().all().statusCode(200).extract().asString();
	 
	 JsonPath js = new JsonPath(response);
	 String placeid =js.get("place_id");
	 System.out.println("place_id =" +placeid);
	 
    // Update Place 
	 RestAssured.baseURI="https://rahulshettyacademy.com";
	 given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	 .body("{\r\n"
	 		+ "\"place_id\":\"8d2573bdf6ceec0e474c5f388fa917fb\",\r\n"
	 		+ "\"address\":\"70 Summer walk, USA\",\r\n"
	 		+ "\"key\":\"qaclick123\"\r\n"
	 		+ "}\r\n"
	 		+ "")
	 .when().put("/maps/api/place/update/json")
	 .then().log().all().statusCode(200);
	 
	}

}
