#include <cstdlib>
#include <iostream> 
#include "doublyList.h" 

// the insert() method is not assigning the prev member variables properly.
// Leading to the undefined behavior when calling remove()  
template < class Object > 
void doublyList< Object >::insert( const Object &obj ) 
{
    Node * newNode = new Node( obj );
    newNode->prev = prevNode; 
    if( !head ) {
        head = newNode; 
        tail = newNode; 
        prevNode = newNode; 
    } else { 
        tail->next = newNode;  
        tail = newNode; 
    }
    ++currPos; 
    prevNode = newNode; 
    newNode->position = currPos; 
} //doublyList< Object >::insert()

template < class Object > 
void doublyList< Object >::remove( Object obj ) 
{
    Node * iter = head; 
    while( iter && iter->val != obj ) {
            iter = iter->next; 
    }

    if( iter == head ) head = NULL;
    
    iter->prev->next = iter->next; 
    iter->next->prev = iter->prev; 
    delete iter; 
} // doublyList< Object >::remove()

template < class Object > 
void doublyList< Object >::display() 
{
    Node * iter = head; 
    while( iter ) {
        std::cout << iter->val << std::endl; 
        iter = iter->next;
    }
} // doublyList< Object >::display()

template < class Object >
void doublyList< Object >::reverseDisplay() 
{
    Node * iter = tail; 
    while( iter ) {
        std::cout << iter->val << std::endl; 
        iter = iter->prev; 
    }
} // doublyList< Object >::display() 

template < class Object > 
int * doublyList< Object >::find( const Object &obj ) 
{
    Node * iter = head; 
    int * array = new int[2]; 

    while( iter && iter->val != obj ) {
            iter = iter->next; 
    }

    array[0] = iter->position; 
    array[1] = iter->val; 
    return array; 
} // doublyList< Object >::find() 

template< class Object > 
doublyList< Object >::~doublyList< Object >() 
{  
    Node * iter = head; 
	while( iter ) {
        delete iter; 
        iter = iter->next; 
    }
} // doublyList< Object >~doublyList< Object >() 
