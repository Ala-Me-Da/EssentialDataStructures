import java.util.List; 
import java.util.ArrayList;

/**
 *  Implemenation of a Hash Table with a Separate Chaining collision resolution scheme
 *  Keys are assumed to be Strings for the time being.
 * @param <E> a generic class so that a value of any type can be stored into the Hash Table
 */

@SuppressWarnings("Unchecked") 
class SeparateChainingHashTable<E> {
	private static final int CAPACITY = 101;
	private ArrayList<E>[] hashTable;

	/** Intialize the hash table */
	public SeparateChainingHashTable() {
		hashTable = new ArrayList[CAPACITY];
		for(int i = 0; i < hashTable.length; i++) {
			hashTable[i] = new ArrayList<E>();
		}
 
	}


	public void insert(String key, E item) {
		hashTable[hashcode(key)].add(item);
	} 

	public void remove(String key, E item) {
		hashTable[hashcode(key)].remove(item);
	} 

	public E search(String key, E item) {
		List<E> bucket = new ArrayList<E>();
		bucket = hashTable[hashcode(key)];
		for(E i : bucket) {
			if(i.equals(item))
				return i;
		}
		return null; 
	}
	
	/** Good hashcode method that gives a better distribution of keys among the buckets / lists */ 
	private int hashcode(String key) {
		int hash = 0, tableSize = hashTable.length;
		for(int i = 0; i < key.length(); i++) {
			hash += 37 * key.charAt(i);
		}
		return hash % tableSize;
	}
} 
