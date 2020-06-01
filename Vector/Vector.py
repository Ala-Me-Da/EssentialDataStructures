# Vector data structure in Python 3.6. Simulates Python's list / dynamic array object.
import ctypes 

class Vector(object): 

        def  __init__(self): 
              self.A = self._new_array(16) 
              self.size = 0 
              self.capacity = 16
                
        def append(self, item): 
              if(self.size >= self.capacity): 
                    self._resize() 

              self.A[self.size] = item 
              self.size += 1

        def remove(self): 
             if(self.size == 0): 
                 print("Vector is empty.") 
                 return 
            
             self.A[self.size] = 0 
             self.size -= 1

        def display(self): 
             for i in range(self.size): 
                print(self.A[i])

        def _resize(self):  
                temp = self._new_array(2 * self.capacity)
               
                for i in range(0, self.size):
                    temp[i] = self.A[i] 

                self.A = temp 

        def _new_array(self, new_cap): 
              self.capacity = new_cap 
              """ Returns an array of size new_cap ctype.python_object is a generic array type 
              """
              return (ctypes.py_object * new_cap)()


if __name__ == "__main__": 
    vect = Vector()
    for i in range(20): 
        vect.append(i)
    vect.display()
