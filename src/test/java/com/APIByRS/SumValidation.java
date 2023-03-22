package com.APIByRS;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
@Test
public void sumOfacourses() {
	JsonPath js = new JsonPath(Payload.CoursePrice());
	int sum=0;
	int count= js.getInt("courses.size()");
	System.out.println("Count :"+count);
	for(int i=0;i<count;i++) {
	int price =	js.getInt("courses["+i+"].price");
	int copies = js.getInt("courses["+i+"].copies");
	int amount = price*copies;
	System.out.println(amount);
	sum = sum+amount;
	}
	System.out.println("Sum :"+sum);
	int purchaseamount = js.getInt("dashboard.purchaseAmount");
	System.out.println("PurchaseAmount :"+purchaseamount);
	Assert.assertEquals(sum, purchaseamount);
}
}
