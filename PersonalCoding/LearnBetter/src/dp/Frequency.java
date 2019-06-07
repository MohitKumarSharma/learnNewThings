package dp;



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Frequency {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
		int len = queries.size();
		
		HashMap<Integer, Integer> occurenceMap = new HashMap<>();
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0;  i < len; i++) {
			int queryType = queries.get(i).get(0);
			int item = queries.get(i).get(1);
			
			if (queryType == 1) {
				if (occurenceMap.containsKey(item)) {
					occurenceMap.put(item, occurenceMap.get(item) + 1);
				} else {
					occurenceMap.put(item, 1);
				}
			} else if (queryType == 2) {
				if (occurenceMap.containsKey(item)) {
					int freq = occurenceMap.get(item);
					
					if (freq == 1) {
						occurenceMap.remove(item);
						
						continue;
					}
					
					occurenceMap.put(item, freq - 1);
				} 
			} else {
				if (occurenceMap.containsValue(item)) {
					result.add(1);
				} else {
					result.add(0);
				}
			}
			
		}
		
		return result;
    }

    
    static List<Integer> freqQuery1(List<List<Integer>> queries) {
		int len = queries.size();
		
		HashMap<Integer, Integer> occurenceMap = new HashMap<>();
		List<Integer> result = new ArrayList<Integer>();
		
		int frequenceis[] = new int[1000000];
		
		for (int i = 0;  i < len; i++) {
			int queryType = queries.get(i).get(0);
			int item = queries.get(i).get(1);
			
			if (queryType == 1) {
				if (occurenceMap.containsKey(item)) {
					Integer occur = occurenceMap.get(item);
					frequenceis[occur] = frequenceis[occur] - 1;
					occurenceMap.put(item, ++occur);
					frequenceis[occur] = frequenceis[occur] + 1;
				} else {
					occurenceMap.put(item, 1);
					frequenceis[1] = frequenceis[1] - 1;
				}
			} else if (queryType == 2) {
				if (occurenceMap.containsKey(item)) {
					int freq = occurenceMap.get(item);
					
					frequenceis[freq] = frequenceis[freq] - 1;
					if (freq == 1) {
						occurenceMap.remove(item);
						
						
						continue;
					}
					
					occurenceMap.put(item, freq - 1);
					frequenceis[freq] = frequenceis[freq - 1] + 1;
				} 
			} else {
				if (frequenceis[item] > 0) {
					result.add(1);
				} else {
					result.add(0);
				}
			}
			
		}
		
		return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
