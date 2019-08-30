#include <iostream>
#include "Queue.h" 

/*
 * Insert an item into the Queue. 
 */
template <typename T> 
void Queue<T>::enqueue(T item)
{
    if(size >= capacity) {
        resize(); 
    } 

    array[size++] = item;
    tail = item; 

    if(size == 1) {
        head = array[0]; 
    } 
}

/* 
 * Deletes the oldest item from the queue. 
 */ 
template <typename T>
T Queue<T>::dequeue() 
{
    head = array[++index]; 
    --size; 
    return isEmpty() ? NULL : array[index - 1]; 

}

/*
 *  Determines if the queue is empty. 
 */ 
template <typename T>
bool Queue<T>::isEmpty()
{
    return size == 0; 
}

/* 
 * Displays the head of this queue. (doesn't remove head) 
 */ 
template <typename T>
T Queue<T>::peek() 
{
    return head; 
}

/* 
 * Displays the tail of this queue. (doesn't remove tail) 
 */ 
template <typename T>
T Queue<T>::peekTail() 
{
    return tail; 
}

/*
 *  Returns the 1-based position of the given item in this queue. 
 *  Returns -1 if item is not in queue. 
 */ 
template <typename T>
int Queue<T>::search(T item) 
{
    int i;
    for(i = 0; i < size && array[i] != item; ++i) {} 

    return (i == size) ? -1 : i + 1; 
}

/*
 * Displays all queue items. 
 */ 
template<typename T> 
void Queue<T>::display() 
{
    if(isEmpty()) {
        std::cout << "The queue is empty.\n"; 
    } else {
        for(int i = 0; i < size; ++i) {
            std::cout << "Value at index " << i << " is " << array[i] << std::endl; 
        }
    }
}

/*
 * Resizes Queue's array field when size outgrows capacity. 
 */
template<typename T> 
void Queue<T>::resize() 
{
    T * newArray = new T[2*capacity]; 
    std::copy(array, array + size, newArray);     
    capacity = 2*capacity; 
    array = newArray; 
}
