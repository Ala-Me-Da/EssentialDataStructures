import java.util.ArrayList;

public class Trie {
	private TrieNode root;

	/**
	 * Constructor intializing and pre-processing a Trie
	 * @param words - Strings to be inserted into the Trie.
	 */
	public Trie(String[] words) {
		String wordsReformatted = reformatInputStrings(words);
		root = new TrieNode("root");
		buildTrie(wordsReformatted);
	}

	/**
	 *  Main functionality of Trie: Quick look-up confirming a String or any of it's prefixes.
	 * @param prefix - Prefix to look-up in Trie
	 * @return Confirmation that prefix is in the Trie.
	 */
	public boolean contains(String prefix) {
		prefix = prefix.toUpperCase();

		String nullNode = "*";
		TrieNode currentNode = root;
		for(char c : prefix.toCharArray()) {
			String key = c + "";
			if(currentNode.childHasKey(key) && !key.equals(nullNode)) {
				currentNode = currentNode.getChild(key);
			} else {
				return false;
			}
		} 
		return true;
	}

	/**
	 * Insert extra words into the Trie.
	 * @param word - String representation to insert into Trie.
	 * Assumes word is a brand new word with no prefixes in the Trie. 
	 */
	public void insert(String word) {
		TrieNode currentNode = root;
		word = word.toUpperCase();
		for(char c : word.toCharArray()) {
			String key = c + "";
			if(currentNode.childHasKey(key)) {
				currentNode = currentNode.getChild(key);
			} else {
				TrieNode node = new TrieNode(key);
				currentNode.putChild(node);
				currentNode = currentNode.getChild(key);
			}
		}
	} 

	/**
	  * Helper string preprocessor to fit input better. 
	  * Runs in worst-case  O(n*k) time, n = words.length,
          * k = word.length (assuming same size for each word 
	  * in the worst case).
	  *
	  * @return The formatted String for the Trie. Repalces all extra characters and whitespace generated
	  * from ArrayList's toString() method.
	  * 
	  */
	private String reformatInputStrings(String[] words) {
		ArrayList<String> wordsReformatted = new ArrayList<String>();
		for (String word : words) {
			for (char letter : word.toCharArray()) {
				String l = letter + "";
				l = l.toUpperCase();
				wordsReformatted.add(l);
			}
			wordsReformatted.add("*");
		}

		return wordsReformatted.toString().
				replace("[", "").
				replace("]", "").
				replace(",", "").
				replace(" ", "");
	}

	/**
	 *  Intializes the Trie.
	 * @param words Reformatted strings stored as one string to be inserted into Trie.
	 */
	private void buildTrie(String words) {
		TrieNode currentNode = root; 
		for(char c : words.toCharArray()) { 
			String key = c + "";
			if(currentNode.childHasKey(key)) {
				currentNode = currentNode.getChild(key);  	
			} else if(key.equals("*")) {
				currentNode = root;
			} else {
				TrieNode node = new TrieNode(key);
				currentNode.putChild(node);
				currentNode = currentNode.getChild(key);
			}
		} 	
	}

	/**
	 * Manadatory main method. Use for some shallow unit-testing.
	 * @param args
	 */
	public static void main(String[] args) {
		String[] words = new String[]{"Molly", "is", "a", "Woman"}; 
		Trie trie = new Trie(words);

		/* These all should evaluate to TRUE */
		System.out.println("Is M prefix in the trie? " + trie.contains("M"));
		System.out.println("Is Mo prefix in the trie? " + trie.contains("Mo"));
		System.out.println("Is Mol prefix in the trie? " + trie.contains("Mol"));
		System.out.println("Is Moll prefix in the trie? " + trie.contains("Moll"));
		System.out.println("Is Molly in the trie? Answer: " + trie.contains("Molly"));

		System.out.println("Is I prefix in the trie?" + trie.contains("I"));
		System.out.println("is the word Is in the trie?" + trie.contains("Is"));

		System.out.println("W: " + trie.contains("W"));
		System.out.println("Wo: " + trie.contains("Wo"));
		System.out.println("Wom" + trie.contains("Wom"));
		System.out.println("Woma:" + trie.contains("Woma"));
		System.out.println("Woman: " + trie.contains("Woman"));

		trie.insert("Slaanesh");

		System.out.println("Is Slaa in the trie? " + trie.contains("Slaa"));
	}
} 
