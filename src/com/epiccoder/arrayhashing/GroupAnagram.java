package com.epiccoder.arrayhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(strs));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> keyToListMap = new HashMap<>();
		for (String currentStr : strs) {
			char[] charArray = currentStr.toCharArray();
			Arrays.sort(charArray);
			String sortedString = new String(charArray);
			keyToListMap.computeIfAbsent(sortedString, k-> new ArrayList<>()).add(currentStr);
		}
		return new ArrayList<>(keyToListMap.values());
	}

}
