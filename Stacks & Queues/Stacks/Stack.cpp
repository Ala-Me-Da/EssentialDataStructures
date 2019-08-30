#include "Stack.h" 
#include <iostream> 

template <class T> 
void Stack<T>::push(T item) 
{ 
	array[++index] = item; 
	++size; 
	if( size >= capacity ) 
		resize(); 
} 

template <class T> 
T Stack<T>::pop() 
{
	T poppedItem = array[index]; 	
	index--; 
	size--;	
	return poppedItem; 
}

template <class T> 
T Stack<T>::peek() 
{
	return array[index]; 

} 

/*
 *  Returns the 1-based position where an item is in this stack. 
 *  Returns -1 if no such item exists in the stack. 
 */ 
template <class T> 
int Stack<T>::search(T item) 
{
	int itemIndex, i; 
	for(i = 0; i < size && array[i] != item; ++i) {} 
	itemIndex = i + 1; 

	return (itemIndex == size + 1) ? -1 : itemIndex; 

} 


template <class T> 
void Stack<T>::display() 
{
	for(int i = 0; i < size; ++i) {
		std::cout << "The value at index: " << i << " is " << array[i] << std::endl;
	} 
} 

template <class T> 
void Stack<T>::resize() 
{
	T * newArray = new T[2*capacity];
	std::copy(array, array+size, newArray); 
	capacity = 2*capacity; 
	array = newArray;
} 
