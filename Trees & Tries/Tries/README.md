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
