#include <iostream> 

#include "singlyList.h" 
#include "singlyList.cpp" 

const int SIZE = 2; 

int main(int argc, char** argv) 
{
	List<int> * myList = new singlyList<int>(); 
	singlyList<int> * testList = new singlyList<int>(); 
	int * array = new int[SIZE]; 

	myList->insert(1);
	myList->insert(2); 
	myList->insert(3); 
	myList->insert(4); 
	myList->insert(5);

	// intializing testList 
	testList->insert(10); 
	testList->insert(20); 
	testList->insert(30); 

	// check if singlyList destuctor is working properly
	// finished a test:  Results in default core dump. 
	delete testList; 

	singlyList<int> * myList2 = dynamic_cast< singlyList<int>* >(myList); 	
	array = myList2->find(4); 
	std::cout << "position: " << array[0] << std::endl; 
	std::cout << "value:    " << array[1] << std::endl; 

	std::cout << "\n"; 

	myList->display();
	
	std::cout << "\n"; 

	myList->remove(5); 
	myList->remove(4); 
	
	myList->display(); 
	
	std::cout << "\n"; 
		
	myList->remove(2);
	
	myList->display(); 
	
	std::cout << "\n"; 

	myList->remove(1); 
	
	myList->display(); 	

	myList->remove(3); 

	myList->display();  	 
	
	delete myList;
	delete array;  

	return 0; 
} 
