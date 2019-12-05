package Suffix_Contruct;

import java.util.HashMap;
import java.util.Map;



public class Suffix_Contruct {
	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		
	}
	static class SuffixTrie {
		
		TrieNode root = new TrieNode();
		char endSymbol = '*';
		
		public SuffixTrie(String str) {
			populateStuffixTrieFrom(str);
		}
		public void populateStuffixTrieFrom(String str) {
			
			for (int i = 0; i<str.length(); i++) {
				
				insertSubstringStartingAt(i, str);
			}
		}
		
		public void insertSubstringStartingAt (int i, String str) {
			
			TrieNode node = root;
			for (int j = i; j < str.length(); j++) {
				
				char letter = str.charAt(j);
				if (!node.children.containsKey(letter)) {
					
					TrieNode newNode = new TrieNode();
					node.children.put(letter, newNode);
				}
				node = node.children.get(letter);
			}
			node.children.put(endSymbol, null);
		}
		
		public boolean contrains(String str) {
			
			TrieNode node=  root;
			for (int i = 0; i < str.length(); i++) {
				
				char letter = str.charAt(i);
				if (!node.children.containsKey(letter)) {
					return false;
				}
				node= node.children.get(letter);
				
			}
			return node.children.containsKey(endSymbol) ? true : false;
		}
	}
}
