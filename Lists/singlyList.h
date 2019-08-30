#ifndef H_SINGLYLIST
#define H_SINGLYLIST 

#include <cstdlib> 
#include "List.h" 

template < class Object > 
class singlyList : public List< Object >  {

	struct Node {
		Object val;
		int position;  
		Node * next; 
		Node( Object obj ) : val(obj), next(NULL) {} 	
	}; 
 
	Node * head;
	Node * tail; 
	int currPos; 
	
	public:	
	singlyList() : head(NULL), tail(head) {}
	~singlyList();  
	 void insert( const Object &obj );
	 void remove( Object obj );
	 void display(); 
	 int * find( const Object &obj ); 

};

#endif

