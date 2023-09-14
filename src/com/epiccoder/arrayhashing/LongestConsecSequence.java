package com.epiccoder.arrayhashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecSequence {

	public static void main(String[] args) {
		int [] nums = {100,4,200,1,3,2};
		System.out.println(longestConsecutive(nums)); 
	}
	
	public static int longestConsecutive(int[] nums) {
		Set<Integer> record = new HashSet<>();
		for(int i=0;i<nums.length;i++) {
			record.add(nums[i]);
		}
		int count =0,maxCount=0;
		for(int i=0;i<nums.length;i++) {
			if(record.contains(nums[i]-1)) continue;
			while(record.contains(nums[i])) {
				count++;
				nums[i]++;
			}
			maxCount = Math.max(maxCount,count);
			count=0;
		}
		
		
		return maxCount;
     }

}
