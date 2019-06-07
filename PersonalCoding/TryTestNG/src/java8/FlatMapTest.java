package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

class Exc0 extends Exception {
	
}

class Exc1 extends Exc0 {
	
}

interface I1 {
	public void method1();
}

class TClass {
	public void method1() {
		System.out.println("Method1");
	}
}

class TClass1 extends TClass implements I1 {
	
}

public class FlatMapTest {
	public static void main(String[] args) {
		TClass1 t1 = new TClass1();
		t1.method1();
		try {
			throw new Exc1();
		} catch (Exc0 e0) {
			System.out.println("e0");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	public static void testMap() {
		List<Integer> l1 = Arrays.asList(1, 2, 3, 4);
		List<Integer> l2 = Arrays.asList(11, 21, 31, 41, 51);
		List<Integer> l3 = Arrays.asList(11, 12, 13);
		
		List<List<Integer>> list = Arrays.asList(l1, l2, l3);
		
		Function<List<Integer>, Integer> mapStream = l -> l.size();
		list.stream().map(mapStream).forEach(i -> System.out.println(i));
		
		Function<List<Integer>, Stream<Integer>> flatMapStream = l -> l.stream();
		
		list.stream().flatMap(flatMapStream).forEach(i -> System.out.println(i));
	}
}
