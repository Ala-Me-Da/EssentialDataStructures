# Hash Tables #
A hash table is an array data structure able to search, insert, and remove an item in average constant time using hashing. Hashing maps an item to an integer between ```0``` and ```TableSize - 1``` called a 'key'. The key is then used to access a cell in the table to store its item.

The mapping of an item to a key is called a *hash function*. Ideally, hash functions generate unique keys for every item. But, since there a finite amount cells, and a virtually infinite amount of keys, two keys can hash to the same value causing a *collision*.

The next sections detail important hash table implementations built-in with simple collision resolutions: Separate Chaining and Open Addresssing.  

## Separate Chaining ## 
Separate Chaining implements a hash table as an array of lists, where two keys that map to the same cell store their items into the list at that cell. 

## Open Addressing ## 
Open addressing implements a hash table as a standard resizable array, with special collision resolution functions of the form 
```h(x) = (hash(x) + f(i) mod TableSize```

### Linear Probing ### 

### Quadratic Probing ### 
### Double Hash Probing ### 

## Variations ## 

## Hash Map ## 

## Hash Set ## 

## Big - O Runtime ##

Assuming a good hash function that distributes keys among the buckets evenly, the runtimes for hash tables are listed below:

