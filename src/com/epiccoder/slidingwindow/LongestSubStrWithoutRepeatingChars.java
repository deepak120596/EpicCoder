package com.epiccoder.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrWithoutRepeatingChars {

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {
		int res = 0, left = 0;
		Set<Character> uniqueSet = new HashSet<>();
		for (int right = 0; right < s.length(); right++) {
			while (uniqueSet.contains(s.charAt(right)) && left <= right) {
				uniqueSet.remove(s.charAt(left));
				left++;
			}
			uniqueSet.add(s.charAt(right));
			res = Math.max(res, right - left + 1);

		}

		return res;
	}

}
