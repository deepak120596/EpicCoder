package com.epiccoder.slidingwindow;

public class StringInPermutation {

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidbaooooo";
		System.out.println(checkInclusion(s1, s2));
	}

	public static boolean checkInclusion(String s1, String s2) {

		if (s1.length() > s2.length())
			return false;
		int [] s1map = new int[26];
		int [] s2map = new int[26];
		for(int i=0;i<s1.length();i++) {
			s1map[s1.charAt(i)-'a']++;
			s2map[s2.charAt(i)-'a']++;
		}
		int matches = checkEquality(s1map,s2map);
		int left = 0;
		for(int i=s1.length();i<s2.length();i++) {
			if(matches == 26 ) return true;
			int index = s2.charAt(i)-'a';
			s2map[index]++;
			if(s2map[index]==s1map[index])
				matches++;
			else if(s2map[index] == s1map[index]+1)
				matches--;
			index = s2.charAt(left)-'a';
			s2map[index]--;
			if(s2map[index]==s1map[index])
				matches++;
			else if(s2map[index]==s1map[index]-1)
				matches--;
			left++;
		}
		return matches == 26;
	}

	private static int checkEquality(int[] s1map, int[] s2map) {
		int res = 0;
		for(int i=0;i<26;i++) {
			if(s1map[i]==s2map[i])
				res++;
		}
		return res;
	}

}
