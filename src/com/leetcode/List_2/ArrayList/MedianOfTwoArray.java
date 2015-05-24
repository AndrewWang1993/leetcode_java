package com.leetcode.List_2.ArrayList;

public class MedianOfTwoArray {
	/**
	 * There are two sorted arrays A and B of size m and n respectively. Find
	 * the median of the two sorted arrays. The overall run time complexity
	 * should be O(log(m + n)). it should generalize by find the Nth big number
	 * 
	 * Notice(prequest): each array size mush biger than k/2
	 */

	private static int findMedian(int[] array1, int[] array2, int medianPos) {
		// TODO Auto-generated method stub
		int len1 = array1.length;
		int len2 = array2.length;
		if (len1 == 0 && len2 == 0) {
			return Integer.MAX_VALUE;
		}
		if (len1 == 0 && medianPos < len2) {
			return array2[medianPos - 1];
		}
		if (len2 == 0 && medianPos < len1) {
			return array1[medianPos - 1];
		}
		if (medianPos == 1) {
			return array1[0] > array2[0] ? array2[0] : array1[0];
		}
		if (array1[medianPos / 2 - 1] < array2[medianPos / 2 - 1]) {
			int newLenght = len1 - medianPos / 2;
			int[] newarray1 = new int[newLenght];
			for (int i = 0; i < newLenght; i++) {
				newarray1[i] = array1[medianPos / 2 + i];
			}
			return findMedian(newarray1, array2, medianPos - medianPos / 2);
		} else if (array1[medianPos / 2 - 1] > array2[medianPos / 2 - 1]) {
			int newLenght = len2 - medianPos / 2;
			int[] newarray2 = new int[newLenght];
			for (int i = 0; i < newLenght; i++) {
				newarray2[i] = array2[medianPos / 2 + i];
			}
			return findMedian(array1, newarray2, medianPos - medianPos / 2);
		} else {
			if (medianPos % 2 == 0) {
				return array1[medianPos / 2 - 1];
			} else {
				return array1[medianPos / 2];
			}
		}
	}

	/**
	 * find the Nth smaller number in two sorted arrays O(n+m)
	 */
	private static int find_Nth_Smaller(int[] array1, int[] array2, int n) {
		int len1 = array1.length;
		int len2 = array2.length;

		int i = 0, j = 0, p;
		p = n - 1;
		if (p < 0 || p > len1 + len2 - 1) {
			return -1;
		}
		while (i < len1 && j < len2) {
			if (array1[i] < array2[j]) {
				if (p == 0) {
					return array1[i];
				}
				i++;
			} else {
				if (p == 0) {
					return array2[j];
				}
				j++;
			}
			p--;
		}
		if (i == len1) {
			return array2[j + p];
		} else {
			return array1[i + p];
		}

	}

	public static void main(String[] ss) {
		int[] testArray1 = { 2, 3, 11 };
		int[] testArray2 = { 2, 3, 8 };
		System.out.println(find_Nth_Smaller(testArray1, testArray2, 6));

		System.out.println(findMedian(testArray1, testArray2,
				(testArray1.length + testArray2.length) / 2));
	}
}