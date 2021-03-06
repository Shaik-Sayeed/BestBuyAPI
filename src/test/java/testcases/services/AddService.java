package testcases.services;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.commonMethods;

public class AddService {
	
	
	@Test
	public void addService() {
		
		
		String s ="{\r\n" + 
				"  \"name\": \"ArnabServices1\"\r\n" + 
				"}";
		
		
		RestAssured.baseURI = "http://localhost:3030";
		
		Response r1 = given().header("Content-Type", "application/json").body(s).
		when().post("/services").then().assertThat().statusCode(201).and().contentType(ContentType.JSON).and().extract().response();
		
		JsonPath j = commonMethods.rawToJSON(r1);
		String serviceId = j.get("id").toString();
		System.out.println("The ID Service added is "+serviceId);
		
	}

}
