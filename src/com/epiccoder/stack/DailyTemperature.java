package com.epiccoder.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.epiccoder.priorityqueue.Pair;

public class DailyTemperature {

	public static void main(String[] args) {
		int [] arr = {73,74,75,71,69,72,76,73};
		int[] res = dailyTemperatures(arr);
		for(int a : res) {
			System.out.println(a+" ,");
		}
	}
	
	public static int[] dailyTemperatures(int[] temperatures) {
		int[] result = new int[temperatures.length];
		Stack<Pair<Integer,Integer>> stack = new Stack<>();
		for(int i=0;i<temperatures.length;i++) {
			while(!stack.isEmpty()&&temperatures[i]>stack.peek().getKey()){
				int index = stack.pop().getValue();
				result[index] =(i-index);
			}
			stack.push(new Pair(temperatures[i],i));
		}
		
		return result;
        
    }

}
