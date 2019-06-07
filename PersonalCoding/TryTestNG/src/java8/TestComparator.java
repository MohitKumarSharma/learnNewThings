package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Person {
	private String fName;
	private String lName;
	private int age;
	
	public Person(String fName, String lName, int age) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", age=" + age + "]";
	}
	
	
}

public class TestComparator {
	public static void main(String[] args) {
		//testComparator();
		testMapIterator();
	}
	
	public static void testComparator() {
		List<Person> pList  = new ArrayList<>();
		
		Person mohit = new Person("Mohit", "Kumar", 27);
		Person parag = new Person("Parag", "Sabnis", 28);
		Person aniketh = new Person("Aniketh", "Teluga", 27);
		
		pList.add(mohit);
		pList.add(parag);
		pList.add(aniketh);
		
		Comparator<Person> compartor = Comparator.comparing(Person:: getfName).thenComparing(Person::getlName);
		
		pList.sort(compartor.reversed());
		System.out.println(pList);
	}
	
	public static void testMapIterator() {
		Map<String, Person> map = new HashMap<>();
		Person mohit = new Person("Mohit", "Kumar", 27);
		Person parag = new Person("Parag", "Sabnis", 28);
		Person aniketh = new Person("Aniketh", "Teluga", 27);
		
		map.put(mohit.getfName(), mohit);
		map.put(parag.getfName(), parag);
		
		map.forEach((fName, person) -> {System.out.println(fName + " " + person);});
	}
}
