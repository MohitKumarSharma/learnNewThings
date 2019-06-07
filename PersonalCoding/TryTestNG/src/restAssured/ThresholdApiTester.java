package restAssured;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class ThresholdApiTester {
	final String URL = "https://localhost:8443/alertapi/threshold";
	
	
	public static void createThreshold() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name","t2");
		jsonObj.put("metric","status");
		jsonObj.put("resource_type", "fabCiscoSwitchPort");
		jsonObj.put("critical", "up");
		Response resp = RestAssured.given().contentType("application/json").auth().digest("Authorization", "Basic YWRtaW46Q3VtdWx1c0Ax")
				.body(jsonObj.toJSONString()).when().post();
		
		System.out.println(resp.asString());
		
		resp.then().body("id", Matchers.any(Integer.class));
	}
	
	public static void main(String args[]) {
		createThreshold();
	}
}
