#include <iostream> 
#include "Stack.h" 
#include "Stack.cpp" 

int main(int argc, char **argv) 
{
	Stack<int> * stack = new Stack<int>(); 

	for(int i = 0; i < 25; ++i) {
		stack->push(i); 
	} 
	stack->display(); 
	
	for(int i = 0; i < 15; ++i) {
		stack->pop(); 
	} 	
	stack->display(); 

	std::cout << "\nValue returned by peek(): " << stack->peek() << std::endl; 
	std::cout << "Popping a value...\n"; 
	stack->pop(); 
	std::cout << "Value returned by peek() after pop (should be 8): " << stack->peek() << std::endl; 
	std::cout << "Search for the index containing number 4 in our stack. (Should return 5, using a 1-based positioning policy): " << stack->search(4) << std::endl;  	
	std::cout << "Now search for an item that isn't in the stack. Searching for 99... (should return -1): " << stack->search(99) << std::endl; 
	
	return 0; 
} 
