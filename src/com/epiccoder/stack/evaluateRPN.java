package com.epiccoder.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class evaluateRPN {

	public static void main(String[] args) {
		String[] tokens = { "2", "1", "+", "3", "*"};
		System.out.println(evalRPN(tokens));
	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		Set<String> operators = new HashSet<>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");

		for (String val : tokens) {
			if (operators.contains(val)) {
				int a = stack.pop();
				int b = stack.pop();
				int res=  eval(val,a,b);
				stack.push(res);
				
			}else {
				stack.push(Integer.parseInt(val));
			}

		}
		return stack.peek();

	}

	private static  int eval(String val, int a, int b) {
		if(val.equals("+"))
			return a+b;
		else if(val.equals("-")) {
			return b-a;
		}
		else if(val.equals("*")) {
			return a*b;
		}
		else {
			return b/a;
		}
	}
}
