package com.epiccoder.binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
	private Map<String,TreeMap<Integer,String>> hashMap;
	public TimeMap() {
		hashMap = new HashMap<>();
	}
	public void set(String key,String value,int timestamp) {
		hashMap.computeIfAbsent(key, k-> new TreeMap<Integer,String>()).put(timestamp, value);
	}
	
	public String get(String key,int timestamp){
		if(!hashMap.containsKey(key)) {
			return "";
		}
		TreeMap<Integer,String>  timeValueMap = hashMap.get(key);
		Integer  floorTimeStamp = timeValueMap.floorKey(timestamp);
		return floorTimeStamp == null ? "" : timeValueMap.get(floorTimeStamp);
	}
}
