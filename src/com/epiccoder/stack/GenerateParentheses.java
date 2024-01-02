package com.epiccoder.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
	
	static Stack<Character> stack = new Stack<>();
	static List<String> result = new ArrayList<>();

	public static void main(String[] args) {
		List<String> str = generateParenthesis(4);
		for(String st : str) {
		 System.out.println(st+" , ");	
		}
	}
	
	public static List<String> generateParenthesis(int n) {
		return backTrack(0,0,n);
	}

	private static List<String> backTrack(int openN, int closedN, int n) {
		if(openN==closedN && (closedN==n)) {
			String temp = "";
			Iterator<Character> itr = stack.iterator();
			while(itr.hasNext()) {
				temp += itr.next();
			}
			result.add(temp);
		}
		if(openN<n) {
			stack.push('(');
			backTrack(openN+1,closedN,n);
			stack.pop();
		}
		if(closedN<openN) {
			stack.push(')');
			backTrack(openN,closedN+1,n);
			stack.pop();
		}
		return result;
	}

}
