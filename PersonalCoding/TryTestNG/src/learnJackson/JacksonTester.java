package learnJackson;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester {
	public static void main(String args[]) throws IOException {
		Student student = new Student();
		student.setName("Mohit");
		student.setAge(27);
		
		ObjectMapper objectMapper = new ObjectMapper();
		testSDBGeneric(student, objectMapper);
		// useFile(student, objectMapper);
		// onConsole(student, objectMapper);
	}
	
	public static void testSDBGeneric(Student student, ObjectMapper objectMapper) throws JsonGenerationException, JsonMappingException, IOException {
		Map<String, UserData> studentMap = new HashMap<>();
		File studentFile = new File("D:\\Devlopment\\learnThings\\student2.json");
	
		int marks[] = {9, 5};
		
		UserData userData = new UserData();
		
		
		userData.setStudent(student);
		userData.setMarks(marks);
		userData.setAliasName("Teetu");
		userData.setVerified(false);
		
		studentMap.put("userData1", userData);
		
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(studentFile, studentMap);
		
		TypeReference<Map<String, UserData>> ref = new TypeReference<Map<String,UserData>>() {
		};
		Map<String, UserData> newUserData = objectMapper.readValue(studentFile, ref);
		
		System.out.println(newUserData);
	}
	
	public static void testSimpleDataBinding(Student student, ObjectMapper objectMapper) throws JsonGenerationException, JsonMappingException, IOException {
		Map<String, Object> studentMap = new HashMap<>();
		File studentFile = new File("D:\\Devlopment\\learnThings\\student1.json");
		
		studentMap.put("student", student);
		double marks[] = {9.3, 5.4};
		studentMap.put("marks", marks);
		studentMap.put("verified", Boolean.FALSE);
		studentMap.put("Name", student.getName());
		
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(studentFile, studentMap);
		
		Map<String, Object> newStudentMap =  objectMapper.readValue(studentFile, LinkedHashMap.class);
		
		System.out.println(newStudentMap);
		System.out.println(newStudentMap.get("student"));
		System.out.println(newStudentMap.get("marks"));
	}
	
	
	
	public static void useFile(Student student, ObjectMapper objectMapper) throws JsonGenerationException, JsonMappingException, IOException {
		File studentFile = new File("D:\\Devlopment\\learnThings\\student.json");
		
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(studentFile, student);
		
		Student newStudent = objectMapper.readValue(studentFile, Student.class);
		System.out.println("From File" + newStudent);
	}
	
	public static void onConsole(Student student, ObjectMapper objectMapper) throws IOException {
		String studentJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
		
		System.out.println("On console Json " + studentJson);
		
		Student newStudent = objectMapper.readValue(studentJson.getBytes(), Student.class);
		
		System.out.println("On console " + newStudent);
	}
}
