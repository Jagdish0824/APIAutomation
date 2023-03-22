package com.APIByRS;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonPars {

	public static void main(String[] args) {
    JsonPath js = new JsonPath(Payload.CoursePrice());
    //Print No Of Course Return By Api 
    int count = js.getInt("courses.size()");
    System.out.println("Count :"+count);
    //Print Purchase amount 
    int totalamount = js.getInt("dashboard.purchaseAmount");
    System.out.println("Purchase Amount = "+totalamount);
    //3. Print Title of the first course
    String title =js.getString("courses[0].title");
    System.out.println("Title :"+title);
   // Print All course titles and their respective Prices
    for (int i=0;i<count;i++) {
    String coursetitle=  js.getString("courses["+i+"].title");
    int price= js.getInt("courses["+i+"].price");
    System.out.println(coursetitle);
    System.out.println(price);
    
    //Print No Of Copies Sold By RPA Course
    System.out.println("Print No Of Copies Sold By RPA ");
    for(int j=0;j<count;j++) {
    String courses= js.getString("courses["+j+"].title");
    if(courses.equalsIgnoreCase("RPA")) {
    int copies = js.getInt("courses["+j+"].copies")	;
    System.out.println("Copies ="+copies);
    break;
    }
     
    	
    }
    }

	}

}
