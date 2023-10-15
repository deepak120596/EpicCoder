package com.epiccoder.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LastStone {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 4, 1, 8, 1 };
		System.out.println(lastStoneWeight(nums));
	}

	public static int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
		List<Integer> list = new ArrayList<>();
		for (int n : stones)
			list.add(n);
		heap.addAll(list);

		while (!heap.isEmpty() && heap.size() > 1) {
			int x = heap.poll();
			int y = heap.poll();

			if (x != y) {
				y = x - y;
				heap.add(y);
			}

		}

		return heap.isEmpty() ? 0 : heap.poll();
	}

}
