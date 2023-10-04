package com.epiccoder.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

	public static void main(String[] args) {
		String s="ADOBECODEBANC";
		String t="ABC";
		System.out.println(minWindow(s,t));
	}
	
	public static String minWindow(String s , String t) {
		if (t == "") return "";
		Map<Character,Integer> countT = new HashMap<>();
		Map<Character,Integer> windowS = new HashMap<>();
		int [] result = {-1,-1};int resLen = Integer.MAX_VALUE;
		int left=0;
		for(int i=0;i<t.length();i++) {
			countT.put(t.charAt(i),countT.getOrDefault(t.charAt(i),0)+1);
		}
		int have=0,need=countT.size();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			windowS.put(s.charAt(i),windowS.getOrDefault(s.charAt(i), 0)+1);
			if(countT.containsKey(c) && countT.get(c)== windowS.get(c)) {
				have++;
			}
			while(have==need) {
				if((i-left+1) < resLen) {
					result[0]=left;
					result[1]=i;
					resLen=i-left+1;
				}
					windowS.put(s.charAt(left),windowS.get(s.charAt(left))-1);
					if(countT.containsKey(s.charAt(left)) && countT.get(s.charAt(left)) > windowS.get(s.charAt(left))) {
						have--;
					}	
				left++;	
				
			}
		}
		
	 if(resLen != Integer.MAX_VALUE) {
	  return s.substring(result[0],result[1]+1);	 
	 }
	 else
		 return "";
		
	}

}
