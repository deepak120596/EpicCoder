package com.epiccoder.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		int [] nums= {-1,0,1,2,-1,-4};
		List<List<Integer>> ans= threeSum(nums);
		for(int i=0;i<ans.size();i++) {
			System.out.println();
			for(int j=0;j<ans.get(i).size();j++){
				System.out.print("["+ans.get(i).get(j)+"], ");
			}
		}
	}
	
	public static List<List<Integer>> threeSum1(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++) {
			if(i>0 && nums[i]==nums[i-1]) {
				continue;
			}
			int j=i+1;
			int k=nums.length-1;
			while(j<k) {
				int sum = nums[i]+ nums[j]+ nums[k];
				if(sum==0) {
					result.add(Arrays.asList(nums[i],nums[j],nums[k]));
				while(j<k && nums[j]==nums[j+1]) {
					j++;
				}
				while(j<k && nums[k]==nums[k-1]) {
					k--;
				}
				
				j++;k--;
				}
				
				else if(sum < 0) {
					j++;
				}
				else {
					k--;
				}
				
				
				
				
			}
			
			
			
		}
		
		return result;
		
	}
	public static List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = (nums[i] + nums[j] + nums[k]);
				if (sum == 0) {
					set.add(Arrays.asList(nums[i], nums[j] ,nums[k]));
					j++;
					k--;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}

		}
		result.addAll(set);
		
		
		return result;
		
	}
	
}
