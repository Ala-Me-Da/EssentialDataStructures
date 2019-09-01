# Trees # 

Trees (and Tries) are a collection of nodes with no cycles. Trees start with a root, and consist of subtrees stemming from that 
root. 

## Tree Terminology & Definitions ## 

**root**: 

**edge**: 
**child**: 
**parent**: 
**leaves**: 
**siblings**: 
**path**: 
**length**: 
**depth**: 
**height**: 
**ancestor**: 
**descendant**: 

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
