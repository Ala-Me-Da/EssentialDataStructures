#include <iostream> 
#include "doublyList.h" 
#include "doublyList.cpp" 

using namespace std; 

int main( int argc, char** argv ) 
{
	doublyList<int> * dList = new doublyList<int>(); 
	int * array = new int[2];  

	dList->insert(1); 
	dList->insert(2); 
	dList->insert(3); 
	dList->insert(4); 
	dList->insert(5); 

	//dList->remove(4); 

	dList->display(); 
	dList->reverseDisplay(); 
		
	cout << "\n"; 

	array = dList->find(3);
	cout << "Position: " << array[0] << endl; 
	cout << "Value found: " << array[1] << endl; 
  	
	//delete dList; // Destructor deletes head, then causes a seg. fault by dereferencing freed memory. 
	delete array; 
 
	return 0; 
}
