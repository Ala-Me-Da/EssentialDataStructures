#include <cstdlib> 
#include <iostream>
 
#include "singlyList.h"

/*
 *  O(1) time for insert() 
 */ 
template < class Object > 
void singlyList<Object>::insert( const Object &obj )
{
	Node * newNode = new Node( obj ); 
	if( head == NULL ) {
		head = newNode; 
		tail = newNode; 
	} else { 
	  	tail->next = newNode; 
	  	tail = newNode; 
	} 
	++currPos; 
	newNode->position = currPos; 

} //singlyList< Object >::insert() 

/* 
 * 	iter = node to delete. 
 * 	prev = node before iter. 
 *  O(n) time for remove()
 */ 
template < class Object > 
void singlyList<Object>::remove( Object obj ) 
{
	Node * prev = head;  
	Node * iter = head; 
	while( iter && iter->val != obj ) {
		prev = iter; 
		iter = iter->next; 
	} 
  
	prev->next = iter->next;  

	if ( iter == head && !head->next ) {
		 head = NULL; 
		 return; 
	}  else if ( iter == head ) {
		head = head->next;  
	}

	delete iter; 
} // singlyList< Object >::remove() 

template < class Object > 
void singlyList<Object>::display() 
{
	Node * iter = head;

	if( !head ) { 
		std::cout << "\nThe list is empty.\n"; 
		return; 
	}

	while( iter ) {
		std::cout << iter->val << std::endl; 
		iter = iter->next;
	} 


} // singlyList< Object >::display()

template < class Object > 
int * singlyList<Object>::find( const Object &obj ) 
{
	Node * iter = head; 
	int * positionAndValue = new int[2];   
	int * temp; 
	while( iter && iter->val != obj ) { 
		iter = iter->next; 
	}

	positionAndValue[0] = iter->position; 
	positionAndValue[1] = iter->val;
	temp = positionAndValue; 
	return temp; 
} //singlyList< Object >::find()

template < class Object >
singlyList<Object>::~singlyList<Object>() 
{
	Node * iter = head; 
	while( iter ) { 
		delete iter;
		iter = iter->next; 
	} 
}

//template class singlyList<int>; 