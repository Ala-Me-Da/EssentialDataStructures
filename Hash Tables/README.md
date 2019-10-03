# Hash Tables #
A hash table is an array data structure able to search, insert, and remove an item in average constant time using hashing. Hashing generates an integer between ```0``` and ```TableSize - 1``` called a 'key' for the item. The key is used to store the item into an appropriate cell in the table. 

The mapping of an item to a key is called a *hash function*. Ideally, hash functions generate unique keys for every item. But, since there a finite amount cells, and virtually infinite amount of keys, two keys can hash to the same value causing a *collision*.

## Separate Chaining ## 

## Open Addressing ## 

### Linear Probing ### 

### Quadratic Probing ### 
### Double Hash Probing ### 

## Variations ## 

## Hash Map ## 

## Hash Set ## 

## Big - O Runtime ##

Assuming a good hash function that distributes keys among the buckets evenly, the runtimes for hash tables are listed below:

