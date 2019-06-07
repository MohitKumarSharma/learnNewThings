package testStatic;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution1 {

	static long arrayManipulation(int n, int[][] queries) {
		int arr[] = new int[n];
		
		Arrays.stream(queries).forEach(query -> {
			int a = query[0];
			int b = query[1];
			int k = query[2];
			
			arr[a] += k;
			
			if (b + 1 < n) {
				arr[b + 1] -= k;
			}
			
		});
		
		long max = Integer.MIN_VALUE;
		long trackMax = 0;
		
		//Arrays.stream(arr).re
		
		for (int i = 0; i < arr.length; i++) {
			trackMax += arr[i];
			
			if (trackMax > max) {
				max = trackMax;
			}
		}
		
		return max;
		
	}
	/*static class CustomDataStruct implements Comparable<CustomDataStruct> {
		int start, end, score;
		
		public CustomDataStruct(int _start, int _end, int _score) {
			this.start = _start;
			this.end = _end;
			this.score = _score;
		}

		@Override
		public int compareTo(CustomDataStruct o) {
			if (this.start < o.start) {
				return -1;
			} else if (this.start > o.start) {
				return 1;
			} else {
				return 0;
			}
			
		}
	}
	
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
    	ArrayList<CustomDataStruct> queryOutList = new ArrayList<>();
    	
    	for (int i = 0; i < queries.length; i++) {
    		int a = queries[i][0];
    		int b = queries[i][1];
    		int k = queries[i][2];
    		
    		int tempEnd = 0;
    		
    		if (queryOutList.size() == 0) {
    			CustomDataStruct cdst2 = new CustomDataStruct(a, b, k);
    			queryOutList.add(cdst2);
    			continue;
    		}
    		
    		Collections.sort(queryOutList);
    		
    		ListIterator<CustomDataStruct> litr = queryOutList.listIterator();
    		
    		boolean isAdded = false;
    		
    		while (litr.hasNext()) {
    			CustomDataStruct temp = litr.next();
    			
    			if (temp.start == a && temp.end == b) {
    				temp.score += k;
    				isAdded = true;
    			} else if (temp.start >= a && temp.end <= b) {
    				CustomDataStruct cdst1 = new CustomDataStruct(a, temp.start - 1, k);
    				CustomDataStruct cdst2 = new CustomDataStruct(temp.start, temp.end, k + temp.score);
    			//	CustomDataStruct cdst3 = new CustomDataStruct(temp.end, b, k);
    				isAdded = true;
    				if (temp.end > tempEnd) {
    					tempEnd = temp.end;
    				}
    				
    				a = temp.start + 1;
    				
    				litr.remove();
    				litr.add(cdst1);
    				litr.add(cdst2);
    				
    				
    				//litr.add(cdst3);
    			}  else if (temp.start <= a && temp.end >= b) {
    				CustomDataStruct cdst1 = new CustomDataStruct(temp.start, a - 1, temp.score);
    				CustomDataStruct cdst2 = new CustomDataStruct(a, b, k + temp.score);
    				CustomDataStruct cdst3 = new CustomDataStruct(b + 1, temp.end, temp.score);
    				isAdded = true;
    				litr.remove();
    				litr.add(cdst1);
    				litr.add(cdst2);
    				litr.add(cdst3);
    			} else if (temp.start >= a && temp.end >= b && b >= temp.start) {
    				CustomDataStruct cdst1 = new CustomDataStruct(a, temp.start - 1, temp.score);
    				CustomDataStruct cdst2 = new CustomDataStruct(temp.start, b, k + temp.score);
    				CustomDataStruct cdst3 = new CustomDataStruct(b + 1, temp.end, temp.score);
    				isAdded = true;
    				a = temp.end + 1;
    				litr.remove();
    				litr.add(cdst1);
    				litr.add(cdst2);
    				litr.add(cdst3);
    		
    			}  else if (temp.start <= a && temp.end <= b && a <= temp.end) {
    				CustomDataStruct cdst1 = new CustomDataStruct(temp.start, a - 1, temp.score);
    				CustomDataStruct cdst2 = new CustomDataStruct(a, temp.end, k + temp.score);
    				// CustomDataStruct cdst3 = new CustomDataStruct(temp.end, b,  k);
    				isAdded = true;
    				if (temp.end > tempEnd) {
    					tempEnd = temp.end;
    				}
    				
    				litr.remove();
    				litr.add(cdst1);
    				litr.add(cdst2);
    				//litr.add(cdst3);
    		
    			} else {
    				
    			}
    		}
    		
    		if (tempEnd != 0) {
    			litr.add(new CustomDataStruct(tempEnd + 1, b, k));
    		}
    		
    		if (!isAdded) {
    			CustomDataStruct cdst2 = new CustomDataStruct(a, b, k);
    			queryOutList.add(cdst2);
    		}
    	}
    	
    	
    	int maxScore = 0;
    	
    	for (CustomDataStruct cstdS: queryOutList) {
    		if (cstdS.score > maxScore) {
    			maxScore = cstdS.score;
    		}
    	}
        return maxScore;

    }*/

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(result);
       
        scanner.close();
    }
}
