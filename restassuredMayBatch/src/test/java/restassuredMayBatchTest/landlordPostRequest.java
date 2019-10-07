package restassuredMayBatchTest;

import java.util.HashMap;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;

public class landlordPostRequest {
	public static HashMap map=new HashMap();
	
	@BeforeClass
	public void postdata() 
	{
		map.put("firstName", RestUtils.getFirstName());
		map.put("lastName", RestUtils.getLastName());
		map.put("trusted", RestUtils.getUserName());
		map.put("trusted", RestUtils.getPassword());
		map.put("trusted", RestUtils.getEmail());
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
	}
	@Test
	public void testpost() 
	{
		given()
			.contentType("application/json")
			.body(map)
		
		.when()
		
			.post()
		
		.then()
		
			.statusCode(201)
			.and()
			.body("SuccessCode", equalTo("OPERATION_SUCESS"))
			.and()
			.body("Message",equalTo("Operation Completed successfully"));
		
		
		
		
	}

}
