package com.epiccoder.priorityqueue;

public class Pair<T1, T2> {
	
	Integer key;
	Integer value;
	public Pair(int key, int val) {
		this.key= key;
		this.value = val;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}

}
