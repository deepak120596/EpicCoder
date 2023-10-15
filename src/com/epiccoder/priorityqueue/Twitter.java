package com.epiccoder.priorityqueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
	static Map<Integer, Set<Integer>> followMap = null;
	static Map<Integer, List<Pair>> tweetMap = null;
	static int count = 0;

	public Twitter() {
		count = 0;
		followMap = new HashMap<>();
		tweetMap = new HashMap<>();
	}

	public static void main(String[] args) {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);
		System.out.println(twitter.getNewsFeed(1));
		twitter.follow(1, 2);
		twitter.postTweet(2, 6);
		System.out.println(twitter.getNewsFeed(1));
		twitter.unfollow(1, 2);
		System.out.println(twitter.getNewsFeed(1));
	}

	public static void follow(int followerId, int followeeId) {
		followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
	}

	public static void unfollow(int followerId, int followeeId) {
		if (followMap.get(followerId) != null) {
			HashSet followeeIds = (HashSet) followMap.get(followerId);
			if (followeeIds.contains(followeeId)) {
				followeeIds.remove(followeeId);
			}
		}

	}

	public static void postTweet(int userId, int tweetId) {
		tweetMap.computeIfAbsent(userId, k -> new ArrayList<Pair>()).add(new Pair(count, tweetId));
		count++;
	}

	public static List<Integer> getNewsFeed(int userId) {
		List<Integer> res = new ArrayList<>();
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
		Set<Integer> followeeIds = followMap.get(userId);
		for (int followeeId : followeeIds) {
			if (tweetMap.containsKey(followeeId)) {
				int index = tweetMap.get(followeeId).size() - 1;
				int currentCount = tweetMap.get(followeeId).get(index).getKey();
				int currentTweetId = tweetMap.get(followeeId).get(index).getValue();
				heap.add(new int[] { currentCount, currentTweetId, followeeId, index - 1 });
			}
		}
		while (!heap.isEmpty() && res.size() < 10) {
			int[] currVal = heap.poll();
			int currentCount = currVal[0], currtweetId = currVal[1], followeeId = currVal[2], index = currVal[3];
			res.add(currtweetId);
			if (index >= 0) {
				currentCount = tweetMap.get(followeeId).get(index).getKey();
				int currentTweetId = tweetMap.get(followeeId).get(index).getValue();
				heap.add(new int[] { currentCount, currentTweetId, followeeId, index - 1 });
			}
		}

		return res;
	}

}
