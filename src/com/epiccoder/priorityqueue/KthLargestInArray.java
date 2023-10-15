package com.epiccoder.priorityqueue;

import java.util.PriorityQueue;

public class KthLargestInArray {

	public static void main(String[] args) {
		int [] nums = {3,2,3,1,2,4,5,5,6};
		System.out.println(findKthLargest(nums,4));
	}
	
	public static int findKthLargest1(int [] nums, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for(int n : nums) {
			heap.add(n);
		}
		while(heap.size()>k) {
			heap.poll();
		}
		
		return heap.peek();
		
	}
	
	public static int findKthLargest(int [] nums, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for(int i=0;i<k;i++) {
			heap.add(nums[i]);
		}
		for(int i=k;i<nums.length;i++) {
			
			if(nums[i]>heap.peek()) {
				heap.poll();
				heap.add(nums[i]);
			}
		}
		return heap.peek();
		
	}

}
