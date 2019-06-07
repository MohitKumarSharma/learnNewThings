package dp;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxSum {

	static HashMap<Integer, Integer> processedResult = new HashMap<Integer, Integer>();
    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
    	
    	int max = maxSubsetSum(arr, 0, 0);
    	
    	if (max == 0) {
    		max = Integer.MIN_VALUE;
    		
    		max = Arrays.stream(arr).min().getAsInt();
    	}
    	
    	return max;
    }
    
    static int maxSubsetSum(int[] arr, int index, int sum) {
    	if (index >= arr.length) {
    		return sum;
    	}
    	
    	int newSum = arr[index] + sum;
    	
    	if (newSum <= sum ) {
    		index = index + 1;
    	} else {
    		sum =  newSum;
    		index = index + 2; 
    	}
    	
    	processedResult.put(index, sum);
    	return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        System.out.println(res);
       

        scanner.close();
    }
}
