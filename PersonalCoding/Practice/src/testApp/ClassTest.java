package testApp;

import java.util.LinkedHashMap;

public class ClassTest {
	public static void main(String args[]) {
		LinkedHashMap<Integer, Integer> lhm = getCustomObj(Integer.class);
		
		System.out.println(lhm);
	}
	
	public static <X> LinkedHashMap<X, Integer> getCustomObj(Class<X> _type) {
		if (String.class.equals(_type)) {
			System.out.println("Matched");
		} else {
			System.out.println("Not Matched");
		}
		
		LinkedHashMap<X, Integer> samples = null;
		
		if (Integer.class.getName().equals(_type.getName())) {
			samples = new LinkedHashMap<X, Integer>();
			for (int i = 0; i < 5; i++) {
				samples.put(_type.cast(i), i);
			}
		} else {
			samples = new LinkedHashMap<X, Integer>();
			for (int i = 0; i < 5; i++) {
				samples.put(_type.cast(i + "1"), i);
			}
		}
		
		return samples;
	}

}
