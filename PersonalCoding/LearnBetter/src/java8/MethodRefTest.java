package java8;

interface TriFunction<T, U, V, R> {
	public R apply(T t, U u, V v);
}


class Sum {
	public Integer doSum(String s1, String s2) {
		return Integer.parseInt(s2) + Integer.parseInt(s1);
	}
}
public class MethodRefTest {
	
	public static void main(String[] args) {
		TriFunction<Sum, String, String, Integer> tri = (Sum s, String s1, String s2) -> 
			s.doSum(s1, s2);
			
			System.out.println(tri.apply(new Sum(), "45", "65"));
			
			TriFunction<Sum, String, String, Integer> tri1 = Sum::doSum;
			
			System.out.println(tri1.apply(new Sum(), "455", "65"));
	}
}
