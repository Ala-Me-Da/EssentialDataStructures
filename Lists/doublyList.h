#ifndef H_DOUBLYLIST
#define H_DOUBLYLIST

#include <cstdlib> 
#include "List.h"

template < class Object > 
class doublyList : public List< Object > {
	struct Node {
		int position; 
		Object val; 
		Node * next; 
		Node * prev;
		Node(Object obj) : val(obj), next(NULL), prev(NULL) {}   
	}; 

	Node * head; 
	Node * tail; 
	Node * prevNode; 
	int currPos; 
	
	public: 
	doublyList() : head(NULL), tail(head), prevNode(NULL), currPos(-1) {}
	~doublyList();   
	void insert( const Object &obj ); 
	void remove( Object obj ); 
	int * find( const Object &obj ); 
	void display(); 
	void reverseDisplay(); 
}; 

#endif //H_DOUBLYLIST
