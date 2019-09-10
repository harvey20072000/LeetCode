package ga.workshop.com.LeetCode.prac20181016;

import java.util.LinkedList;
import java.util.List;

public class Trie {
	private List<String> list;
	
	/** Initialize your data structure here. */
    public Trie() {
        this.list = new LinkedList<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        this.list.add(0, word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return this.list.contains(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        boolean result = false;
        for(String s : this.list) {
        	if(s.startsWith(prefix)) {
        		result = true;
        		break;
        	}
        }
        return result;
    }
}
