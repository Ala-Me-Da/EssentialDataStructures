/**
  * Node class for use in BinarySearchTree.java
  */ 
public class Node {
	int item;
	static int allPos = 0; 
	int pos; // TODO: Figure out how to update this
	Node right;
	Node left; 
	
	public Node(int i) { 
		item = i; 
		pos = allPos++; 
		//System.out.println(pos); 
	}
} 
