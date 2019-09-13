class Vector<E> {
	private static final int INITIAL_CAPACITY = 16; 
	private int capacity = INITIAL_CAPACITY; 
	private int size = 0; 
	private Object[] array;  

	public Vector() {
		array = new Object[capacity]; 
	}

	/**
	 *  Vector constructor to allow set specific capacities.
	 * @param customCap - New capacity the user sets for the Vector.
	 */
	public Vector(int customCap) {
		array = new Object[customCap];  
		capacity = customCap; 
	}

	/**
	 *  Essential vector method push() to insert values into the vector's internal array.
	 * @param item - Value to insert into vector.
	 */
	public void push(E item) {
		if(size >= capacity) 
			resize(); 

		array[size++] = item; 
	}

	/**
	 * Essential vector method pop() to remove values from
	 * the vector and return
	 * A SuppressWarnings annotation for the unchecked typing warning,
	 * as convertion to the generic type is necessary to
	 * return proper output
	 * @return
	 */
	@SuppressWarnings("unchecked") 
	public E pop() {
		if(size <= 0 ) {
			System.err.println("Vector is empty"); 
			return null; 
		} 

		return (E) array[size--]; 
	}

	/**
	 * Display all items in the vector.
	 */
	public void displayContents() {
		for(int i = 0; i < size; i++) {
			System.out.println(array[i]); 
		}  
	
	}

	/**
	 *  Size getter method
	 * @return Returns the size of the vector (number of items in it)
	 */
	public int size() { return size; }

	/**
	 * Capacity getter method
	 * @return Returns the capacity of the vector (maximum amount of items allowed)
	 */
	public int capacity() { return capacity; }

	/**
	 * Reisze helper method for when the vector reaches maximum capacity
	 */
	private void resize() {
		Object[] newArray = new Object[2*capacity]; 
		System.arraycopy(array, 0, newArray, 0, capacity); 
		array = newArray; 
		capacity = 2*capacity; 
	}

	/**
	 * Mandatory main method to compile the Vector class. Used primarily for unit testing.
	 * @param args - Command line input. Not used here.
	 */
	public static void main(String[] args) {
		/** Creating the Vector objects */
		Vector<Integer> vector = new Vector<Integer>(); 
		Vector<String> vector2 = new Vector<String>(1024); 
		
		/** Unit Testing on capacity  method */ 
		System.out.println("Capacity of vector upon creation: " +
					vector.capacity()); 
		System.out.println("Capacity of vector2 upon creation: " + 
					vector2.capacity()); 
			
		/** Unit Testing on push method */ 
	  	for(int i = 0; i < 50; i++) {
			vector.push(i); 
		} 

		for(char c = 'A'; c <= 'Z'; c++) {
			vector2.push(c + "" + c); 
		} 

		vector.displayContents(); 
		vector2.displayContents(); 

		

		/** Unit Testing on pop method */ 
		for(int i = 0; i < 25; i++) {
			System.out.println("From vector, pop returned: " +
						vector.pop()); 
		} 

		for(char c = 'A'; c <= 'J'; c++) {
			System.out.println("From vector2, pop returned: " + 
						vector2.pop());  
		}  

		/**Unit testing on size */ 
		System.out.println("Size before: " + vector.size());
		System.out.println("Size before (2): "  + vector2.size());  
		System.out.println(""); 

		vector.pop(); 
		vector2.pop(); 

		System.out.println("Size after: " + vector.size()); 
		System.out.println("Szie after (2): " + vector2.size()); 
		System.out.println(""); 
	} 

	
} 
