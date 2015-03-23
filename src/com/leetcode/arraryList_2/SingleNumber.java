package com.leetcode.arraryList_2;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
	/**
	 * Given an array of integers, every element appears twice except for one.
	 * Find that single one. Note: Your algorithm should have a linear runtime
	 * complexity. Could you implement it without using extra memory?
	 */

	/**
	 * find bachelor dog
	 *  O(n)
	 */
	static private void findSingleDog(int[] testArrays) {
		int len = testArrays.length;
		int singleDog = 0;
		for (int i = 0; i < len; i++) {
			singleDog ^= testArrays[i];
		}
		System.out.println(singleDog);
	}

	/**
	 * find couple 
	 * O(n)
	 */
	static private void findDouble(int[] testArrarys) {
		int len = testArrarys.length;
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		for (int i = 0; i < len; i++) {
			if (hashMap.containsKey("" + testArrarys[i])) {
				hashMap.put("D" + testArrarys[i], i);
			} else {
				hashMap.put("" + testArrarys[i], i);
			}
		}
		for (int i = 0; i < len; i++) {
			if (hashMap.containsKey("D" + testArrarys[i])) {
				System.out.println(i + "   "
						+ hashMap.get("D" + testArrarys[i]));
				return;
			}
		}
	}

	public static void main(String[] args) {
		int[] testArrarys = { 1, 34, 6, 52, 34, 52, 4, 6, 1 };
		findSingleDog(testArrarys);
		System.out.println("----------------------");
		int[] testArrarys_2 = { 1, 2, 5, 76, 232, 12, 53, 5 };
		findDouble(testArrarys_2);
	}

}
