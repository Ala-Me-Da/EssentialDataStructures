import java.util.ArrayList; 
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

class BinaryTree<E> {
	class Node {
		E    item;
		Node right; 
		Node left;
		Node parent;
		Node(E elem) { item = elem; }
	}

	private Node root;
	private Node current = root;
	private Node found;

	public void insert(E item) {
		current = insert(current, null, item);
	}

	private Node insert(Node node, Node parent, E item) {
		if(node == null) {
			node = new Node(item);
			node.parent = parent;
		} else {
			if (node.left == null) {
				node.left = insert(node.left, node, item);
			} else
				node.right = insert(node.right, node, item); //lop-sided on the right
		}

		return node;
	}

	public void remove(E item) { current = remove(current, item); }

	private Node remove(Node node, E item) {
			if(node == null)
				return node;

			E obj = node.item;
			node.left = remove(node.left, item);
			if(obj.equals(item)) {
				if(node.left == null) {
					System.out.println("left is null");
					return node.right;
				} else if (node.right == null) {
					System.out.println("right is null");
					return node.left;
				} else {
					node.left.right = node.right;
					return node.left;
				}
			}
			node.right = remove(node.right, item);

			return node;
	}

	public E find(E item) {
			find(current, item);
			return (found != null) ? found.item : null;
	}

	private void find(Node node, E item) {
			if(node != null) {
				E object = node.item;
				find(node.left, item);
				if(object.equals(item)) {
					found = node;
				}
				find(node.right, item);
			}
	}


	public void displayTree() {
		System.out.println("In-Order Traversal");
		displayTree(current);
		System.out.println("Level-Order Traversal");
		displayTreeLevelOrder();
	}

	/** In-Order Traversal of the Binary Tree to display contents. */
	private void displayTree(Node node) {
		if(node != null) {
			displayTree(node.left);
			System.out.println(node.item);
			displayTree(node.right);
		}
	}

	/** Level-Order Traversal of Binary Tree. */ 
	public void displayTreeLevelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(current);
		while(queue.peek() != null) {
			Node currentNode = queue.poll();
			if(currentNode != null) {
					System.out.println(currentNode.item);

					if(currentNode.left != null) {
						// Add left node to be dequeued for processing later.
						queue.add(currentNode.left);
					}

					if(currentNode.right != null) {
						// Add right node to be dequeued for processing later.
						queue.add(currentNode.right);
					}
			}
		}
	} 

	public static void main(String[] args) {
		BinaryTree<String> b = new BinaryTree<String>();
		b.insert("a");
		b.insert("b");
		b.insert("c");
		b.insert("d");
		b.insert("e");

		b.displayTree();
		b.remove("a");
		b.remove("b");
		b.remove("c");
		b.remove("d");
		b.remove("e");
		

		b.insert("a");
		b.insert("b");
		b.insert("c");
		b.insert("d");
		b.insert("e");
		b.insert("a");
		b.insert("b");
		b.insert("c");
		b.insert("d");
		b.insert("e");
		b.insert("f");

		b.displayTree();

		System.out.println(b.find("f"));
	}
} 
