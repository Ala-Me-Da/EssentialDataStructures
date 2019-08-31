# Binary Heaps #

Binary Heaps (a type of Priority Queue) are complete binary trees maintaining a heap-order property. 

There are two main heap-order properties: 
..* Parent node value <  Child node value (Minimum Heap) 
..* Parent node value >  Child node value (Maximum Heap). 

Binary Heaps store minimum or maximum values in the root of the tree, i.e. the first element in a array. Binary Heaps often follow the array Binary Tree scheme, with the following rules for parent, left child, and right child nodes for an array called "heap" with index i : 

 ..* Parent Node: heap[(i - 1) / 2] 
 ..* Left Child Node: heap[2*i - 1] 
 ..* RIght Child: heap[2*i - 2]

## Big - O Runtimes ## 
Assuming the Heap is of size N, the runtimes are as follows: 

|Big - O  | Insert    | Remove     | Find Min / Max| Find |
|---------| --------  | ------     | --------------| -----|
| Worst   |  O(log N) |  O(log N)  | O(1)          | O(N) |
| Average |  O(1)     |  O(log N)  | O(1)          | O(N) |
