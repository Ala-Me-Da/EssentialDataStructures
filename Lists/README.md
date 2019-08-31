# Linked Lists #

A Linked List is a sequence of Node objects (not necessarily adjacent in memory), with each Node containing an element, and 
a reference to the next node in the list. Node objects differ depending on the way a linked list is implemented, e.g., a Doubly 
Linked List's nodes would contain a reference the next node and the previous node.

A head node marks the start of a list, and a tail mark the end of the list. 


## Big - O Runtimes ## 
Assuming the List is of size N, inserts occur at the tail, removes are given the Node marked for deletion, the runtimes for each List operation is as
follows: 

|Big - O  | Insert    | Remove | Find | 
|---------| --------  | ------ | -----|
| Worst   |  O(1)     |  O(1)  | O(N) |
| Average |  O(1)     |  O(1)  | O(N/2) = O(N) | 
