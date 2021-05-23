package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddAPI;
import pojo.Location;
import resources.APIResources;
import resources.TestData;
import resources.Utils;


public class StepDefination1 extends Utils {
	
	RequestSpecification reqspec;
	RequestSpecification res;
	Response response;
	static String place_id;
	TestData td = new TestData();
	
	@Given("add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		ObjectMapper mapper = new ObjectMapper();
		String s = mapper.writeValueAsString(td.addPlacePayload(name, language, address));
				
 
		reqspec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").build();
		res = RestAssured.given().spec(requestSpecification()).body(s);
		
		//ResponseSpecification data = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
 
		
			
	}
 
	@When("user calls {string} api with {string} http request")
	public void user_calls_with_post_http_request(String resource, String Method) {
	    // Write code here that turns the phrase above into concrete actions
		APIResources resourAPI = APIResources.valueOf(resource);
		if(Method.equalsIgnoreCase("POST"))
		 response = res.when().post(resourAPI.getResource());
		else if(Method.equalsIgnoreCase("GET"))
			response = res.when().get(resourAPI.getResource());
		 //.then()/*.assertThat().spec(data)*/.extract().response();
	}
 
	@Then("the API call got success with status code {int}")
	public void api_call_is_successful_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(200,response.getStatusCode());
	}
 
	@Then("{string} in response body is {string}")
	public void in_response_body_is1(String keyvalue, String ExpectedValue) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(ExpectedValue, getJsonPath(response, keyvalue));
		System.out.println("Asserted");
	}
	
	@Then("Verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		 place_id = getJsonPath(response, "place_id");
         res = given().spec(requestSpecification()).queryParam("place_id", place_id);
         user_calls_with_post_http_request(resource, "GET");
         String actName = getJsonPath(response, "name");
         Assert.assertEquals(actName, expectedName);
         
	}
    
	@Given("delete place payload")
	public void delete_place_payload() throws IOException {
		res = given().spec(requestSpecification()).body(td.deletePayload(place_id));
	}
}
