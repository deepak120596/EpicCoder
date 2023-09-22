package com.epiccoder.binarysearch;

public class MinRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 17,11,12,13,16 };
		System.out.println(findMin(nums));

	}
	public static int findMin(int[] nums) {
		int ans = Integer.MAX_VALUE;
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) >>> 1;
			if (nums[left] <= nums[mid]) {
				ans = Math.min(ans, nums[left]);
				left = mid + 1;
			} else {
				ans = Math.min(ans, nums[mid]);
				right = mid - 1;
			}
		}
		return ans;
	}

}
