package com.leetcode.arraryList_2;

public class RemoveDupliFromSorted_2 {
	/**
	 * Follow up for ¡±Remove Duplicates¡±: What if duplicates are allowed at most
	 * twice? For example, Given sorted array A = [1,1,1,2,2,3], Your function
	 * should return length = 5, and A is now [1,1,2,2,3]
	 * O(n)
	 * @param testArrary
	 * @return
	 */
	private static int[] removeDepli_2(int[] testArrary) {
		int len = testArrary.length;
		int count = 0;
		boolean flag = true;
		if (len == 0 || len == 1) {
			return testArrary;
		}
		for (int i = 1, j = 1; i < len; i++) {
			if ((testArrary[i] != testArrary[i - 1])) {
				testArrary[j++] = testArrary[i];
				flag = true;
			} else if (flag && (testArrary[i] == testArrary[i - 1])) {
				testArrary[j++] = testArrary[i];
				flag = false;
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
		final int[] testArrary = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3,
				3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
				3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5, 6, 6,6 };
		int[] resultArrary = removeDepli_2(testArrary);
		int len = resultArrary.length;
		for (int i = 0; i < len; i++) {
			System.out.print(resultArrary[i] + " ");
		}
	}

}
