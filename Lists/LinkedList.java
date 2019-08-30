import java.util.Collection; 
import java.util.Vector; 

public class LinkedList<E> {
	 private class Node {
	    Node next; 
	    Node prev; 
	    E element; 
	    int position; 
		
	    Node() { next = null;  prev = null; }  
	    Node(E e, Node n, Node p, int pos) {
	    	element = e; 
			next = n; 
			prev = p; 
			position = pos; 
	    } 
	}  

	private Node head; 
	private Node tail;  
	private int currPos; //current position field. Also functions as size indicator. 

	/*
	 *  Helper remove function. O(1) deletion
	 */ 
	private E remove(Node listNode) {
		 E removedElement;  
		 if(listNode == head)  {
               	        removedElement = head.element;
              	        Node newHead = head.next;
                        head.next.prev = null;
                        head = null;
                        head = newHead;
                } else if (listNode  == tail) {
                        removedElement = tail.element;
                        Node newTail = tail.prev;
                        tail.prev.next = null;
                        tail = null;
                        tail = newTail;
                } else {
                	removedElement = listNode.element;
               	    listNode.next.prev = listNode.prev;
               		listNode.prev.next = listNode.next;
               		listNode = null;  
		} 

		return removedElement; 	
	}  

	/* 
	 * Basic constructor to intialize an empty list. 
	 */ 
	public LinkedList() {
		head = tail = null; 
		currPos = 0; 
	}
 
	/* 
	 * Add a collection to this list upon construction 
	 */
	public LinkedList(Collection<? extends E> c) {
		 this(); 
		 addAll(c); 
	}
	
	/* 
	 * Appends the specified element to the end of this list.
	 * Big-O Analysis: O(1) time insertion.  
	 */ 
	public boolean add(E e) {
		Node newNode = new Node(e, null, tail, ++currPos);  
		if( head == null ) { 
		   head = newNode; 
		   tail = newNode; 
		} else { 
		   tail.next = newNode;  
		   tail = newNode; 
		} 
		return true;  
	} 
	

	/* 
	 *  Inserts the specified element at the specified position in 
	 *  this list.  
	 */ 
	public void add(int index, E e) {	
		Node iter = head; 
		while(iter != null && iter.position != index) { 
			iter = iter.next; 
		} 

		if(head == null || iter == tail) {
			add(e);
			tail.position = index + 1;
			return;  
		} else if(iter == null) { 
			System.out.println("No node with index " + index + " found.");
			return;  
		}
 
		// create new node, insert into index, update list 
		Node newNode = new Node(e, iter.next, iter, iter.position);
		iter.next.prev = newNode;
		iter.next = newNode; 
		
		iter = iter.next; 
		while(iter != null) { 
			++(iter.position);
			currPos = iter.position;  
			iter = iter.next; 		
		} 		
	}

	/* 
	 * Appends all elements in the specified collection to the end of this list, 
	 * in the order the order that they are returend by the collection's iterator. 
	 */
	@SuppressWarnings("unchecked")  	
	public boolean addAll(Collection<? extends E> c) {
		E[] items = (E[])c.toArray(); 
		for(int i = 0; i < c.size(); ++i) {
			this.add(items[i]);  
		} 
		return true; 
	}
	
	/* 
	 * Inserts all the elements in the specified collection into this 
	 * this list, starting at the specified position. 
	 */
	@SuppressWarnings("unchecked")  
	public boolean addAll(int index, Collection<? extends E> c) {
		E[] items = (E[])c.toArray(); 
		for(int i = 0; i < c.size(); ++i) {
			add(index + i, items[i]); 
		} 
		return true; 
	} 
	
	/* 
	 * Inserts the specified element into the beginning of this list  
	 */ 
	public void addFirst(E e) {
		Node newNode = new Node(e, head, null, head.position);
		
		if(head.next == null) {
			Node oldHead = new Node(head.element, null, null, head.position);
			
			head = newNode; 
			head.next = oldHead; 
			oldHead.prev = head;
			tail = oldHead; 
			
			++(oldHead.position); 
			++currPos; 
			return; 
		} else {
			head.next.prev = newNode;
			head = newNode; 
		}
		
		/*Update the indices for each list element  */
		Node iter = head.next; 
		while(iter != null) {
			++(iter.position); 
			currPos = iter.position; 
			iter = iter.next; 
			
		}  
	} 
	
	/* 
	 * Appends the specified element the end of this list. 
	 */ 
	public void addLast(E e) {
		add(e); 
	}  

	/* 
	 * Removes all items in the list 
	 */ 
	public void clear() { 
		Node iter = head; 
		while(iter != null) { 
			Node next = iter.next; 
			iter.next = null; 
			iter.prev = null; 
			iter.element = null; 
			iter.position = 0; 
			iter = next;  
		}
		head = tail = null; 
		currPos = 0; 
	} 

	/* 
	 * Returns a shallow copy of this list
	 */ 
	public Object clone() { 
		LinkedList<E> cloneList = new LinkedList<E>(); 
		cloneList.head = this.head; 
		cloneList.tail = this.tail;
		cloneList.currPos = this.currPos;  
		return cloneList;  
	} 

	/*
	 * Returns true if the specified element is in the list 
	 */  
	public boolean contains(Object o) {	
		return (indexOf(o) != -1) ? true : false; 
	} 
	
	/* 
	 * Retrieves, but does not remove, the head (1st element) of this list  
	 */ 
	public E element() { 
		return head.element; 
	}
 	
	/*
	 *  Returns the element at the specified position
	 */ 
	public E get(int index) { 
		Node iter = head; 
		while(iter != null && index != iter.position) { 
			iter = iter.next; 	
		} 

		return iter.element; 
	}  

	/*
	 *  Returns the first element of this list 
	 */ 	
	public E getFirst() { 
		return head.element; 
	} 
	
	/* 
	 * Returns the last element of this list
	 */ 
	public E getLast() { 
		return tail.element;  
	} 
	
	/*
	 *  Returns the index of the first occurance of the specified element, or 
	 *   -1 if the element is not in the list. 
	 */ 
	public int indexOf(Object o) {  
		Node iter = head;   
		while(iter != null && !(o.equals(iter.element))) {
			iter = iter.next; 
		} 
		return ( iter != null ) ? iter.position : -1; 
	} 
	
	/* 
  	 * Returns the index of the last occurrance of the specified element, or 
	 * -1 if the element is not in the list. 
 	 * i.e., a search for an instance of the specified object tail-first.  
	 */ 
	public int lastIndexOf(Object o) { 
		Node iter = tail; 
		while(iter != null && !(o.equals(iter.element))) { 
			iter = iter.prev; 
		} 
		return (iter != null) ? iter.position : -1; 
	} 
  
	/*
	 * Adds the specified element as the tail of this list. 
	 */ 
	public boolean offer(E e) {
		add(currPos, e); 
		return true; 
	} 

	/* 
	 *  adds specified elemnt to the front of the list 
 	 */ 
	public boolean offerFirst(E e) {
		System.out.println("In offerFirst()"); 
		addFirst(e); 		
		return true;  
	} 
	
	/* 
	 * Inserts the specified element at the end of this list. 
	 */
	public boolean offerLast(E e) {
		addLast(e); 
		return false; 
	} 
	
	/*
	 *  Retrives, but does not remove, the head of this list 
	 */
	public E peek() { 
		return head.element; 
	} 
	
	/*
	 * Retrieves, but does not remove, the first element of this list,
	 *  or returns null if this list is empty. 
	 */
	public E peekFirst() { 
		return (isEmpty()) ? null : head.element; 
	} 

	/*
	 * Retrives, but does not remove, the last element of this list, 
	 * 	or returns null if this list is empty. 
	 */
	public E peekLast() { 
		return (isEmpty()) ? null : tail.element; 
	} 

	/* 
	 * Retrieves and removes the first element of this list 
	 */
	public E poll() {
		return remove(); 
	} 
	
	/* 
	 * Retrieves and removes the first element of this list, 
	 *  or returns null if this list is empty. 
	 */
	public E pollFirst() {
		return (isEmpty()) ? null : remove(head); 
	} 

	/* 
	 * Retrieves and removes the last element of this list, 
	 *  or returns null if this list is empty. 
	 */
	public E pollLast() { 
		return (isEmpty()) ? null : remove(tail); 
	} 

	/*
	 * Pushes an element onto the stack represented by this list, 
	 * 	i.e., inserts the element at the front of this list.  
	 */
	 public void push(E e) {
		 addFirst(e); 
	 }
	 
	/* 
	 * Pops an element from the stack represented by this list. 
	 * 	i.e., removes and returns the last element(tail) of this list.
	 *  (Loosely following a LIFO deletion, pop last element inserted: 
	 *  the tail)   
	 */
	public E pop() {
		return remove(head); 
	} 	

	/* 
	 * Retrives and removes the head (first element) of this list  
	 */
	public E remove() {
		E removedElement = remove(head);
		
		Node iter = head; 
		while(iter != null) {
			--(iter.position); 
			iter = iter.next; 
		}  
		--currPos; 
		
		return removedElement; 
		
	} 
	
	/* 
	 * Remove an element at the specified index 
	 */ 
	public E remove(int index) { 
		//Find node with the specified index 
		Node iter = head; 
		while(iter != null && iter.position != index)  {
			iter = iter.next; 
		}  
	
		// Remove and return element from the node
		// get iter's next node as an iterator for position updating later 
		Node nextItr = iter.next; 
		E removedElement = remove(iter);
 
		// update list size (currPos), and positon fields of nodes 
		// that come after the found node  
		while(nextItr != null) {
			--(nextItr.position); 
			  nextItr = nextItr.next; 
		} 
		--currPos; 

		return removedElement; 
	} 

	/*
	 *  Retrieve and removes the head (first element) of this list. 
	 */
	public boolean remove(Object o) {
		Node iter = head; 
		while(iter != null && !(o.equals(iter.element))) {
			iter = iter.next; 
		} 
		remove(iter); 
		return true; 
	} 
	
	/* 
	 *  Removes the first occurence of the specified element in this 
	 *   list (when traversing the list head to tial). If the list 
	 *   doest not contain the element, it is unchanged. 
	 */
	public boolean removeFirstOccurrence(Object o) {
		Node iter = head; 
		while(iter != null && !((o.equals(iter.element)))) {
			iter = iter.next; 
		} 
		
		if(!(iter != null))
			return true; 
		
		
		Node nextItr = iter.next; 		
	        remove(iter); 
		
		while(nextItr != null) {
			--(nextItr.position); 
			nextItr = nextItr.next; 
		}
		--currPos; 
			
		return true; 
 
	} 

	/*
	 * Removes the last occurrence of the specified element in this
	 *  list (when traversing the list from head to tail.) If the list 
	 *  does not contain the element, the list is unchanged. 
	 */
	public boolean removeLastOccurrence(Object o) {
		Node iter = tail; 
		while(iter != null && !(o.equals(iter.element))) { 
			iter = iter.prev; 
		}
		
		if(!(iter != null)) 
			return true; 
		
		Node nextItr = iter.next; 
		remove(iter); 
		
		while(nextItr != null) {
			--(nextItr.position); 
			nextItr = nextItr.next; 
		} 
		--currPos; 
		
		return true;  
	} 
	
	/* 
	 * Replaces the element at the specified position with the given 
	 * 	element. (Optional operation)  
	 */ 
	public E set(int index, E element) { 
		Node iter = head; 
		while(iter != null && iter.position != index) { 
			iter = iter.next; 
		} 
		
		E replacedElement = iter.element; 
		iter.element = element; 
		return replacedElement; 
	} 

	/* 
	 * Returns size / number of elements in this list.
	 */ 
	public int size() {
		return currPos; 
	} 

	/* 
	 * Returns all of the elements in this list in proper sequence 
	 * (first to last element). Is a bridge between array-base 
	 *  and collection-based APIs. 
	 */
	public Object[] toArray() {
		Object[] array = new Object[currPos];
		Node iter = head;  
		for(int i = 0; i < currPos; ++i) {
			array[i] = iter.element; 
			iter = iter.next;  
		} 	
		return array;  
	} 
 
	/* 
	 * Returns a subset of this list within a specified range.
	 *  i.e., the elements with indexes in the range 
	 *  [fromIndex, toIndex]. 
	 */
	public LinkedList<E> subList(int fromIndex, int toIndex) {
		LinkedList<E> subList = new LinkedList<E>(); 
		
		Node iter = head; 
		while(iter != null && iter.position != fromIndex) {
			iter = iter.next; 
		} 

		Node iter2 = iter; 
		while(iter2 != null && iter2.position != toIndex) {
			subList.add(iter2.element); 
			iter2 = iter2.next;
		} 
		subList.add(iter2.element); 
		 
		return subList; 
	}  
	
	/*
	 * Determines if this list is empty. 
	 */
	public boolean isEmpty() {
		return head == null; 
	} 	
	
	/*
	 * Displays the contents of this list. If list is empty, the 
	 * method displays a message indicating so. 
	 */
	public void display() {
		Node iter = head;
		System.out.println(""); 
		while(iter != null) { 
			System.out.println("The value at index " + iter.position + " is: " + iter.element);
			iter = iter.next; 
		}
		
		if(isEmpty()) { 
			System.out.println("The List is empty."); 
		}  
	} 
	
	/* 
	 * Obligatory main method 
	 */
	public static void main(String[] args) {
		;
	}
} 
