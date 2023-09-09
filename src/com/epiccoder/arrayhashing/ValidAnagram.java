package com.epiccoder.arrayhashing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {
		String s = "cat", t = "rat";
		System.out.println(isAnagram(s,t));

	}
		
	public static boolean isAnagram(String s, String t) {
		char [] sCharArray=s.toCharArray();
		char [] tCharArray=t.toCharArray();
		Map<Character,Integer> charAndCountMap = new HashMap<>();
		for(int i=0;i<sCharArray.length;i++) {
			charAndCountMap.put(sCharArray[i],charAndCountMap.getOrDefault(sCharArray[i],0)+1);
		}
		for(int i=0;i<tCharArray.length;i++) {
			charAndCountMap.put(tCharArray[i],charAndCountMap.getOrDefault(tCharArray[i],0)-1);
		}
		List<Integer> counts = new ArrayList<>(charAndCountMap.values());
		return counts.stream().allMatch(i -> i==0);
	}
}
