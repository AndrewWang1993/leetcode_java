package com.leetcode.List_2.ArrayList;

/**
 * @author wxm
 */
public class RemoveDupliFromSorted {
	/**
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length. Do not allocate extra
	 * space for another array, you must do this in place with constant memory.
	 * For example, Given input array A = [1,1,2], Your function should return
	 * length = 2, and A is now [1,2].
	 * O(n)
	 * @param testArrary
	 * @return
	 */
	private static int[] removeDepli(int[] testArrary) {
		int len = testArrary.length;
		int count = 0;
		if (len == 0 || len == 1) {
			return testArrary;
		}
		for (int i = 1, j = 1; i < len; i++) {
			if (testArrary[i] != testArrary[i - 1]) {
				testArrary[j++] = testArrary[i];
			} else {
				count++;
			}
		}
		int resultArrary[] = new int[len - count];
		for (int i = 0; i < len - count; i++) {
			resultArrary[i] = testArrary[i];
		}
		return resultArrary;
	}

	public static void main(String[] args) {
		final int[] testArrary = { 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
				3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
				3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5 };
		int[] resultArrary = removeDepli(testArrary);
		int len = resultArrary.length;
		for (int i = 0; i < len; i++) {
			System.out.print(resultArrary[i] + " ");
		}
	}

}
