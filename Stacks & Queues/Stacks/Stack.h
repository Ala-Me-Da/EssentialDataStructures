#ifndef STACK_H 
#define STACK_H 

template <class T> 
class Stack {
	T * array; 
	int capacity; 
	int index; 
	int size; 
	
	public: 
	  Stack() : array(new T[20]), capacity(20), index(-1), size(0) {} 
	  ~Stack() { delete [] array; }
	  void display();  
	  void push(T item); 
	  T    pop(); 
	  T    peek();
	  int  search(T item); 
	   
 
	private: 
	  void resize(); 
}; 


#endif //STACK_H
