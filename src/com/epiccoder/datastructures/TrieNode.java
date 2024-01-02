package com.epiccoder.datastructures;

public class TrieNode {
	TrieNode[] children;
	boolean isEndOfWord;

	public TrieNode() {
		children = new TrieNode[26];
		isEndOfWord = false;
	}
}
