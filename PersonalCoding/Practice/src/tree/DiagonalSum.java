package tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Node {
	Node left;
	Node right;
	int data;
}

public class DiagonalSum {

	public Map<Integer, Integer> diagonalSum(Node root) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(root);
		
		while (root != null) {
			queue.add(root);
			root = root.right;
		}
		
		int index = -1;
		
		
		 while (!queue.isEmpty()) {
			 	index++;
			 	int sum = 0;
				Queue<Node> tQueue = new LinkedList<>();
				
			 while (!queue.isEmpty()) {
					
					Node tmp = queue.poll();
					
					sum = tmp.data;
					
					tQueue.add(tmp.left);
				}
			 
			 map.put(index, sum);
			 
			 Iterator<Node> itr = tQueue.iterator();
			 
			 while (itr.hasNext()) {
				 Node tmp = itr.next();
				 
				 while (tmp.right != null) {
					 tQueue.add(tmp.right);
					 tmp = tmp.right;
				 }
			 }
			 
			 queue = tQueue;
				
		 }
		
		return map;
	}
	
	public static void usingTraverse() {
		Node root = new Node();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
	}
	
	public static void traversing(Node node, int height, Map<Integer, Integer> map) {
		if (node == null) {
			return;
		}
		
		traversing(node.left, height + 1, map);
		
		Integer sum = map.get(height);
		
		if (sum == null) {
			sum = 0;
		}
		
		sum += node.data;
		
		map.put(height, sum);
		
		traversing(node.right, height, map);
		
	}
	
	// There could be better solutino
}
