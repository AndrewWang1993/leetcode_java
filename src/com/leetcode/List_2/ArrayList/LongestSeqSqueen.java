package com.leetcode.List_2.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestSeqSqueen {
	/**
	 * Given an unsorted array of integers, find the length of the longest
	 * consecutive elements sequence. For example, Given [100, 4, 200, 1, 3, 2],
	 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its
	 * length: 4. Your algorithm should run in O(n) complexity.
	 */

	/**
	 * O(n^2)
	 */
	static private int longSeqQueen(int[] testArray) {
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int maxLen = 1;
		int tmpMaxLen = 1;
		int len = testArray.length;
		for (int i = 0; i < len; i++) {
			hashMap.put(testArray[i], i);
		}
		Iterator<?> iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iterator.next();
			int val = (int) entry.getKey();
			tmpMaxLen = 1;
			int toHigh = val + 1;
			int toLow = val - 1;
			for (int j = 0; j < len; j++) {
				if (hashMap.containsKey(toLow)) {
					--toLow;
					tmpMaxLen++;
				} else if (hashMap.containsKey(toHigh)) {
					++toHigh;
					tmpMaxLen++;
				} else {
					break;
				}
			}
			maxLen = tmpMaxLen > maxLen ? tmpMaxLen : maxLen;
		}
		return maxLen;
	}

	/**
	 * O(n)
	 */
	static private int longSeqQueen_method2(int[] testArray) {
		Map<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
		int maxLen = 1;
		int tmpMaxLen = 1;
		int len = testArray.length;
		for (int i = 0; i < len; i++) {
			hashMap.put(testArray[i], false);
		}
		Iterator<?> iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) iterator.next();
			int val = (int) entry.getKey();
			if (hashMap.get(val)) {
				continue;
			}
			hashMap.put(val, true);
			tmpMaxLen = 1;
			int toHigh = val + 1;
			int toLow = val - 1;
			for (int j = 0; j < len; j++) {
				if (hashMap.containsKey(toLow) && !hashMap.get(toLow)) {
					hashMap.put(toLow, true);
					--toLow;
					tmpMaxLen++;
				} else if (hashMap.containsKey(toHigh) && !hashMap.get(toHigh)) {
					hashMap.put(toHigh, true);
					++toHigh;
					tmpMaxLen++;
				} else {
					break;
				}
			}
			maxLen = tmpMaxLen > maxLen ? tmpMaxLen : maxLen;
		}
		return maxLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testArray = { 34, 3, 6, 8, 2, 4, 9, 23, 64, 65, 5 };
		System.out.println(longSeqQueen(testArray));
		System.out.println(longSeqQueen_method2(testArray));
	}

}
