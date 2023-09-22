package com.epiccoder.binarysearch;

public class KokoEatingBananas {

	public static void main(String[] args) {
		int [] piles = {3,6,7,11};
		int h = 8;
		System.out.println(minEatingSpeed(piles,h));
	}
	
	public static int minEatingSpeed(int [] piles , int h) {
		int max = 0;
		for(int i :piles) {
			max = Math.max(max, i);
		}
		int start = 1;
		int end = max;
		while(start < end) {
			int mid = start + (end-start)/2;
			if(calculateHours(piles,mid)>h) {
				start = mid + 1;
			}
			else {
				end = mid;
			}
			
			
		}
		
		
		return start;
		
	}

	private static int calculateHours(int[] piles, int mid) {
		int hrs =0;
		for(int pile : piles) {
			hrs+=Math.ceil((double)pile/mid);
		}
		return hrs;
	}
	

}
