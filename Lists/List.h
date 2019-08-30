#ifndef LIST_H
#define LIST_H

template < class Object > 
class List {
	public:
	virtual ~List() {} 
	virtual void insert( const Object &obj ) = 0;  
	virtual void remove( Object obj ) = 0; 
	virtual void display() = 0; 
}; 

#endif 
