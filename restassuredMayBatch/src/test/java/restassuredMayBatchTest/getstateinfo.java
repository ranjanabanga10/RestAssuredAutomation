package restassuredMayBatchTest;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//import com.jayway.restassured.path.json.JsonPath;
public class getstateinfo {
//Dependencies - rest-assured, hamcrest- matchers, jackson-databind and TestNG
	
	@Test
	public void GetCallBDD() {
		
		/*given()
		 -Request body
		 -Parameters
		 -Headers
		 -authentication		 
		when()
		- GET, POST,PUT, DELETE
		then()
		-Validation - hamcrest matchers, status codes, response body*/
		
		given()
		//.pathParam("countrycode", "IND")
		//.queryParam("text", "Jharkhand")
		//.formParam("Username", "Sushma","Password","3457788absu")
		.when()
			//.get("http://localhost:8080/landlords")
			.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
			//.get("http://services.groupkt.com/state/get/{countrycode}/all")
			//.get("http://services.groupkt.com/state/search/IND")
			// select * from Country where text = "Uttar Pradesh";		
		.then()
		
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat()
			.body("City", equalTo("Hyderabad"))
			
			.header("Content-Type", "application/json")
			.extract().response().prettyPrint();
//		.body("RestResponse.result[0].country", is("IND"))
//		.body("RestResponse.result[0].country", isOneOf("IND","USA"))
			

}
}
