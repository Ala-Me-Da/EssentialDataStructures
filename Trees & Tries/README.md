# Trees # 

Trees (and Tries) are a collection of nodes with no cycles. Trees start with a root, and consist of subtrees stemming from that 
root. 

## Tree Terminology & Definitions ## 

**root**: The first node in a tree. 

**edge**: A connection between two nodes in a tree (or graph).  

**child**: A node directly stemming from another node in a tree. 

**parent**: A node sharing edges with a set of child nodes in a tree. 

**leaves**: Nodes with no child nodes. 

**siblings**: Nodes with the same parent node. 

**path**: A sequence of nodes connecting a node (N1) with another node in a tree. 

**length**: The number of edges between two nodes that have a path. 

**depth**: The length of unique path between the root and a given node in a tree.

**height**: The height of a node, called n, is the legnth between the longest path from n to a leaf. 

**ancestor**: If there is a path between a node n1 and another node n2, then n1 is an ancestor of n2. 

**descendant**: Following the definition of an ancestor, n2 would be the descendant of n1. 

## Traversal Methods ## 

### In-Order Traversal ### 
```Java
public void inOrderTraversal(Node n) {
      inOrderTraversal(n.left); 
      System.out.println(n.element); 
      inOrderTraversal(n.right); 
} 
```
### Pre-Order Traversal ### 
```Java
public void preOrderTraversal(Node n) {
      System.out.println(n.element); 
      preOrderTraversal(n.left); 
      preOrderTraversal(n.right); 
} 
```
### Post-Order Traversal ### 
```Java
public void postOrderTraversal(Node n) {
      postOrderTraversal(n.left);
      postOrderTraversal(n.right);
      System.out.println(n.element); 
} 
```

### Level-Order Traversal ###  
```Java
public void levelOrderTraversal() {
      Queue<Node> queue = new LinkedList<Node>();
      queue.add(root);
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
```
