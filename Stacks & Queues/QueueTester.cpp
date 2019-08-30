#include <iostream>
#include "Queue.cpp"

int main() 
{
    Queue<long int> * queue = new Queue<long int>(); 
    
    long int previous = 1; 
    for(int i = 1; i < 20; ++i) {
            queue->enqueue(i*previous);
            previous = i*previous; 
    } 
    queue->display(); 

    std::cout << "Use peekTail() function to see queue's tail: " << queue->peekTail() << std::endl; 
    std::cout << "Search for the index of 4! = 24  in our factorial queue: " << queue->search(24) << std::endl;
    std::cout << "Search for an item not in the queue: " << queue->search(5) << std::endl; 
    
 
    std::cout << "Dequeue the entire queue...\n"; 
    for(int i = 0; i < 20; ++i) {
	 std::cout << queue->peek() << std::endl; 
	 queue->dequeue(); 	
    }
    queue->display(); 
         
    return 0; 
}
