package APITestAutomation.APITestAutomation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTRequest {
												//BASIC POST REQUEST
	@Test
	
	public void PostRequest() {
		
	RestAssured.baseURI="http://restapi.adequateshop.com/api/Tourist";
	RequestSpecification postrequest=RestAssured.given();
	
	JSONObject requestparams=new JSONObject();
	
	requestparams.put("tourist_name", "mike");
	requestparams.put("tourist_email", "mike1234@gmail.com");
	requestparams.put("tourist_location", "paris");
	
	postrequest.header("Content-Type","application/json;charset=utf-8");
	postrequest.body(requestparams.toJSONString());
	
	Response response=postrequest.request(Method.POST,"/users");
	
	String postBody=response.getBody().asString();
	System.out.println("The response is"+postBody);
	
	int status=response.getStatusCode();
	System.out.println("Status code is"+status);
	
	
	
	
	
	}

}
