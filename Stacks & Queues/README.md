### Stacks & Queues ### 

Stacks and Queues are dynamic sets with special remove operations. For Stacks, the structure follows a Last In, First Out policy (LIFO) whereby the most recent element inserted is the first to go. For Queues, the structure follows a First In, First Out policy (FIFO) whereby the oldest element inserted is the first element to go. 

Stacks perform insertions (push) and deletions (pop) in only one position, the top of the stack. 
Queues perform insertions (enqueues) and deletions (dequeues) 

## Big-O Runtime ##
Assuming a Stack / Queue with N elements, the runtimes are as follows: 


|Big - O  | Insert    | Remove | Find | 
|---------| --------  | ------ | -----|
| Worst   |  O(1)     |  O(1)  | O(N) |
| Average |  O(1)     |  O(1)  | O(N) | 
