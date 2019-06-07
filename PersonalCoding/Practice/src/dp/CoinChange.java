package dp;

public class CoinChange {
	static int[] aCoins = {1, 2, 3, 4, 5};
	
	public static void main(String[] args) {
		int solution[][] = new int[6][11]; 
		System.out.println(coins(5, 10, solution));
	}
	
	public static int coins(int i, int amount, int[][] solution) {
		if (amount == 0) {
			return 1;
		}
		
		if (amount < 0) {
			return 0;
		}
		
		if (i <=0 && amount >= 1) 
			return 0; 
		
		if (solution[i][amount] != 0) {
			System.out.println("found " + i + " " + amount);
			return solution[i][amount];
		}
		
		solution[i][amount] = coins(i, amount - aCoins[i - 1], solution) + coins(i - 1, amount, solution);
		
		return solution[i][amount];
	}
}
