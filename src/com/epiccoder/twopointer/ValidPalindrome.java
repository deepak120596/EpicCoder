package com.epiccoder.twopointer;

public class ValidPalindrome {

	public static void main(String[] args) {
		String str = "naman";
		System.out.println(isPalindrome(str));
	}

	public static boolean isPalindrome(String s) {
		s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		char[] alphaNumericCharArray = s.toCharArray();
		int start = 0, end = alphaNumericCharArray.length - 1;
		while (start <= end) {
			if (alphaNumericCharArray[start] != alphaNumericCharArray[end])
				return false;
			start++;
			end--;
		}
		return true;
	}

}
