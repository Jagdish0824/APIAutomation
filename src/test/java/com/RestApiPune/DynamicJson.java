package com.RestApiPune;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class DynamicJson {
@Test(dataProvider="bookdata")
public void AddBook(String isbn, String aisle) {
	RestAssured.baseURI="http://216.10.245.166";
	String response =given().header("Content-Type","application/json").body(Payload.AddPage(isbn,aisle))
	.when().post("/Library/Addbook.php")
	.then().assertThat().statusCode(200).extract().response().asString();
	
	 JsonPath js =ReUsableMethods.RowToJson(response);
	 String id =js.get("ID");
	 System.out.println("ID "+id);
	}
@DataProvider(name="bookdata")
public Object [][] GetData() {
  return new Object [][] {{"abs","001"},{"abc","002"},{"dig","123"}};
}
}
