package com.epiccoder.twopointer;

public class TrappingRainWater {

	public static void main(String[] args) {
		int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));

	}
	
	public static int trap(int [] height) {
		int water = 0;
		int left = 0, right = height.length -1;
		int leftMax = height[left],rightMax = height[right];
		while(left < right) {
			if(leftMax<rightMax) {
				left++;
				leftMax = Math.max(leftMax, height[left]);
				water += leftMax - height[left];
			}
			else {
			  right--;
			  rightMax = Math.max(height[right], rightMax);
			  water += rightMax - height[right];
			}
		}
		
		
		
		return water;
	}

}
