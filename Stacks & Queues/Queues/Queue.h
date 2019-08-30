#ifndef H_QUEUE
#define H_QUEUE

template < typename T > 
class Queue {
    static const int initialCapacity = 10; 
    T * array;
    int capacity;  
    int index; 
    int size; 
    T   head; 
    T   tail; 

    public: 
    Queue() : array(new T[initialCapacity]), capacity(initialCapacity), size(0), index(0) {} 
    ~Queue() { delete [] array; } 

    void enqueue(T item); 
    T    dequeue(); 
    bool isEmpty(); 
    T    peek(); 
    T    peekTail(); 
    int  search(T item); 
    void display(); 

    private: 
    void resize(); 
};

#endif //Queue.h 
