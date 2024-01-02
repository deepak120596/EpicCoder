package com.epiccoder.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String s = "]";
		System.out.println(isValid(s));

	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> brackets = new HashMap<>();
		brackets.put('(', ')');
		brackets.put('{', '}');
		brackets.put('[', ']');
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (!stack.isEmpty() && brackets.get(stack.peek()) == c) {
					stack.pop();
				} else {
					return false;
				}
			}

		}

		return stack.isEmpty();
	}

}
