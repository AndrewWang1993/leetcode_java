package com.leetcode.List_2.ArrayList;

public class SearchRotatedArrary {
	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). You are
	 * given a target value to search. If found in the array return its index,
	 * otherwise return -1. You may assume no duplicate exists in the array.
	 * O(n)
	 * 
	 * @param testArrary
	 * @return
	 */
	private static int searchRoteArrary(int[] testArrary, int value) {
		int len = testArrary.length;
		int targetPos = 0;
		int harfLen = 0;
		if (len == 0) {
			return -1;
		}
		if (len == 1 && testArrary[0] == value) {
			return 1;
		}
		if (testArrary[0] == value) {
			targetPos = 1;
		}
		for (int i = 1; i < len; i++) {
			if ((targetPos == 0) && testArrary[i] == value) {
				targetPos = i + 1;
			}
			if (testArrary[i] < testArrary[i - 1]) {
				harfLen = i;
				if (targetPos != 0) {
					break;
				}
			}
		}
		if (targetPos != 0) {
			return (targetPos > harfLen ? (targetPos - harfLen) : (len
					- harfLen + targetPos)) - 1;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		final int[] testArrary = { 127, 328, 328, 328, 459, 1, 13, 16, 16, 24,
				24, 55, 96 };
		System.out.println(searchRoteArrary(testArrary, 16));
	}

}
