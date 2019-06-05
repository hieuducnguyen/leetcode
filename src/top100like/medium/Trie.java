/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

/**
 *
 * @author hieund3
 */
public class Trie {

	Node node;

	public Trie() {
		node = new Node();
	}

	public void insert(String word) {
		Node tempNode = this.node;
		for (int i = 0; i < word.length(); i++) {
			if (tempNode.charArray[word.charAt(i) - 'a'] == null) {
				tempNode.charArray[word.charAt(i) - 'a'] = new Node(word.charAt(i));
			}
			tempNode = tempNode.charArray[word.charAt(i) - 'a'];
		}
		tempNode.charArray[26] = new Node('-');
	}

	public boolean search(String word) {
		Node tempNode = node;
		for (int i = 0; i < word.length(); i++) {
			if (tempNode.charArray[word.charAt(i) - 'a'] == null
				|| tempNode.charArray[word.charAt(i) - 'a'].character != word.charAt(i)) {
				return false;
			}
			tempNode = tempNode.charArray[word.charAt(i) - 'a'];
		}
		return tempNode.charArray[26] != null;
	}

	public boolean startsWith(String word) {
		Node tempNode = node;
		for (int i = 0; i < word.length(); i++) {
			if (tempNode.charArray[word.charAt(i) - 'a'] == null
				|| tempNode.charArray[word.charAt(i) - 'a'].character != word.charAt(i)) {
				return false;
			}
			tempNode = tempNode.charArray[word.charAt(i) - 'a'];
		}
		return true;
	}

	class Node {

		public Node() {

		}

		public Node(char character) {
			this.character = character;
		}
		public char character = '-';
		public Node[] charArray = new Node[27];
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("app");
		boolean ret1 = trie.search("apple"); // returns true
		System.out.println("ret1: " + ret1);
		boolean ret2 = trie.search("app"); // returns false
		System.out.println("ret2: " + ret2);
		boolean ret3 = trie.startsWith("app"); // returns true
		System.out.println("ret3: " + ret3);

		trie.insert("apple");
		boolean ret4 = trie.search("app"); // returns true
		System.out.println("ret4: " + ret4);
	}
}
