package com.epiccoder.twopointer;

public class TwoSumSorted {

	public static void main(String[] args) {
		int[] arr = { 2, 7, 11, 15 };
		int target = 9;
		int[] res = twoSum(arr, target);

		System.out.println(res[0] + " " + res[1]);

	}

	public static int[] twoSum1(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (nums[start] + nums[end] != target) {
			if ((nums[start] + nums[end]) < target)
				start++;
			else
				end--;
		}
		return new int[] { start + 1, end + 1 };
	}

	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			int low = i + 1;
			int high = nums.length - 1;
			int complement = target - nums[i];
			int mid = 0;
			while (low <= high) {
				mid = (low + high) >>> 1;
				if (nums[mid] == complement && mid != i) {
					return new int[] { i + 1, mid + 1 };
				} else if (nums[mid] < complement) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}

		}

		return null;

	}
}
