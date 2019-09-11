# Tries # 

A Trie (or radix tree, or prefix tree) is a n-ary tree, a tree where each parent node can have up to n children, with 
characters are stored at each noe. Each path from the root represents a word. A child node with the null node * in a trie signals a complete word. 

## TrieNode Implementation ## 

```java 
class TrieNode {
     String character; 
     HashMap<String, TrieNode> children; 
  // Optional set useful getter / setter methods 
} 
```
## Big - O Runtime Analysis ## 
Let K be the length of a word / string. 

|Big - O  | Insert    |  Prefix Lookup   | 
|---------| --------  | ---------------- |
| Worst   |  O(K)     |   O(K)           |

Note that these runtimes are the same as a Hash Table's lookup  ( O(1) ) as the strings are small and quickly processed, giving essentially constant time. A trie outranks a hash table in this case, as a trie can quickly lookup a prefix of a valid word whereas a hash can only lookup a valid word in its entirety.  



