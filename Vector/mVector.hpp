#ifndef H_MVECTOR
#define H_MVECTOR

class mVector {
	const int INIT_SIZE = 16;
        int currSize; 
	int index; 	
	int * array; 

	private: 
       		void resize(int &arr); 	
	
	public: 
		mVector() { 
			array = new int[INIT_SIZE];
			currSize = INIT_SIZE; 
			index = -1; 
	      	}
		void push(int item); 
		void pop(); 
		void print(); 
			
}; 
 
#endif //H_MVECTOR  
