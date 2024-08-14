package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
//import pojo.Location;
//import pojo.mainSystemTwo;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinitions extends Utils{
	
	ResponseSpecification res;
	RequestSpecification reqspec;
	Response resp;
	
	
	TestDataBuild data = new TestDataBuild();
//	@Given("Add Place Payload")
//	public void Add_place_Payload() throws IOException {
//		
//		
//		
//		 reqspec = given().spec(requestSpecification()).body(data.addPlacePayload());
//	}
	
	@Given("Add Place Payload with {string}, {string}, {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		 reqspec = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));
	}
	
	@When("user calls {string} with Post http request")
	public void user_calls_with_post_http_request(String string) {
		 res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		resp = reqspec.when().post("/maps/api/place/add/json")
				.then().spec(res).extract().response();
	}
	
	@Then("the Api call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		
		assertEquals(resp.getStatusCode(),200);

		
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String expectedvalue) {
	    
		String response = resp.asString();
		JsonPath jp = new JsonPath(response);
		assertEquals(jp.get(keyvalue).toString(), expectedvalue);
	}
	
}
