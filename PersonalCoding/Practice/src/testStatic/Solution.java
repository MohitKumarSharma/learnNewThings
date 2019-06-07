package testStatic;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the isValid function below.
	static String isValid(String s) {
		if (s.length() == 1) {
			return "YES";
		}

		int occurrence[] = new int[26];

		s.chars().forEach(i -> {
			occurrence[i - 'a']++;
		});

		for (int i = -1; i < 26; i++) {
			if (i >= 0 && occurrence[i] == 0) {
				continue;
			}
			
			if (i >= 0) {
				occurrence[i]--;
			}
			
			Set<Integer> uniqFreqency = new HashSet<>();
			
			for (int j = 0; j < 26; j++) {
				if (occurrence[j] == 0) {
					continue;
				}
				
				uniqFreqency.add(occurrence[j]);
			}
			
			if (uniqFreqency.size() == 1) {
				return "YES";
			}
			
			if (i >= 0) {
				occurrence[i]++;
			}
		}

		return "NO";
	}
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);
        System.out.println(result);
        /*bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();
*/
        scanner.close();
    }
}
