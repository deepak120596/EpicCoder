package com.epiccoder.stack;

import java.util.Stack;
import com.epiccoder.priorityqueue.Pair;

public class MinStack {
	
	private Stack<Pair<Integer,Integer>> stack =null;
	public static void main(String[] args) {
		MinStack obj = new MinStack();
		  obj.push(-2);
		  obj.push(0);
		  obj.push(-3);
		  System.out.println(obj.getMin());
		  obj.pop();
		  System.out.println(obj.top());
		  System.out.println(obj.getMin());
	}
	
	    public MinStack() {
	       this.stack = new Stack<>();
	    }
	    
	    public void push(int val) {
	    	stack.push(new Pair(val,stack.isEmpty()?val:Math.min(val,stack.peek().getKey())));
	    }
	    
	    public void pop() {
	       stack.pop(); 
	    }
	    
	    public int top() {
	       return stack.peek().getKey();
	    }
	    
	    public int getMin() {
	        return stack.peek().getValue();
	    }

}
