/**
  * Implementation of standard min heap, integers only for now.
  */
public class MinHeap {
	private int[] heap; 
	private int size; 
	private int capacity;
	private int index;  
	private static final int INIT_CAP = 16; 

	public MinHeap() { 
		heap = new int[INIT_CAP];
		index = 0;
		size = 0;
		capacity = INIT_CAP;
	}

	public void insert(int value) {
		if(size > capacity) {
			resize(); 
		}

		heap[index++] = value;
		size++;
		if(heap[(index - 1) / 2] > value)
			percolateUp();
	} 
	
	/** 
	  * Returns the minimum of the heap. 
	  */ 
	public int peek() {
		return heap[0]; 
	} 
 
	/** 
	 * Returns and removes the minimum of the heap.
	 */
	public int poll() {
		if(isEmpty()) {
			System.out.println("Heap is empty.");
			return -1;
		}

		int oldMinimum = peek();
		percolateDown();
		// index--;
		size--;

		return oldMinimum;
	}

	/**
	 *  Method to test if the heap is empty.
	 */
	private boolean isEmpty() {
		return size == 0;
	}

	/** 
	  * Essential Percolate Up (Or Bubble Up) method
	  * in order to maintain the heap order property
	  * after an insertion.
	  */ 
	private void percolateUp() {
		for(int i = index - 1; i > 0; i /= 2) {
			// heap[(i - 1) / 2] is the parent
			// heap[i] the child to be compared with parent.
			int parentIndex = (i - 1) / 2;
			int childIndex = i;
			if(heap[parentIndex] > heap[childIndex]) {
				heap[parentIndex] = swap(heap[childIndex], heap[childIndex] = heap[parentIndex]);
			}
		}
	}

	/**
	 * Essential Percolate Down (or Bubble Down) method
	 * in order to maintain the heap order property
	 * after deletion of the minimum (a.k.a, the poll method).
	 *  BUG FOUND: The last swap results in errors. Investigate this tommorrow.
	 */
	private void percolateDown() {
		int lastParentNode = (index - 1) / 2;
		// the integer iterator(s) i are parent nodes.
		int i;
		for(i = 0; i < lastParentNode; ) {
			if(heap[2*i + 1] < heap[2*i + 2]) {
				heap[i] = swap(heap[2*i + 1], heap[2*i + 1] = heap[i]);
				i = 2*i + 1;
			} else {
				heap[i] = swap(heap[2*i + 2], heap[2*i + 2] = heap[i]);
				i = 2*i + 2;
			}
		}

		heap[i] = swap(heap[index - 1], heap[index - 1] = heap[i]);
		index--;
		if(heap[i] < heap[(i - 1) / 2]) {
			heap[(i - 1) / 2] = swap(heap[i], heap[i] = heap[(i - 1) / 2]);
		}
	}

	/** 
	  *  Resize helper method for when
	  *  the array is full during an insertion.
	  */ 
	private void resize() {
		int[] newHeap = new int[2*capacity];
		System.arraycopy(heap, 0, newHeap, 0, heap.length);
		capacity = 2*capacity;
		heap = newHeap;
	} 

	/**
	  * Swap helper method
	  */ 
	private int swap(int a, int b){
		return a;
	}

	/**
	 * Print the contents of the heap out for debugging / testing purposes.
	 */
	private void printContents() {
		for(int i = 0; i < size; i++) {
			System.out.print(heap[i] + ", ");
		}

		System.out.println("also index: " + index +".");
	}

	public static void main(String[] args) {
		int[] testArray = new int[]{11, 9, 3, 2, 1, 20};
		MinHeap heap = new MinHeap();

		for(int i = 0; i < testArray.length; i++) {
			heap.insert(testArray[i]);
		}

		System.out.println("A peek at the minimum value (should be 1 for testArray): " + heap.peek());
		heap.printContents();

		heap.poll();

		System.out.println("A peek at the minimum value after a poll (should be 2 for testArray): " + heap.peek());
		heap.printContents();

		heap.insert(8);

		System.out.println("A peek at the minimum value after a poll followed by insertion." + heap.peek());
		heap.printContents();

		for(int i = 0; i < testArray.length; i++) {
			heap.poll();
			heap.printContents();
		}
	}
} 
