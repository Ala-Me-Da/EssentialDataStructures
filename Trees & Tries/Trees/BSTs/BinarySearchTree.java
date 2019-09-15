/**
  * TODO (1) Do an array implementation. 
  */

import java.util.LinkedList; 
import java.util.Queue; 
 
class BinarySearchTree {
	private Node root; 
	private int found; 

	public void insert(int item) {
		root = insert(root, item); 
	} 

	public void remove(int item) {
		root = remove(root, item); 
	} 		
	
	public int search(int item) {
		if(root == null) {
			System.out.println("Tree is empty."); 
			return -1; 
		} 

		return search(root, item); 
	} 
	
	public void displayTree() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);  
		Node currentNode; 
		while(queue.peek() != null) {
			currentNode = queue.poll(); 
			System.out.println(currentNode.item); 
			
			if(currentNode.left != null) queue.add(currentNode.left);
			if(currentNode.right != null) queue.add(currentNode.right);  
		} 
	} 

	private Node insert(Node node, int item) {
		if(node == null) {	
			Node newNode = new Node(item); 
			return newNode; 
		} else if (item >= node.item) {
			node.right = insert(node.right, item); 
			return node; 
		} else if( item < node.item) {
			node.left = insert(node.left, item);
			return node;  
		} 

		return null; 
	}

	private Node remove(Node node, int item) {
		if(item < node.item) {
			node.left = remove(node.left, item);  
		} else if( item > node.item) {
			node.right = remove(node.right, item); 
		} else { 
			if(node.left == null) {
				return node.right; 
			} else if(node.right == null) {
				return node.left; 
			} 

			node.item = getMin(node.right); 
			node.right = remove(node.right, root.item); 
		} 

		return node; 
	} 


	private int search(Node node, int item) { 
		if(node != null) {
			search(node.left, item); 
			if(node.item == item) {
				found = node.item;
			} 
			search(node.right, item); 
		}
		return found; 
	}  
	
	private int getMin(Node node) {
		int currentMin = node.item; 

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node); // Start with Root 
		while(queue.peek() != null) {
			node = queue.poll(); 
			if(currentMin > node.item) {
				currentMin = node.item; 
			} 	
			
			if(node.left != null) queue.add(node.left); 
			if(node.right != null) queue.add(node.right); 
		} 

		return currentMin; 

	} 

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(); 
	
		/** Unit testing of insert() method */ 
		for(int i = 0; i <= 10; i++) {
			bst.insert(i); 
		} 	
		
		/** Unit testing of remove() and displayTree() method */ 	
		for(int i = 0; i < 5; i++) {
			bst.remove(i); 
		} 	

		bst.displayTree(); 

		/** Unit testing of search() method error handling */ 
		for(int i = 5; i <= 10; i++) {
			bst.remove(i); 
		}

		System.out.println("Value not found or Tree empty returns -1: " + bst.search(5));

		/** Unit testing of search() */ 
		for(int i = 0; i <= 25; i++) {
			bst.insert(i*i); 
		}    
		
		bst.displayTree(); 
		System.out.println("Look for 25 in the squares BST: " + bst.search(25)); 
		System.out.println("Look for 49 in the squares BST: " + bst.search(49)); 
		System.out.println("Look for 0 in the squares BST (beginning): " + bst.search(0)); 
		System.out.println("Look for 625 in the squares BST (end): " + bst.search(625)); 
		
	} 

} 
