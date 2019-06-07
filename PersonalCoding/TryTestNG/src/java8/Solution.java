package java8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

public class Solution {

	// Complete the roadsAndLibraries function below.
	static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
		if (c_lib <= c_road) {
			return (long)n*c_lib;
		}
		
    	int m = cities.length;
		ArrayList<Integer>[] graphList = new ArrayList[n + 1];
		
		// initializing 
        for (int i = 0; i <= n; i++) { 
        	graphList[i] = new ArrayList<Integer>(); 
        } 
  
		
		for (int i = 0; i < m; i++) {
			graphList[cities[i][0]].add(cities[i][1]);
			graphList[cities[i][1]].add(cities[i][0]);
		}
		
		boolean visited[] = new boolean[n + 1];
		
		long cost = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				int nV = dfs(graphList, n, i, visited) ;
				
				cost += ((long)(nV - 1))* c_road + c_lib;
				
			}
		}
		
    	return cost;

    }
	
	public static int dfs(ArrayList<Integer> _graph[], int n, int v, boolean _visited[]) {
		if (_visited[v]) {
			return 0;
		}
		
		_visited[v] = true;
		
		int nV = 0;
		int size = _graph[v].size();
		
		for (int i = 0; i < size; i++) {
			if (!_visited[_graph[v].get(i)]) {
				nV += dfs(_graph, n, _graph[v].get(i), _visited); 
			}
		}
		
		return nV + 1;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] nmC_libC_road = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nmC_libC_road[0]);

			int m = Integer.parseInt(nmC_libC_road[1]);

			int c_lib = Integer.parseInt(nmC_libC_road[2]);

			int c_road = Integer.parseInt(nmC_libC_road[3]);

			int[][] cities = new int[m][2];

			for (int i = 0; i < m; i++) {
				String[] citiesRowItems = scanner.nextLine().split(" ");
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				for (int j = 0; j < 2; j++) {
					int citiesItem = Integer.parseInt(citiesRowItems[j]);
					cities[i][j] = citiesItem;
				}
			}

			long result = roadsAndLibraries(n, c_lib, c_road, cities);

			System.out.println(result);

		}

		scanner.close();
	}
}
