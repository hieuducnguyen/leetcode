/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

/**
 *
 * @author hieund3
 */
public class Trie {

	public Trie[] array;

	public Trie() {
		array = new Trie[27];
	}

	/**
	 * Inserts a word into the trie.
	 */
	public void insert(String word) {
		Trie node = this;
		for (int i = 0; i < word.length(); i++) {
			if (node.array[word.charAt(i) - 'a'] != null) {
				node = node.array[word.charAt(i) - 'a'];
			} else {
				Trie subNode = new Trie();
				node.array[word.charAt(i) - 'a'] = subNode;
				node = subNode;
			}
		}
		node.array[26] = new Trie();

	}

	/**
	 * Returns if the word is in the trie.
	 */
	public boolean search(String word) {
		Trie node = this;
		for (int i = 0; i < word.length(); i++) {
			if (node.array[word.charAt(i) - 'a'] != null) {
				node = node.array[word.charAt(i) - 'a'];
			} else {
				return false;
			}
		}
		return node.array[26] != null;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		Trie node = this;
		for (int i = 0; i < prefix.length(); i++) {
			if (node.array[prefix.charAt(i) - 'a'] != null) {
				node = node.array[prefix.charAt(i) - 'a'];
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("app");
		trie.insert("apples");
		boolean search = trie.search("app");
		System.out.println(search);
	}
}
