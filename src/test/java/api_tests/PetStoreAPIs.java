package api_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class PetStoreAPIs {
	
	
	String baseUrl ="https://petstore.swagger.io/v2";
	
	@Test
	public void findPetsByStatus() {
		
		String endpoint ="/pet/findByStatus";
		
		Response response =given().contentType("application/json")
		.accept(ContentType.JSON)
		.queryParam("status", "sold")
		.when().get(baseUrl + endpoint)
		.thenReturn();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getContentType(),"application/json");
		
		//.then().statusCode(200);
		//.and().contentType("applicaton/json");
	}


}
