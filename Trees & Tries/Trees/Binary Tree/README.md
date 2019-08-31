# Binary Tree #
A Binary Tree is a tree where a parent node holds at most 2 child nodes. A node in the Binary Tree structure consists of an element, a reference to a left child node, and a reference to a right child node. 

## Node Implementations ## 

Here a few ways to represent nodes in: Java, C++

Java: 
```Java 
public class Node {
    Object element; 
    Node leftChildNode; 
    Node rightChildNode; 
    
    public Node(Object elem) { 
          element = elm; 
          leftChildNode = null; 
          rightChildNode = null; 
    } 
} 
```
C++: 
```C++
template <typedef Object> 
struct Node {
     Object element; 
     Node * leftChildNode; 
     Node * rightChildNode; 
     Node(
}; 
```

## Big - O Runtimes ## 
Assuming the Binary Tree is of size N, the runtimes for each Binary Tree operation is as
follows: 

|Big - O  | Insert    | Remove | Find | 
|---------| --------  | ------ | -----|
| Worst   |  O(1)     |  O(N)  | O(N) |
| Average |  O(1)     |  O(N)  | O(N) | 

So, the Binary Tree offers approximatey the same runtime as using a regular old array object. 
