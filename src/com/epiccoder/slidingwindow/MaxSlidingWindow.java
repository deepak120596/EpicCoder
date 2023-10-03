package com.epiccoder.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {

	public static void main(String[] args) {
		int [] nums= {1,3,-1,-3,5,3,6,7};
		int k = 3;
	int [] res = maxSlidingWindow(nums,k);
	for(int e : res) {
		System.out.print(e + " ");
	}

	}
	
	public static int [] maxSlidingWindow(int [] nums,int k) {
		Deque<Integer> deq = new ArrayDeque<>();
		int [] result = new int[nums.length-k+1];int idx=0;
		for(int right=0;right<nums.length;right++) {
			
			while(!deq.isEmpty() && nums[deq.peekFirst()]<nums[right]) {
				deq.pollFirst();
			}
			while(!deq.isEmpty() && deq.peekLast() < right -k +1) {
				deq.pollLast();
			}
			
			deq.offerFirst(right);
			if(right+1>=k) {
				result[idx++] = nums[deq.peekLast()];
			}
		}
		
		return result;
		
	}

}
