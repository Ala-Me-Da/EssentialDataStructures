# Hash Tables #
A hash table is an array data structure able to search, insert, and remove an item in average constant time using hashing. Hashing maps an item to an integer between ```0``` and ```TableSize - 1``` called a 'key'. The key is then used to access a cell in the table to store its item.

The mapping of an item to a key is called a *hash function*. Ideally, hash functions generate unique keys for every item. But, since there a finite amount cells, and a virtually infinite amount of keys, two keys can hash to the same value causing a *collision*. 

To aid in avoiding collisions, choosing a the ```TableSize``` to be prime prevents the hash function (using modulus table size to ensure hash never gets larger than the table) from hashing to the same cell more often.  

The next sections detail important hash table implementations built-in with simple collision resolutions: Separate Chaining and Open Addresssing.  

## Separate Chaining ## 
Separate Chaining implements a hash table as an array of lists, where two keys that map to the same cell store their items into the list at that cell.

*Pros:* Simple implementation, quick collision resolution, rehashing not necessary
*Cons:* Space inefficient, Slower (due to Linked List allocation), ``` O(n) ```  runtime if a cell's list is  ``` O(n) ```

## Open Addressing ## 
Open addressing implements a hash table as a standard resizable array, with special collision resolution functions of the form 
```h(x) = (hash(x) + f(i)) mod TableSize, f(0) = 0``` where ```f(i)``` is the collision resolution strategy. These functions *proboe*, or try alternative cells until an empty cell is found. When the table gets full, rehashing occurs. During rehashing all the old items are re-inserted into the new larger table with new hashes generated. Rehashing is performed when the *load factor*, i.e. number of items  / table size, is exceeded. Generally, it is a good idea to set the load factor = 1/2. There are 3 common collision resolutions stratigies for probing hash tables: Linear, Quadratic, and Double Hash probing. 

### Linear Probing ### 
Linear probing sets its collision resolution strategy ```f(i) = i```, so when a collision occurs, a linear probing hash table sequentially (with wraparound) searches for an empty cell for insertion. 

*Pro:* Simple to implement, optimal for when number / frequency of keys is known
*Cons:* requires expensive rehashing when load factor exceeded, Primary clustering*, more computation

* = When a hash table is large and empty, the table forms clusters as more items are inserted which slows performance.
### Quadratic Probing ### 
Quadratic probing sets its collision resolution strategy ```f(i) = i*i```, so when a collision occurs, quadratic probing searches for an empty cell at a distance ```i*i``` away for insertion. Fixes issue of primary clustering in linear probing. 

If quadratic probing is used with a prime number table size and a load factor = 1/2, a new item can always be inserted.  

*Pro:* Also simple to implement, optimal for when number / frequency of keys is known
*Cons:* load factor must be 1/2 to avoid excessive probing, requires expensive rehashing when load factor exceeded, Secondary clustering*

* = Items that collide at the same position also probe to the same alternative cells. Generates less than 1/2 a probe per search. 

### Double Hash Probing ### 
Double hash probing, as the name suggests, uses a second hash function in its collision resolution strategy ```f(i) = i*hash2(i)```. When a collision occurs, double hash probing searches for an empty cell at a distance ```i*hash2(i)``` away for insertion. This method fixes the issue of secondary clustering in quadratic probing, but at the cost of computing a second hash fuction.  

*Pro:* Also simple to implement, optimal for when number / frequency of keys is known, eliminates clustering 
*Cons:* load factor must be 1/2 to avoid excessive probing, requires expensive rehashing when load factor exceeded, second hash is more expensive computationally


## Big - O Runtime ##

Assuming a good hash function that distributes keys among the buckets evenly, and a table size of N, the runtimes for hash tables are listed below:

|Big - O  | Insert    | Remove | Find | 
|---------| --------  | ------ | -----|
| Worst   |  ```O(N)```     |  ```O(N)``` | ```O(N)``` |
| Average |  ```O(1)```     |  ```O(1)```  | ```O(1)``` | 
