package com.epiccoder.twopointer;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] nums = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(nums));

	}

	public static int maxArea(int[] height) {
		int maxWater = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			int currentWater = Math.min(height[left], height[right]) * (right - left);
			maxWater = Math.max(maxWater, currentWater);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxWater;
	}

}
