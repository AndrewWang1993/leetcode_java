package com.leetcode.arraryList_2;

public class RotateImage {
	/**
	 * You are given an n*n 2D matrix representing an image. Rotate the image by
	 * 90 degrees (clockwise). Follow up: Could you do this in-place?
	 */

	@SuppressWarnings("unused")
	private static void leftRightFlip(int[][] testArray2) {
		int r = testArray2.length;
		int c = testArray2[0].length;
		if (r != c) {
			System.out.println("error matrix");
		}
		int[][] transMatrix = new int[c][r];
		for (int i = r - 1; i >= 0; i--) {
			transMatrix[r - i - 1][i] = 1;
		}
		getMutil(testArray2, transMatrix);
	}

	private static void upBelowFlip(int[][] testArray2) {
		int r = testArray2.length;
		int c = testArray2[0].length;
		if (r != c) {
			System.out.println("error matrix");
		}
		int[][] transMatrix = new int[c][r];
		for (int i = r - 1; i >= 0; i--) {
			transMatrix[r - i - 1][i] = 1;
		}
		getMutil(transMatrix, testArray2);
	}

	private static int [][] leftTopAndrightBelowFlip(int[][] testArray2) {
		int r = testArray2.length;
		int c = testArray2[0].length;
		if (r != c) {
			System.out.println("error matrix");
		}
		int tmp = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c && j < (c - i - 1); j++) {
				tmp = testArray2[i][j];
				testArray2[i][j] = testArray2[r - 1 - j][r - 1 - i];
				testArray2[r - 1 - j][r - 1 - i] = tmp;
			}
		}
//		for (int i = 0; i < r; i++) {
//			for (int j = 0; j < c; j++) {
//				System.out.print(testArray2[i][j] + " ");
//			}
//			System.out.println();
//		}
		return testArray2;
	}

	private static void rotate90Degree(int[][] testArray1) {
		upBelowFlip(leftTopAndrightBelowFlip(testArray1));
	}

	private static void getMutil(int[][] testArray1, int[][] testArray2) {
		// TODO Auto-generated method stub
		if (testArray1[0].length != testArray1.length) {
			System.out.println("Inpute error");
			return;
		}
		int r = testArray1.length;
		int c = testArray2[0].length;
		int x = testArray2.length;
		int tmp = 0;
		int[][] resultArray = new int[r][c];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				for (int k = 0; k < x; k++) {
					tmp += testArray1[i][k] * testArray2[k][j];
				}
				resultArray[i][j] = tmp;
				tmp = 0;
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(resultArray[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] testArray1 = { { 2, 5, 1 }, { 1, 4, 2 }, { 5, 2, 7 } };

		int[][] testArray2 = { { 3, 4, 1 },
			                 	{ 2, 5, 7 }, 
			                 	{ 6, 9, 8 } };
		// getMutil(testArray1, testArray2);
		// System.out.println();
		 System.out.println("testArray1rotate90Degree");
		 rotate90Degree(testArray1);
		// System.out.println("leftRightFlip");
		// leftRightFlip(testArray2);
		// System.out.println("upBelowFlip");
		// upBelowFlip(testArray2);
		// System.out.println("leftTopAndrightBelowFlip");
		// leftTopAndrightBelowFlip(testArray2);
		 System.out.println("testArray2rotate90Degree");
		 rotate90Degree(testArray2);
	}

}
