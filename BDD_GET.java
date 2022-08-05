package APITestAutomation.APITestAutomation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class BDD_GET {
	
	@Test
	public void getweatherdetails()
	{
		given()
		
		.when()
		.get("http://restapi.demoqa.com/utilities/weather/city/Chennai")
		
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
			
		
	}

}
