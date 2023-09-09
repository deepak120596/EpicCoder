package com.epiccoder.arrayhashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] arr = { 0, 4, 3, 0 };
		int taget = 0;
		int[] result = twoSum(arr, taget);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> numAndIndex = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (numAndIndex.containsKey(target - nums[i])) {
				result[0] = numAndIndex.get(target - nums[i]);
				result[1] = i;
			} else {
				numAndIndex.put(nums[i], i);
			}

		}
		return result;

	}

}
