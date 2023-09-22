package com.epiccoder.binarysearch;

public class SearchInRotated {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		System.out.println(search(nums, target));
	}

	public static int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[low] <= nums[mid]) {

				if (nums[low] <= target && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}

			}

		}
		return -1;

	}

}
