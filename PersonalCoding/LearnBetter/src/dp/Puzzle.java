package dp;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Puzzle {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
    	int count = n;
    	
    	if (count <= 1) {
    		return count;
    	}
    	
    	int i, j, k;
    	char nc, pc, cc, oldcc;
    	
    	i = 0;
    	
    	while (i < n) {
    		cc = s.charAt(i);
    		j = i + 1;
    		
    		boolean found = false;
    		
    		while(j < n) {
    			nc = s.charAt(j);
    			
    			if (cc == nc) {
    				count++;
    				j++;
    				found = true;
    			} else {
    				break;
    			}
    		}
    		
    		if (found) {
    			i++;
    			continue;
    		}
//    		if (j - i > 1) {
//    			i = j;
//    		} 
    		
    		k = i - 1;
    		j = i + 1;
    		
    		oldcc = 0;
    		
    		while (k >= 0 && j < n) {
    			pc = s.charAt(k);
    			nc = s.charAt(j);
    			
    			if (oldcc != 0 && oldcc != pc) {
    				break;
    			}
    			
    			if (pc == nc) {
    				count++;
    				j++;
    				k--;
    				
    			} else {
    				break;
    			}
    			
    			oldcc = nc;
    		}
    		
//    		if (j - i > 1) {
//    			i = j - 1;
//    		} else {
//    			i = j;
//    		}
//    		
//    		i = j;
    		
    		i++;
    	}
    	
    	return count;
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
