package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompareTest {
	public static void main(String[] args) {
		List<String> ll = new ArrayList<String>();
		
		Comparator<String> cmptr = (s1, s2) -> s1.compareTo(s2);
		
		ll.add("Mohit");
		ll.add("Parag");
		ll.add("Aniketh");
		
		ll.sort(cmptr);
		
		ll.forEach(System.out::println);
		
	}

}
