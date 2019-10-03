@SuppressWarnings("unchecked")
class QuadraticHashTable<E> {
        private static final double REHASH_THRESHOLD = 0.50; // Results in only 2.5 PROBES during collisions on average.
        private static final int INIT_TABLE_SIZE = 11;
        private Object[] hashTable;
        private double loadFactor;
        private int tableSize;
        private double size;

        public QuadraticHashTable() {
            hashTable = new Object[INIT_TABLE_SIZE];
            tableSize = hashTable.length;
            size = 0;
        }

        public void insert(E item) {
            if(loadFactor >= REHASH_THRESHOLD)
                rehash();
            loadFactor = (++size) / (double)tableSize;
            int hashKey = hashcode(item);
            if(hashTable[hashKey] != null) {
                hashTable[collisionResolver(hashKey)] = item;
            } else {
                hashTable[hashKey] = item;
            }
        }

        public void remove(E item) {
            int hashKey = hashcode(item);
            while(hashTable[hashKey] != item ) {
                ++hashKey;
            }
            hashTable[hashKey] = null;
            loadFactor = (--size) / (double)(tableSize);
        }

        public boolean contains(E item) {
            int hashKey = hashcode(item);
            if(item.equals(hashTable[hashKey])) {
                return true;
            } else if(item.equals(hashTable[collisionResolver(hashKey)])) {
                return true;
            }
            return false;
        }

        private int hashcode(E item) {
            return hash(item.toString());
        }

        private int hash(String key) {
            int hash = 0;
            for(int i = 0; i < key.length(); i++) {
                hash += 37 * key.charAt(i);
            }
            hash = hash % tableSize;
            return hash;
        }

        /** Quadratic Probing sets collision resolver function f(i) = i^2 */
        private int collisionResolver(int i) {
            int probeIndex = (i + i*i) % tableSize;
            while(hashTable[probeIndex] != null) {
                probeIndex = (probeIndex != tableSize - 1) ? ++probeIndex : 0;
            }
            return probeIndex;
        }

        private void rehash() {
            Object[] newTable = new Object[nextPrime(tableSize)];
            Object[] tempTable = hashTable;
            hashTable = newTable;
            tableSize = newTable.length;

            // rehash all values in old hash table into new table
            for(int i = 0; i < tempTable.length; i++) {
                E item = (E) tempTable[i];
                if(item != null)
                    hashTable[hash(item.toString())] = item;
            }
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

        /**
         * Method to display the contents of the hash table
         */
        public void displayTable() {
            int count = 0;
            for(Object item : hashTable) {
                System.out.println("Count: " + count++ + " Item: " + item);
            }
        }
}
