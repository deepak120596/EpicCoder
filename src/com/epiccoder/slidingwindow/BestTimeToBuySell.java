package com.epiccoder.slidingwindow;

public class BestTimeToBuySell {

	public static void main(String[] args) {
		int[] nums = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(nums));
		;
	}
public static int maxProfit(int[] prices) {
		int lsf = Integer.MAX_VALUE;int pist = 0,op=0,strt=0,end=0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < lsf) {
				lsf = prices[i];
				strt = i;
			}
			pist = prices[i]-lsf;
			if(op<pist) {
				op = pist;
				end = i;
			}

		}
		System.out.println(strt + " Start " + end + " end");
		return op;
	}

}
