package APITestAutomation.APITestAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETrequest{					//BASIC GET REQUEST
	@Test
	public void getRequest()
	{
		RestAssured.baseURI="https://gorest.co.in";
		
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.request(Method.GET,"/public/v2/users/200");
		
		String Body=response.getBody().asString();
		System.out.println("The response is :"+Body);
		
		int status=response.getStatusCode();
		System.out.println("The status code is ; "+status);
		Assert.assertEquals(status, 200);
		
		//validate content type header---------------------------------
		
		String headertype=response.header("Content-Type");
		System.out.println("header"+headertype);
		Assert.assertEquals(headertype,"application/json; charset=utf-8");
		
		
	}
}