package APITestAutomation.APITestAutomation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUT_Request {
	@Test
	public  void put_request() {
	RestAssured.baseURI="http://restapi.adequateshop.com";
	RequestSpecification putrequest=RestAssured.given(); 
	
	JSONObject put=new JSONObject();
	
	put.put("tourist_name", "Thomas Test");
	put.put("tourist_email", "thomastest1@gmail.com");
	
	putrequest.headers("Content-Type","application/json");
	putrequest.body(put.toJSONString());
	
	Response putresponse=putrequest.request(Method.PUT,"/api/Tourist/117207");
	
	String output=putresponse.getBody().asPrettyString();
	System.out.println("The edited data is :"+output);

}
}