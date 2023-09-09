package com.epiccoder.arrayhashing;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		System.out.println(containsDuplicate(nums));

	}
public static boolean containsDuplicate(int[] nums) {
    Set<Integer> uniqueNums = new HashSet<>();
    for(int i=0;i<nums.length;i++) {
    	if(uniqueNums.contains(nums[i])) {
    		return true;
    	}
    	uniqueNums.add(nums[i]);
    }
    return false;
}
}
