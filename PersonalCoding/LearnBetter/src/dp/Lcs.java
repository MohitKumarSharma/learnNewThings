package dp;

public class Lcs {
	public static void main(String args[]) {
		System.out.println(maxLCS("mohitkumar", "kumarmohit"));
	}
	
	public static int maxLCS(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		int dp[][] = new int[m + 1][n + 1];
		
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i -1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i -1][j]);
				}
			}
		}
		
		int i = m;
		int j = n;
		StringBuilder sb = new StringBuilder();
		
		while (dp[i][j] != 0 && i > 0 && j > 0 ) {
			if (dp[i][j] == (dp[i -1][j-1] + 1)) {
				sb.append(s1.charAt(i-1));
				i = i - 1;
				j = j - 1;
			} else if (dp[i][j] == dp[i][j-1]) {
				j = j-1;
			} else {
				i = i -1;
			}
		}
		
		System.out.println(sb.reverse().toString());
		
		return dp[m][n];
	}
}
