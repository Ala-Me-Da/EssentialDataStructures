# Graph # 


## Terminology ## 
**Graph**: A data structure consisting of a set of vertices (V) and edges (E). 

**Vertex**: A vertex, or node, is an object holding information in the graph. 

**Edge**: An edge is an object signalling a connection between two vertices. 

**Weight**: A weight (or cost) is an optional third property of a graph that assigns a value to edges. (such as a road's distance between cities.) Weights may apply to vertices as well. 

**Directed Graph**: Directed graphs, or digraphs, are graphs where edges have direction towards a vertex. 

**Path**: A sequence of vertices connected by edges. 

**Length**: The number of edges on a path. 

**Cycle**: A path of at least length = 1 such that the starting vertex is the ending vertex. 

**Acyclic**: A graph with no cycles. 

**DAG** Standing for "Directed Acyclic Graph* is a digraph with no cycles. 

**Connected**: A undirected graph is connected if there is a path from every vertex to every other vertex. A digraph with this 
property is called strongly connected. Conversely, a weakly connected graph is a non-strongly connected digraph with it's
underlying un-directed graph being connected. 

**Complete**: A graph where an edge exists between every pair of vertices. 

**Dense**: Graph where E = O(V^2), i.e. number of edges is approximately equal to the number of vertices squared. 

**Sparse**: Graph where there a small amount of edges relative to vertices. 

**Adjacency List**: A list containing all adjacent vertices for each vertex. Best used when a graph is **Sparse**.  
**Adjacency Matrix** A matrix (2D-array, table, etc) containing 
**Incident Matrix**: Typically, A boolean matrix (2-D array) whose rows and columns are the vertices of a graph, and whose 
entries are true or false depending on if the entry's vertices are connected with an edge.   


## Big-O Runtimes ## 
For an adjacency list. V = total number of vertices in graph, E = total number of edges in graph. 

|Big - O  | Insert Vertex or Edge   | Remove Vertex | Remove Edge | Adjacency | 
|---------| ------------------------| ------------- | ------------| ----------| 
| Worst   |  O(1)                   |  O(V)         | O(E)        | O(V)      | 
 
