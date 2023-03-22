package com.RestApiPune;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

@Test
public class ComplexJson {
	int sum =0;
public void GetCourse() {
	JsonPath js = new JsonPath(Payload.ComplexJson());
	// Number Of Courses
	int count =js.get("courses.size()");
	System.out.println("NUmber Of Corses :"+count);
	
	// Print Purchase Amount
	int purchaseAmount =js.getInt("dashboard.purchaseAmount");
	System.out.println("purchaseAmount :"+purchaseAmount);
	
	// Print The TItle Of First Course
	String Firsttitle =js.get("courses[0].title");
	System.out.println("Fist Title :"+Firsttitle);
	
	//print all course title and their Respective Price
	for (int i=0;i<count;i++) {
		String courses =js.get("courses["+i+"].title");
		int price =js.get("courses["+i+"].price");

		System.out.println(courses);
		System.out.println(price);

		//Print No. Of Copies Sold BY particular Course
		for (int j=0;j<count;j++) {
		String courseTitle =js.get("courses["+j+"].title");
        if (courseTitle.equalsIgnoreCase("rpa")) {
        	int copies =js.getInt("courses["+j+"].copies");
        	System.out.println("Copies "+copies);
        	
        	//Sum of All Couses Price Matches With Purchase Amount
        	for (int k=0;k<count;k++) {
        		int prices =js.getInt("courses["+k+"].price");
        		int copiess =js.getInt("courses["+k+"].copies");
                 int amount = prices*copiess;
                 sum = sum+amount;
                 System.out.println(amount);
        		
        		}
            System.out.println(sum);

        }
		}
	}
}
}
