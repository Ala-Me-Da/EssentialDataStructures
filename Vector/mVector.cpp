#include "mVector.hpp"
#include <iostream> 

void mVector::push(int item) {
	if(index <= currSize) 
		resize(*array);
	array[index++] = item; 	
} 	

void mVector::pop() {
	index--;
        currSize--; 	
} 

void mVector::print() {
	for(int i = 0; i < currSize; i++) 
		std::cout << array[i] << std::endl; 
} 

void mVector::resize(int &arr) {
	//memcopy(); 
} 


