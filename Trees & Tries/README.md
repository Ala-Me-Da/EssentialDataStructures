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

### Level-Order Traversal ###  


