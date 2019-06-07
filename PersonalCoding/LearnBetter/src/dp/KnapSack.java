package dp;

public class KnapSack {
	public static void main(String[] args) {
		int value[] = {60, 100, 120};
		int weight[] = {10, 20, 30};
		int w = 50;
		
		int[] sol = new int[w + 1];
		
		System.out.println(maxValue(value, weight, w, value.length - 1, sol));
		
		System.out.println(maxValue(value, weight, w));
	}
	
	public static int maxValue(int value[], int weight[], int w, int index, int[] sol) {
		if (w <= 0) {
			return 0;
		}
		
		if (index < 0) {
			return 0;
		}
		
		if (sol[w] != 0) {
			System.out.println(w + " " + sol[w]);
			return sol[w];
		}
		
		sol[w] = Math.max(value[index] + maxValue(value, weight, w - weight[index], index - 1, sol),  maxValue(value, weight, w, index - 1, sol));
		
		
		return sol[w];
	}
	
	public static int maxValue(int value[], int weight[], int w) {
		int n = value.length;
		int sol[][] = new int[w + 1][n];
		
		sol[0][0] = 0;
		
		for (int  i = 1; i <= w; i++) {
			
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					sol[i][j] = 0;
				} else if (weight[j] <= i) {
					sol[i][j] = Math.max(value[j] + sol[w-weight[j]][j - 1], sol[w][j -1]);
				} else {
					sol[i][j] = sol[i][j - 1];
				}
			}
			
		}
		
		printSolution(sol, w, n - 1, weight, value);
		return sol[w][n - 1];
	}
	
	public static void printSolution(int[][]sol, int w, int n, int[] weight, int[] value) {
		if (w <= 0) {
			return;
		}
		
		if (n == 0) {
			if (w == weight[n]) {
				System.out.println(n + "weight of that " + weight[n]);
				return;
			}
			
			return;
		}
		
		if (value[n] + sol[w-weight[n]][n - 1] == sol[w][n]) {
			System.out.println(n + "weight of that " + weight[n]);
			w = w - weight[n];
			n = n - 1;
		} else {
			n = n - 1;
		}
		
		printSolution(sol, w, n, weight, value);
	}
}
