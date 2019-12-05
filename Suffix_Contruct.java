package Suffix_Contruct;

import java.util.HashMap;
import java.util.Map;



public class Suffix_Contruct {
	static class TreeNode {
		Map<Character, TreeNode> children = new HashMap<Character, TreeNode>();
		
	}
	static class SuffixTrie {
		
		TreeNode root = new TreeNode();
		
		
		public SuffixTrie(String str) {
			populateStuffixTrieFrom(str);
		}
		public void populateStuffixTrieFrom(String str) {
			
			for (int i = 0; i < str.length(); i++) {
				
				insertSubstringStartingAt(i, str);
			}
		}
		
		public void insertSubstringStartingAt (int i, String str) {
			
			TreeNode node = root;
			for (int j = i; j < str.length(); j++) {
				
				char letter = str.charAt(j);
				if (!node.children.containsKey(letter)) {
					
					TreeNode newNode = new TreeNode();
					node.children.put(letter, newNode);
				}
				node = node.children.get(letter);
			}
			
		}
		
		public boolean contrains(String str) {
			
			TreeNode node=  root;
			for (int i = 0; i < str.length(); i++) {
				
				char letter = str.charAt(i);
				if (!node.children.containsKey(letter)) {
					return false;
				}
				node= node.children.get(letter);
				
			}
			return true;
		}
	}
}
