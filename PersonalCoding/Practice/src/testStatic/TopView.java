package testStatic;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class TopView {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	
	static class QueueNode {
		Node node;
		int height;
		
		QueueNode(Node _node, int _height) {
			this.node = _node;
			this.height = _height;
		}
	}
	
	public static void topView(Node root) {
		if (root == null) {
			return;
		}
		
		LinkedList<QueueNode> queue = new LinkedList<>();
		LinkedHashMap<Integer, Node> map = new LinkedHashMap<Integer, Node>();
		
		queue.add(new QueueNode(root, 0));
		
		while(!queue.isEmpty()) {
			QueueNode qNode = queue.poll();
			
			if (!map.containsKey(qNode.height)) {
				map.put(qNode.height, qNode.node);
			}
			
			if (qNode.node.left != null) {
				queue.add(new QueueNode(qNode.node.left, qNode.height - 1));
			}
			
			if (qNode.node.right != null) {
				queue.add(new QueueNode(qNode.node.right, qNode.height + 1));
			}
		}
		
		ArrayList<Integer> al = new ArrayList<>(map.keySet());
		
		al.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int tempO1 = Math.abs(o1);
				int tempO2 = Math.abs(o2);
				
				if (tempO1 == tempO2) {
					if (o1 < o2) {
						return -1;
					} else  {
						return 1;
					}
				}
				
				if (tempO1 < tempO2) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		for (Integer key: al) {
			System.out.println(map.get(key).data);
		}
		
//		for (Node node: map.values()) {
//			System.out.print(node.data + " ");
//		}
	}

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
