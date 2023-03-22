package com.RestApiPune;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;

import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PostRequest {

	public static void main(String[] args) {
		//given 
		//When
		//Then
		System.out.println("Programe Strat");
	    RestAssured.baseURI="https://rahulshettyacademy.com";
	    String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	    .body(Payload.AddPlaceAPI())
	    .when().post("/maps/api/place/add/json")
	    .then().assertThat().statusCode(200)
	    .body("scope", equalTo("APP")).header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
	    System.out.println("Response :"+response);
	    
	    JsonPath js = new JsonPath(response);
	    String placeid =js.get("place_id");
	    System.out.println("Place Id : "+placeid);
	    
	    //Update place 
	    String address ="70 Summer walk, USA";
	    RestAssured.baseURI="https://rahulshettyacademy.com";
	    given().queryParam("key", "qaclick123").header("Content-Type","application/json")
	    .body("{\r\n"
	    		+ "\"place_id\":\""+placeid+"\",\r\n"
	    		+ "\"address\":\""+address+"\",\r\n"
	    		+ "\"key\":\"qaclick123\"\r\n"
	    		+ "}\r\n"
	    		+ "")
	    .when().put("/maps/api/place/update/json")
	    .then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
	    
	    //get place 
	     String placeResponse =  given().queryParam("key", "qaclick123").queryParam("place_id", placeid)
	    .when().get("/maps/api/place/get/json")
	    .then().assertThat().statusCode(200).extract().response().asString();
	   
	     ReUsableMethods.RowToJson(placeResponse);
         String Actualaddress =js.getString("address");
         System.out.println("actual Address :"+Actualaddress);
         Assert.assertArrayEquals(null, null)
	 }

}
