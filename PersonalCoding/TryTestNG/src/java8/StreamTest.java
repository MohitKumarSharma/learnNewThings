package java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class StreamTest {
	public static void main(String[] args) {
		testStringJoiner();
		testReplaceAll();
		testHashCode();
	}
	
	public static void testMapToObj() {
		String s = "hello world";
		
		IntStream stream = s.chars();
		
		stream.mapToObj((letter) -> (char)letter).map(Character:: toUpperCase).forEach(System.out:: print);
	}
	
	public static void testStringJoiner() {
		StringJoiner sj = new StringJoiner(", ", "{", "}" );
		
		sj.add("one").add("two").add("three");
		
		System.out.println(sj);
	}
	
	public static void testReplaceAll() {
		List<String> ll = Arrays.asList("one", "two");
		
		ll.replaceAll(String:: toUpperCase);
		
		System.out.println(ll);
	}
	
	public static void testHashCode() {
		Integer x = 12;
		String str = "mohit";
		int hashcode = x.hashCode();
		System.out.println(hashcode);
		
		System.out.println(str.hashCode());
	}
	
	
	
}
