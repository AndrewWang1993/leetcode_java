package com.leetcode.List_2.ArrayList;

public class RemoveElement {

	/**
	 * Given an array and a value, remove all instances of that value in place
	 * and return the new length. The order of elements can be changed. It
	 * doesn¡¯t matter what you leave beyond the new length.
	 */

	/**
	 * O(n)
	 */
	static int removeElem(int[] testArrarys, int value) {
		int len = testArrarys.length;
		int index = 0;
		for (int i = 0; i < len; i++) {
			if (testArrarys[i] != value) {
				testArrarys[index++] = testArrarys[i];
			}
		}
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testArrays = { 1, 2, 3, 422, 32, 13, 23, 2, 1, 3 };
		System.out.println(removeElem(testArrays, 13));
	}

}
