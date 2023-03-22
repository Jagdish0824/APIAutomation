package com.APIByRS;
import static io.restassured.RestAssured.*;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
public class OauthPrograme {
	public static void main(String[] args ) {
		String url ="https://rahulshettyacademy.com/getCourse.php?state=jagdish&code=4%2F"
				+ "0AWgavdd0RfO8gM5-vOTTr2m3SrWZ8uTuPAe6JXZxtD8QUqEKu7VjBq9wtpNZmqQCl2-HXQ&scope=email+https"
				+ "%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent";

	   String partialcode = url.split("code=")[1];
	   String code = url.split("&scope")[0];
	   System.out.println("code "+code);

		
		String Response  =given().queryParams("code",code)
	    .queryParam("client_id", "692183103107-"
				+ "p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	    .queryParams("","")
	    .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
	    .queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
	    .queryParam("grant_type", "authorization_code")
	    .when().log().all()
	    .post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js = new JsonPath(Response);
		String accesstoken =js.getString("access_token");
		

  String response = given().queryParam("access_token", accesstoken)
   .when().get("https://rahulshettyacademy.com/getCourse.php").asString();
  System.out.println(response);
   
	}


}

