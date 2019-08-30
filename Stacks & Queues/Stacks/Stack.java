class Stack<E> {
	private static final int initialCapacity = 20; 
	private int capacity; 
	private int size;
	private int min; 
	private int max;  
	private Object[] array; 

	/* 
	 * Resize method for when array size
	 * outgrows capacity. 
	 */ 
	 private void resize() {
		// Use System's arraycopy function 
		// ...Find out if that cause any 
		// portability issues (is it native code?) 
	 } 

	/* 
	 * Intialize internal stack array 
	 */ 
	public Stack() {
		size = min = max = 0; 
		capacity = initialCapacity; 
		array = new Object[initialCapacity]; 
	} 

	/*  
	 * Insert object into list. 
	 */ 	 
	public void push(E e) {
		if( capacity >= size ) {	
			resize(); 
		}
		
		array[size++] = e;   
	}

	/* 
	 * Implements a Stack's LIFO rule. 
	 * Returns null if stack is empty. 
	 */ 
	@SuppressWarnings("unchecked") 
	public E pop() {
		return isEmpty() ? null :  (E)array[size--]; 
	}  

	/* 
 	 * Determines if stack is empty. 
	 */ 
	public boolean isEmpty() {
		return size == 0; 
	}

	/* 
	 * Returs mininum value.s 
	 * only works with numbers at the moment. 
	 */ 
	public int minimum() {
		return min; 
	} 

	@SuppressWarnings("unchecked") 
	public E peek() { 
		return (E)array[size]; 
	} 

	public int search(Object o ) {
		int i = 0; 
		for( ; i < size && !(o.equals(array[i])); ++i) {} 
		return i + 1; 
	}  
	
	/* 
	 * Displays stack contents until empty 
	 */ 
	public void display() {
		if( isEmpty() ) {
			System.out.println("The stack is empty."); 
			return; 
		} 

		for(int i = 0; i < size; ++i) {
			System.out.println("Value at index " + i + " is " + array[i]); 
		} 
	} 

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>(); 
		stack.push("Carrot"); 
		stack.push("has"); 
		stack.push("sexy");
		stack.push("curves"); 
		stack.display(); 
		
		int index = stack.search("Carrot"); 
		System.out.println("The String object Carrot is found at index: " + index); 
		System.out.println("The String object sexy is found at index:  " + stack.search("sexy")); 
		System.out.println(""); 

		stack.pop(); 
		stack.pop();
		stack.pop(); 
		stack.pop();  
		stack.display(); 
	} 
}
