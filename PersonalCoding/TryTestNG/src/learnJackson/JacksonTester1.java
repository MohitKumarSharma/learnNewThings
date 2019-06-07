package learnJackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester1 {
	public static void main(String args[]) {
		Student student = new Student();
		student.setName("Mohit");
		student.setAge(27);
		
		ObjectMapper objectMapper = new ObjectMapper();
	}
}
