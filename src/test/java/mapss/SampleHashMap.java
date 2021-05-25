package mapss;

import static io.restassured.RestAssured.given;
import java.util.HashMap;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class SampleHashMap {
	
	@Test
	public void addBook() {
	
	HashMap<String, Object> hm = new HashMap<String, Object>();
	hm.put("name", "RestAssured");
	hm.put("isbn", "dsahg");
	hm.put("aisle", "3222");
	hm.put("author", "jane");
	RestAssured.baseURI="http://216.10.245.166";
	String resp = given().header("Content-type", "application/json").
			body(hm).when().post("Library/Addbook.php").then().assertThat().statusCode(200).
			extract().response().asString();
	System.out.println(resp);
	}

}
