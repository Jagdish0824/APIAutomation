package files;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {

   public static JsonPath RowToJson(String response) {
	 JsonPath js = new JsonPath(response);
	 return js;
   }
}
