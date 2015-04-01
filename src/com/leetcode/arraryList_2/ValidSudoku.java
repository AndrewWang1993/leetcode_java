package com.leetcode.arraryList_2;

import java.util.Vector;

public class ValidSudoku {

	/**
	 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules
	 * http://sudoku.com.au/TheRules.aspx . The Sudoku board could be partially
	 * filled, where empty cells are filled with the character '.'.
	 */

	/**
	 * 1.Check rows 2.Check cols 3.check nine matirx
	 * O(n^2)
	 */
	static boolean isSudoKo(int[][] testArrary) {
		int[] testArr = new int[9];
		// check row
		for (int i = 0; i < 9; i++) {
			testArr = new int[9];
			testArr = testArrary[i];
			if (!check(testArr)) {
				return false;
			}
		}
		// checkt col
		for (int i = 0; i < 9; i++) {
			testArr = new int[9];
			for (int j = 0; j < 9; j++) {
				testArr[j] = testArrary[j][i];
			}
			if (!check(testArr)) {
				return false;
			}
		}
		// check nine matirx
		for (int i = 2; i < 9; i += 3) {
			for (int j = 2; j < 9; j += 3) {
				int k = 0;
				testArr = new int[9];
				for (int i1 = i; i1 > i - 3; i1--) {
					for (int j1 = j; j1 > j - 3; j1--) {
						testArr[k++] = testArrary[i1][j1];
					}
				}
				if (!check(testArr)) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean check(int[] testArr) {
		Vector<Integer> vector = new Vector<Integer>(10);
		int len = testArr.length;
		for (int i = 0; i < len; i++) {
			if (!vector.contains(testArr[i]) || testArr[i] == 0) {
				vector.add(testArr[i]);
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] testArrarys = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
				{ 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
				{ 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
		System.out.println(isSudoKo(testArrarys));
	}

}
