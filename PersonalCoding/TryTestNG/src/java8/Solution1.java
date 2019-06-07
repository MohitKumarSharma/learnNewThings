package java8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1 {

	static class LevelNode {
		private int level = 0;
		private int nodeId;
		private ArrayList<Integer> list;
		
		public LevelNode(int _nodeId, int _level, ArrayList<Integer> _list) {
			this.level = _level;
			this.list = _list;
			this.nodeId = _nodeId;
		}

		public int getLevel() {
			return level;
		}

		public ArrayList<Integer> getList() {
			return list;
		}

		public int getNodeId() {
			return nodeId;
		}
		
		
	}
    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
    	ArrayList<Integer>[] graphList = new ArrayList[graphNodes + 1];
    	
    	for (int i = 1; i <= graphNodes; i++) {
    		graphList[i] = new ArrayList<>();
    	}
    	
    	for (int i = 0; i < graphFrom.length; i++) {
			if (!graphList[graphFrom[i]].contains(graphTo[i])) {
				graphList[graphFrom[i]].add(graphTo[i]);
			}
			
			if (!graphList[graphTo[i]].contains(graphFrom[i]))
				graphList[graphTo[i]].add(graphFrom[i]);
    	}
    	
    	
    	boolean visited[] = new boolean[graphNodes + 1];
    	
    	Queue<LevelNode> levelQueue = new LinkedList<>();
    	
    	LevelNode firstLevel = new LevelNode(val, 0, graphList[val]);
    	levelQueue.add(firstLevel);
    	
    	long colorId = ids[val - 1];
    	int newLevel = -1;
    	boolean found = false;
    	
    	while(!levelQueue.isEmpty()) {
    		LevelNode levelsNode = levelQueue.remove();
    		
    		visited[levelsNode.getNodeId()] = true;
    		
    		for (Integer node: levelsNode.getList()) {
    			if (visited[node]) {
        			continue;
        		}
    			
    			newLevel = levelsNode.getLevel() + 1;
    			
    			levelQueue.add(new LevelNode(node, newLevel, graphList[node]));
    			
    			if (ids[node - 1] == colorId) {
    				found = true;
    				break;
    			}
    		}
    		
    		if (found) {
    			break;
    		}
    	}
    
    	if (found) {
    		return newLevel;
    	} else {
    		return -1;
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        System.out.println(String.valueOf(ans));
      

        scanner.close();
    }
}
