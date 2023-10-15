package com.epiccoder.priorityqueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

	public static void main(String[] args) {
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
		System.out.println(leastInterval(tasks, 2));
	}

	public static int leastInterval(char[] tasks, int n) {
		if (n == 0)
			return tasks.length;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		int[] freq = new int[26];
		for (char c : tasks) {
			freq[c - 'A']++;
		}
		for (int val : freq) {
			if (val > 0)
				pq.add(val);
		}
		
		Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
		int time =0;
		while(!pq.isEmpty() || !queue.isEmpty()) {
			time ++;
			if(!pq.isEmpty()) {
				int val = pq.poll();
				val--;
				if(val>0) {
					queue.add(new Pair(time+n,val));
				}
			}
			if(!queue.isEmpty() && queue.peek().getKey() == time) {
				pq.add(queue.poll().getValue());
			}
			
		}
		return time;

	}

}
