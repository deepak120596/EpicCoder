package com.epiccoder.priorityqueue;

import java.util.PriorityQueue;

public class MedianFinder {

	static PriorityQueue<Integer> smallHeap = null;
	static PriorityQueue<Integer> largeHeap = null;

	public MedianFinder() {
		smallHeap = new PriorityQueue<>((a, b) -> b - a);
		largeHeap = new PriorityQueue<>();
	}

	public static void main(String[] args) {

		MedianFinder median = new MedianFinder();
		median.addNum(1);
		median.addNum(2);
		median.addNum(3);
		median.addNum(10);
		System.out.println(median.findMedian());
	}

	public static void addNum(int num) {

		smallHeap.add(num);
		// compare for small and large heap
		if (!largeHeap.isEmpty() && !smallHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()) {
			largeHeap.add(smallHeap.poll());
		}
		// see for uneven size
		if (smallHeap.size() > largeHeap.size() + 1) {
			largeHeap.add(smallHeap.poll());
		}
		if (largeHeap.size() > smallHeap.size() + 1) {
			smallHeap.add(largeHeap.poll());
		}

	}

	public static double findMedian() {

		if (largeHeap.size() > smallHeap.size()) {
			return largeHeap.peek();
		}
		if (largeHeap.size() < smallHeap.size()) {
			return smallHeap.peek();
		}

		return (double) (smallHeap.peek() + largeHeap.peek()) / 2;

	}

}
