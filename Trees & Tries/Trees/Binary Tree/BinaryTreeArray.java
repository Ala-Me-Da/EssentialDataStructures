import java.util.ArrayList; 

class BinaryTreeArray<E> {
	private ArrayList<E> treeArray; 
	private int index;

	/**
	 *  Default Constructor to intialize the Binary Tree structure.
	 */
	public BinaryTreeArray() {
		treeArray = new ArrayList<E>(); 
		index = 0; 
	}

	/**
	 * Inserts an item into the list.
	 * @param item
	 */
	public void insert(E item) {
		treeArray.add(item); 
		index++; 
	}

	/**
	 * Removes an item from the Binary Tree. Requirement of the Binary Tree as a dynamic set.
	 * Runtime: O(n) to search for the item, and then O(1) time to remove the item.
	 * @param item Specified item to be deleted. If item is not in the tree, the remove() method outputs an error.
	 */
	public void remove(E item) {
		int target = search(item);
		if(target == -1) {
			System.out.println("No such item in the tree.");
			return;
		}

		int leftChildIndex = 2*target + 1;
		int rightChildIndex = 2*target + 2;
		//double parentIndex = Math.ceil(target / 2)  - 1;

		// Check if our target node contains children
		// Will not have children if the indices go out of bounds.
		// In that case, initalize left / right to null.
		E left = (leftChildIndex >= treeArray.size()) ? null : treeArray.get(2*target + 1);
		E right = (rightChildIndex >= treeArray.size()) ? null : treeArray.get(2*target + 2);


		if(left == null && right == null) {
			// No children. Just delete the node from the array.
			System.out.println("leaf");
			treeArray.set(target, null);
			index--;
		} else if(left != null && right == null) {
			// One child on the left.
			// Overwrite (set) parent to child
			// Delete left child.
			System.out.println("left");
			treeArray.set(target, treeArray.get(leftChildIndex));
			treeArray.set(leftChildIndex, null);
			index--;
		} else if(left == null && right != null) {
			// One child on the right.
			// Overwrite (set) parent to right child.
			// Delete right child by setting node to null.
			System.out.println("right");
			treeArray.set(target, treeArray.get(rightChildIndex));
			treeArray.set(rightChildIndex, null);
			index--;
		} else {
			// Two children.
			// Overwrite the parent node with one of the children (the left child node here)
			// Delete left child node.
			System.out.println("Two children");
			treeArray.set(target, treeArray.get(leftChildIndex));
			treeArray.remove(leftChildIndex);
			index--;
		}
	}


	/**
	 *  Basic search method to fulfill requirement of Binary Trees as a dynamic set.
	 *  Runtime: O(n), where n is the number of elements in the Binary Tree.
	 *  Space  : O(1)
	 * @param item Specific item or target value to find in the binary tree. 
	 * @return position of the specific item in the binary tree.
   	 */ 
	public int search(E item) {
		int position = treeArray.indexOf(item); 
		return position; 
	}

	/**
	 * Level Order Traversal of the Binary Tree to display all contents.
	 */
	public void displayTree() {
		int i = 0;
		for(E node : treeArray) {
			if(node != null) {
				System.out.println("Index: " + i + " item: " + node);
				i++;
			}
		}
	}

	/**
	 * Mandatory main method / thread for the BinaryTreeArray<E>() class. Tests basic functionality of the class methods.
	 * @param args Command line input container. Not used here.
	 */
	public static void main(String[] args) {
		BinaryTreeArray<Integer> b = new BinaryTreeArray<Integer>();

		b.insert(0);
		b.insert(1);
		b.insert(2);
		b.insert(3);
		b.insert(4);
		b.insert(5);
		b.displayTree();

		// Removes a leaf from the tree.
		b.remove(3);
		System.out.println("\n");
		b.displayTree();

		// Removes a node with one child (on the left);
		b.remove(2);
		System.out.println("\n");
		b.displayTree();

		// Removes a node with one child (on the right);
		b.remove(1);
		System.out.println("\n");
		b.displayTree();

		// Removes a node with two children (the root, in this case)
		b.remove(0);
		System.out.println("\n");
		b.displayTree();

		int indexOfItem = b.search(5);
		System.out.println("Item 5 is stored at index: " + indexOfItem); // should be 1
	} 
}
