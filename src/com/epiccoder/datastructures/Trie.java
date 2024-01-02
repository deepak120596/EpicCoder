package com.epiccoder.datastructures;

public class Trie {
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
public static void main(String[] args) {
		Trie dataList = new Trie();
		dataList.insert("Apple");
		dataList.insert("Appl");
		dataList.insert("Appdle");
		dataList.insert("Boy");
		dataList.insert("Badlu");
		System.out.println(dataList.search("apple"));
		System.out.println(dataList.startsWith("co"));
		
		

}
public void insert(String word) {
	word = word.toLowerCase();
	TrieNode current = root;
	for(int i=0;i<word.length();i++) {
		int index = word.charAt(i)-'a';
		if(current.children[index]==null) {
			current.children[index] = new TrieNode();
		}
		current = current.children[index];
	}
	current.isEndOfWord = true;
}

public boolean search(String word) {
	word = word.toLowerCase();
	TrieNode current = root;
	for(char ch : word.toCharArray()) {
		int index = ch -'a';
		if(current.children[index]==null) {
			return false;
		}
		current = current.children[index];
	}
	return current.isEndOfWord;
}
public boolean startsWith(String prefix) {
	prefix = prefix.toLowerCase();
	TrieNode current = root;
	for(char ch : prefix.toCharArray()) {
		int index = ch -'a';
		if(current.children[index]==null) {
			return false;
		}
		current = current.children[index];
	}
	return true;
}

}
