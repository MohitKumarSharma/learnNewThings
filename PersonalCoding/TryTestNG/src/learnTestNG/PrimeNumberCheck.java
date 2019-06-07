package learnTestNG;

import java.util.stream.IntStream;

public class PrimeNumberCheck {
	public boolean isValidate(int _number) {
		int sqrt = (int) Math.sqrt(_number);
		
		for (int i = 2; i <= sqrt; i++) {
			if (_number%i == 0) {
				return false;
			} 
		}
		
		return true;
		/*return IntStream.range(2, sqrt + 1).allMatch(v -> { 
			if (_number%v == 0) {
				return true;
			} else {
				return false;
			}
			
		});*/
		
	}
}
