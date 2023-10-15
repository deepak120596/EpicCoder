package com.epiccoder.priorityqueue;

import java.util.PriorityQueue;

public class KClosestPoint {

	public static void main(String[] args) {
		int [][] nums = {{1,3},{-2,2}};
		kClosest(nums,1);
	}
	public static int [][] kClosest(int [][] points, int k){
		PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[1]-b[1]);
		for(int i=0;i<points.length;i++) {
			
			int sum = (points[i][0]*points[i][0] + points[i][1]*points[i][1]);
			heap.add(new int[]{i,sum});
			
		}
		int [][] res = new int[k][];
		while(k>0) {
			res[k-1] = points[heap.poll()[0]]; 
			k--;
		}
		
		return res;
	}
	

}
