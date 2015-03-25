package com.leetcode.arraryList_2;

import java.util.ArrayList;

public class SetMatrixZero {

	/**
	 * Given a m * n matrix, if an element is 0, set its entire row and column
	 * to 0. Do it in place. Follow up: Did you use extra space? A straight
	 * forward solution using O(mn) space is probably a bad idea. A simple
	 * improvement uses O(m + n) space, but still not the best solution. Could
	 * you devise a constant space solution?
	 */

	/**
	 * time complex O(n*m) space complex O(m+n)
	 */
	static private int[][] deleteZero(int[][] testArrary) {
		ArrayList<Integer> arrayList1, arrayList2;
		arrayList1 = new ArrayList<Integer>();
		arrayList2 = new ArrayList<Integer>();
		int row = testArrary.length;
		int col = testArrary[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (testArrary[i][j] == 0) {
					arrayList1.add(i);
					arrayList2.add(j);
				}
			}
		}
		int lenRow = arrayList1.size();
		for (int i = 0; i < lenRow; i++) {
			for (int j = 0; j < col; j++) {
				testArrary[arrayList1.get(i)][j] = 0;
			}
		}
		int lenCol = arrayList2.size();
		for (int i = 0; i < lenCol; i++) {
			for (int j = 0; j < row; j++) {
				testArrary[j][arrayList2.get(i)] = 0;
			}
		}

		return testArrary;
	}

	/**
	 * time complex O(n*m) space complex O(1) save the row and col number to
	 * every col or rows first elements
	 */
	private static int[][] deleteZero_method2(int[][] testArrary) {
		boolean isFirstRowHaveZero = false;
		boolean isFirstColHaveZero = false;
		int rowLen = testArrary.length;
		int colLen = testArrary[0].length;
		for (int i = 0; i < rowLen; i++) {
			if (testArrary[i][0] == 0) {
				isFirstColHaveZero = true;
				break;
			}
		}
		for (int i = 0; i < colLen; i++) {
			if (testArrary[0][i] == 0) {
				isFirstRowHaveZero = true;
				break;
			}
		}
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (testArrary[i][j] == 0) {
					testArrary[0][j] = 0;
					testArrary[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < rowLen; i++) {
			if (testArrary[i][0] == 0) {
				for (int j = 0; j < colLen; j++) {
					testArrary[i][j] = 0;
				}
			}
		}
		for (int i = 1; i < colLen; i++) {
			if (testArrary[0][i] == 0) {
				for (int j = 0; j < rowLen; j++) {
					testArrary[j][i] = 0;
				}
			}
		}
		if (isFirstRowHaveZero) {
			for (int i = 0; i < colLen; i++) {
				testArrary[0][i] = 0;
			}
		}
		if (isFirstColHaveZero) {
			for (int i = 0; i < rowLen; i++) {
				testArrary[i][0] = 0;
			}
		}
		return testArrary;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] testArrary = { { 1, 2, 0, 3, 5, 77 }, { 2, 4, 23, 4, 7, 34 },
				{ 0, 6, 8, 4, 9, 24 }, { 3, 53, 4, 0, 3, 32 } };

		int[][] resultArrary = deleteZero(testArrary);
		int row = resultArrary.length;
		int col = resultArrary[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(resultArrary[i][j] + " ");
			}
			System.out.println("");
		}

		System.out.println("----------------");

		int[][] testArrary2 = { { 1, 2, 0, 3, 5, 77 },
				                 { 2, 4, 23, 4, 7, 34 },
				                 { 0, 6, 8, 4, 9, 24 },
				                 { 3, 53, 4, 0, 3, 32 } };
		int[][] resultArrary2 = deleteZero_method2(testArrary2);
		int row2 = resultArrary2.length;
		int col2 = resultArrary2[0].length;
		for (int i = 0; i < row2; i++) {
			for (int j = 0; j < col2; j++) {
				System.out.print(resultArrary2[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
