package testStatic;

import java.util.HashMap;

class Employee {
	private String name;
	int id;
	
	
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
//	@Override
//	public boolean equals(Object obj) {
//		Employee emp = (Employee)obj;
//		
//		if (this.id == (emp.id)) {
//			return true;
//		}
//		
//		return false;
//	}
	
	@Override
	public int hashCode() {
		return this.id;
	}
}

public class TestHashCode {
	public static void main(String[] args) {
		Employee emp1 = new Employee("Mohit", 1);
		Employee emp2 = new Employee("Mohit", 1);
		
		System.out.println(emp1.hashCode());
		System.out.println(emp2.hashCode());
		
		HashMap<Employee, Integer> empMap = new HashMap<>();
		empMap.put(emp1, emp1.getId());
		//empMap.put(emp2, emp2.getId());
		if (empMap.containsKey(emp2)) {
			System.out.println("Found");
		} else {
			System.out.println("Not Found");
		}
		
		System.out.println("Equals " + (emp1.equals(emp2)));
	}
}
