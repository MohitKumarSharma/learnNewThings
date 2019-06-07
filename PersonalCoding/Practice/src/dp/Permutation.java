package dp;

public class Permutation {
	public static void main(String[] args) {
		int n = 10;
		int k = 2;
		System.out.println(calPerm(n, k));
		
		System.out.println(calPerm(n, k));
	}
	
	public static long calPerm(int n, int k) {
		
		if (k == 0) {
			return 1;
		}
		
		if (n <= 0 || k <= 0) {
			System.out.println(n + " "  + k);
			return 0;
		}
		
		long res = calPerm(n - 1, k) + k*calPerm(n - 1, k - 1);
		
		return res;
	}
	
	public static long calPerm1(int n, int k) {
		int sol[][] = new int[n + 1][k + 1];
		
		
		for (int i = 0; i < k; i++) {
			sol[0][k] = 0;
		}
		
		for (int i = 0; i < n; i++) {
			sol[i][0] = 1;
		}
		
		
		
		for(int i = 1; i <= n; i++) {
			for (int j = 1; j < k; j++) {
				sol[i][j] = sol[i - 1][j] + j*sol[i - 1][j - 1];
			}
		}
		
		return sol[n][k];
	} 
}
