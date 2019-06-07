package tree.traversal;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

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

public class InorderWithoutRecursion {

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void inOrder(Node root) {
    	Stack<Node> stack = new Stack<>();
    	
    	while (root != null || !stack.isEmpty()) {
    		while (root != null) {
    			stack.push(root);
    			root = root.left;
    		}
    		
    		root = stack.pop();
    		
    		System.out.println(root.data);
    		
    		root = root.right;
    	}
    }
    
    public static void preOrder(Node root) {
    	if (root == null) {
    		return;
    	}
    	
    	Stack<Node> stack = new Stack<>();
    	
    	stack.push(root);
    	
    	while (!stack.isEmpty()) {
			root = stack.pop();
			
			System.out.println(root.data);
			
			if (root.right != null) {
				stack.add(root.right);
			}
			
			if (root.left != null) {
				stack.add(root.left);
			}
    		
    	}
    }

    
    public static void postOrder(Node root) {
    	Stack<Node> stack = new Stack<>();
    	Set<Node> nodeList = new HashSet<>();
    	
    	while (root != null || !stack.isEmpty()) {
    		while (root != null) {
    			stack.push(root);
    			root = root.left;
    		}
    		
    		while (!stack.isEmpty()) {
    			root = stack.peek();
        		
        		if (root.right != null && !nodeList.contains(root.right)) {
        			root = root.right;
        			
        			break;
        		}
        		
        		System.out.print(root.data + " ");
        		nodeList.add(root);
        		
        		stack.pop();
        		
        		root = null;
    		}
    		
    	}
    }
    
    public static void postOrder1(Node root) {
    	if (root == null) {
    		return;
    	}
    	
    	Stack<Node> stack1 = new Stack();
    	Stack<Node> stack2 = new Stack();
    	
    	Node current = root;
    	
    	stack1.push(current);
    	
    	while(!stack1.isEmpty()) {
    		current = stack1.pop();
    		
    		stack2.push(current);
    		
    		if (current.left != null) {
    			stack1.push(current.left);
    		}
    		
    		if (current.right != null) {
    			stack2.push(current.right);
    		}
    	}
    	
    	
    	while(!stack2.isEmpty()) {
    		System.out.print(stack2.pop().data + " ");
    	}
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
        postOrder(root);
    }	
}