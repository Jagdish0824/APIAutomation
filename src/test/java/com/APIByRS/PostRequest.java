package com.APIByRS;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class PostRequest {

	public static void main(String[] args) {
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String response = given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlaceAPI())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().log().all().statusCode(200).body("scope", equalTo("APP"))
		        .header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
        System.out.println("Response :"+response );
        
        JsonPath js = new JsonPath(response);
       String placeid = js.getString("place_id");
       System.out.println(placeid);
       
       //Upadate Place 
       System.out.println("Update place");
       
       given().queryParam("key", "qaclick123").header("Content-Type","application/json")
       .body("{\r\n"
       		+ "\"place_id\""+placeid+",\r\n"
       		+ "\"address\":\"70 hum mer walk, USA\",\r\n"
       		+ "\"key\":\"qaclick123\"\r\n"
       		+ "}")
       .when().put("/maps/api/place/update/json")
       .then().assertThat().log().all().statusCode(200);
       System.out.println("Testing ok");
       
      //GetPlace 
       System.out.println("GetPlace");
       String getplaceresponse  =given().queryParam("key", "qaclick123").queryParam("place_id", "placeid").
       when().get("/maps/api/place/add/json").
       then().assertThat().log().all().statusCode(200).extract().response().asString();
       
       JsonPath js1= new JsonPath(getplaceresponse);
       String actaddress = js1.getString("Address");
       System.out.println(actaddress);
	}   
}
