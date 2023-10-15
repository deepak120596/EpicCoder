package com.epiccoder.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest {
	PriorityQueue<Integer> heap =null;
	int k=0;
	KthLargest(int k,int [] nums){
		heap = new PriorityQueue<>();
		this.k=k;
		List<Integer> list = new ArrayList<>();
		for(int n : nums) {
			list.add(n);
		}
		heap.addAll(list);
		while(heap.size()>k)
			heap.poll();
	}
	public static void main(String[] args) { 
		int [] nums = {4,5,8,2};
		KthLargest kthLargest = new KthLargest(3,nums);
		System.out.println(kthLargest.add(3));
		System.out.println(kthLargest.add(5));
		System.out.println(kthLargest.add(10));
		System.out.println(kthLargest.add(9));
		System.out.println(kthLargest.add(4));
	}
	
	int  add(int val) {
		heap.add(val);
		while(heap.size()>k)
			heap.poll();
		
		return heap.peek();
		
	}
}