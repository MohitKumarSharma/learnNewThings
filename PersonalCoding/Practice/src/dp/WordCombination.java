package dp;

public class WordCombination {
	public static void main(String[] args) {
		String str = "781122654234324234234234234732473328472834792837428374823748937492739847";
		
		int combinaion = findCombination(str, 0);
		
		
		System.out.println(combinaion);
		
		combinaion = findCombination(str);
		
		System.out.println(combinaion);
		
	}
	
	

	// Using recursion
	private static int findCombination(String str, int index) {
		if (index >= str.length()) {
			return 1;
		}
		
		int result = findCombination(str, index + 1);
		
		if ((index + 2) > str.length()) {
			return result;
		}
		
		if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
			result += findCombination(str, index + 2);
		}
		
		return result;
	}
	
	// Using table
	/**
	 * This algorithm is same as fibonacci with custom check.
	 * 
	 * Mistake i was thinking dp problem generally take two loops but not in every case
	 * like fibonacci and in this case complexity is O[n]. So it conclude how many loops
	 * required it all depends on the problems.
	 * 
	 * It is very tricky problem. This problems took a lot of time to solve.
	 * 
	 * @param str -[In] String on which combination we have to count.
	 * 
	 * @return Combination could be formed using string.
	 */
	private static int findCombination(String str) {
		int n = str.length();
		
		if (n <= 1) {
			return n;
		}
		
		int sol[] = new int[n + 1];
		sol[1] = 1;
		sol[0] = 1;
		
		for (int i = 1; i < n; i++) {
			
			if (Integer.parseInt(str.substring(i - 1, i + 1))<= 26) {
				
				sol[i + 1] = sol[i] + sol[i - 1];
			} else {
				sol[i + 1] = sol[i];
			}
		}
		
		return sol[n];
	}
	
}
