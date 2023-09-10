package com.epiccoder.arrayhashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KFrequentNums {

	public static void main(String[] args) {
		int[] nums = { 1,1,1,2,2,3 };
		int k = 2;
		//System.out.println(topKFrequent(nums, k));;
		for(int i:topKFrequent(nums, k)) {
			System.out.println(i);
		}
	}
	
	public static int[] topKFrequent1(int[] nums, int k) {
		Map<Integer, Integer> numAndCountMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			numAndCountMap.put(nums[i], numAndCountMap.getOrDefault(nums[i], 0) + 1);
		}
		int[] result = new int[k];
		List<Integer> sortedByFrequencyList = new ArrayList<>(numAndCountMap.keySet());
		Collections.sort(sortedByFrequencyList, (a, b) -> numAndCountMap.get(b) - numAndCountMap.get(a));
		for (int i = 0; i < k; i++) {
			result[i] = sortedByFrequencyList.get(i);
		}

		return result;

	}
	
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> numAndCountMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			numAndCountMap.put(nums[i], numAndCountMap.getOrDefault(nums[i], 0) + 1);
		}
		int[] result = new int[k];
		//PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->numAndCountMap.get(b)-numAndCountMap.get(a));
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b) {
				return numAndCountMap.get(b)-numAndCountMap.get(a);
			}
		});
		for(int num : numAndCountMap.keySet()) {
			queue.add(num);	
		}
		for(int i=0;i<k;i++) {
			result[i] = queue.poll();
		}
		return result;
	}
	
	}
	
	


