import java.util.HashMap; 

public class TrieNode {
	private String letter;  
	private HashMap<String, TrieNode> children; 

	public TrieNode(String l) {
		letter = l; 
		children = new HashMap<String, TrieNode>(); 
	} 

	public void putChild(TrieNode child) {
		children.put(child.letter, child);
	}
	
	public TrieNode getChild(String key) {
		return children.get(key); 
	} 

	public boolean childHasKey(String letter) { return children.containsKey(letter); }

	public String getLetter() { return letter; }
} 
