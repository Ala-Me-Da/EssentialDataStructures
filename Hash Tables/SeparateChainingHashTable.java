import java.util.List; 
import java.util.ArrayList;

/**
 *  Implementation of a Hash Table with a Separate Chaining collision resolution scheme
 *  All generic classes E are assumed to have overriden their toString() methods.
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

	/** Pass in a user specificed capacity for hash table
	 * @param intialCapacity - Users capacity to set for the hash table.
	 */
	public SeparateChainingHashTable(int intialCapacity) {
		// nextPrime() method to ensure hashes divisible by tableSize rarely occurs.
		hashTable = new ArrayList[nextPrime(intialCapacity)];
		for(int i = 0; i < hashTable.length; i++) {
			hashTable[i] = new ArrayList<E>();
		}
	}

	public void insert(E item) {
		hashTable[hash(item)].add(item);
	} 

	public void remove(E item) {
		hashTable[hash(item)].remove(item);
	} 

	public E search(E item) {
		List<E> bucket = new ArrayList<E>();
		bucket = hashTable[hash(item)];
		for(E i : bucket) {
			if(i.equals(item))
				return i;
		}
		return null; 
	}

	private int hash(E item) {
		return hashcode(item.toString());
	}
	
	/** Good hashcode method that gives a better distribution of keys among the buckets / lists */ 
	private int hashcode(String key) {
		int hash = 0, tableSize = hashTable.length;
		for(int i = 0; i < key.length(); i++) {
			hash += 37 * key.charAt(i);
		}
		return hash % tableSize;
	}

	/** Uses the Bertrand–Chebyshev theorem to find the next prime.
	 *  Theorem in a nutshell: Given an integer n , there must be a prime p such
	 *  that n < p < 2n . So this method loops from n + 1 to 2n - 1 until a prime is found.
	 */
	private int nextPrime(int currentPrime) {
		boolean primeFound = false;
		int i;
		for(i = currentPrime + 1; i < 2 * currentPrime; i++) {
			if(isPrime(i)) {
				primeFound = true;
				break;
			}
		}
		return (primeFound) ? i : 2 * tableSize;
	}

	/**
	 *  Basic Primality test. If value is not divisble
	 *  by any of the values between 2 and value - 1
	 *  then the value is prime.
	 * @param value integer to be tested for primality.
	 * @return indication that value is prime or not.
	 */
	private boolean isPrime(int value) {
		for(int i = 2; i < value; i++) {
			if(value % i == 0)
				return false;
		}
		return true;
	}
} 
