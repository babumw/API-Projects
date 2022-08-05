package APITestAutomation.APITestAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthenticationTest {
	
	@Test
	public void AuthenticationTest()
	
	{
		

		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		PreemptiveBasicAuthScheme basicauth=new PreemptiveBasicAuthScheme();
		basicauth.setUserName("ToolsQA");
		basicauth.setPassword("TestPassword");
		RestAssured.authentication=basicauth;
		
		RequestSpecification authrequest=RestAssured.given();
		
		Response response=authrequest.request(Method.GET,"/");
		
		String body=response.getBody().asString();
		System.out.println("Response is"+body);
		
		int statuscode=response.getStatusCode();
		System.out.println("scode is"+statuscode);
		Assert.assertEquals(statuscode,200);
		
		
	}

}
