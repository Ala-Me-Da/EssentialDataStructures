class Queue<E> {
	private final static int initialCapacity = 20;
	private Object[] array;  
	private int capacity; 
	private int index; 
	private int size; 
	private E   head; 
	private E   tail; 

	/*
	 * Resizes Queue's array field when size outgrows capacity. 
	 */
	private void resize() {
		Object[] newArray = new Object[2*capacity]; 
		System.arraycopy(array, 0, newArray, 0, size);
		capacity = 2*capacity; 
		array = newArray; 
	}
	
	/*
	 * Queue initialization 
	 */ 
	public Queue() {
		size = index = 0; 
		capacity = initialCapacity; 
		array = new Object[initialCapacity];
	} 

	
	/*
	 * Insert an item into the Queue. 
	 */
	@SuppressWarnings("unchecked")
	public void enqueue(E item) {
		if(size >= capacity) {
			resize(); 
		} 
		
		array[size++] = item;
		tail = item; 

		if(size == 1) {
			head = (E)array[0]; 
		}
	}
	
	/*
	 * Dequeues an item from this Queue. Returns null if empty.  
	 */
	@SuppressWarnings("unchecked")
	public E dequeue() {
		head = (E)array[++index]; 
		size--; 
		return isEmpty() ? null : (E)array[index - 1];
	}
	
	/* 
	 * Determines if this queue is empty. 
	 */
	public boolean isEmpty() {
		return size == 0; 
	}
	
	/*
	 * Returns head of this queue. 
	 */
	public E peek() {
		return head; 
	}
	
	/*
	 * Returns tail of this queue. 
	 */
	public E peekTail() {
		return tail; 
	}
	
	/* 
	 * Returns the 1-based position of the object in the queue. 
	 * Returns -1 if object not in queue. 
	 */
	public int search(Object o) {
		int i; 
		for(i = 0; i < size && !(o.equals(array[i])); ++i) {}
		return (i == size) ? -1 : i + 1;  
	}
	
	/*
	 * Displays contents of this queue. Returns separate msg if empty. 
	 */
	public void display() {
		if(isEmpty()) {
				System.out.println("This queue is empty."); 
		} else {
			for(int i = 0; i < size; ++i) {
				System.out.println("The Queue at index " + i + " is " + array[i]); 
			}
		}
		
	}
	
	/*
	 * main method to test Queue class methods. 
	 */
	public static void main(String[] args) { 
			Queue<Integer> queue = new Queue<Integer>(); 
			for(int i = 1; i <= 30; ++i) {
				queue.enqueue(i*i);
				System.out.println("head: " + queue.peek()); 
				System.out.println("tail: " + queue.peekTail()); 
			}
			queue.display(); 
			
			System.out.println("Search for 49 in queue of squares: " + queue.search(49)); 
			for(int i = 1; i <= 30; ++i) {
				queue.dequeue();
				System.out.println("head: " + queue.peek()); 
				System.out.println("tail: " + queue.peekTail()); 
			}
			queue.display(); 
			
			System.out.println("Search for integer not in queue (29): " + queue.search(29)); 
			
	}
} 
