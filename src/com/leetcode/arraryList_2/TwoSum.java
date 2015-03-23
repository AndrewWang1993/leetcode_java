package com.leetcode.arraryList_2;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	/**
	 * Given an array of integers, find two numbers such that they add up to a
	 * specific target number. The function twoSum should return indices of the
	 * two numbers such that they add up to the target, where index1 must be
	 * less than index2. Please note that your returned answers (both index1 and
	 * index2) are not zero-based. You may assume that each input would have
	 * exactly one solution. Input: numbers={2, 7, 11, 15}, target=9 Output:
	 * index1=1, index2=2
	 */

	/**
	 * O(n^2)
	 */
	static private void findTwoSum_method1(int[] testArrary, int sum) {
		int len = testArrary.length;
		for (int i = 0; i < len; i++) {
			int gap = sum - testArrary[i];
			for (int j = 0; j < len && j != i; j++) {
				if (gap == testArrary[j]) {
					System.out.println(j + " " + i);
					return;
				}
			}
		}
		System.out.println("" + -1);
	}

	/**
	 * O(n)
	 */
	static private void findTwoSum_method2(int[] testArrays, int sum) {
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int len = testArrays.length;
		for (int i = 0; i < len; i++) {
			hashMap.put(testArrays[i], i);
		}
		for (int i = 0; i < len; i++) {
			int gap = sum - testArrays[i];
			if (hashMap.containsKey(gap)) {
				System.out.println(i + " " + hashMap.get(gap));
				return;
			}
		}
		System.out.println("" + -1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testArrary = { 2, 4, 6, 34, 63, 43 };
		int sum = 69;
		findTwoSum_method1(testArrary, sum);
		System.out.println("---------------------");
		findTwoSum_method2(testArrary, sum);
	}
}
