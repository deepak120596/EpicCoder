package com.epiccoder.slidingwindow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		String s = "AABABBA";
		int k = 1;
		System.out.println(characterReplacement(s, k));
	}
	
	public static int characterReplacement(String s, int k) {
		int res = 0;
		Map<Character, Integer> map = new HashMap<>();
		int left = 0, largestCharCount = 0;
		for (int right = 0; right < s.length(); right++) {
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
			largestCharCount = Math.max(largestCharCount,map.get(s.charAt(right))!=null ?map.get(s.charAt(right)) : 0);
			while (((right - left + 1) - largestCharCount) > k) {
				map.put(s.charAt(left), map.get(s.charAt(left))- 1);
				left++;
			}
			res = Math.max(res, right - left + 1);
		}
			return res;

	}

	public static int characterReplacement1(String s, int k) {
		int res = 0;
		Map<Character, Integer> map = new HashMap<>();
		int left = 0, largestCharCount = 0;
		for (int right = 0; right < s.length(); right++) {
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
			while ((right - left + 1) - largestCharCount((new ArrayList<>(map.values()))) > k) {
				map.put(s.charAt(left), map.get(s.charAt(left) - 1));
				left++;
			}
			res = Math.max(res, right - left + 1);
		}
			return res;

	}

	private static int largestCharCount(List<Integer> values) {
		int res = 0;
		for (int i = 0; i < values.size(); i++) {
			res = Math.max(res, values.get(i));
		}
		return res;
	}

}
