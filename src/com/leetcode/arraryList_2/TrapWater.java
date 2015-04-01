package com.leetcode.arraryList_2;

public class TrapWater {
	/**
	 * Given n non-negative integers representing an elevation map where the
	 * width of each bar is 1, compute how much water it is able to trap after
	 * raining. For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 * 
	 */
	static private int calcuteWater(int[] testArray) {
		int len = testArray.length;
		int[] outPut = searchMax(testArray, 0, len);
		int mMaxPos = outPut[1];
		return getLeftWater(testArray, mMaxPos)+getRightWater(testArray, mMaxPos);
	}

	static private int getLeftWater(int[] testArray, int pos) {

		if (pos == 1 ||pos ==0 ) {
			return 0;
		}
		int thisMax = searchMax(testArray, 0, pos)[0];
		int thisPos = searchMax(testArray, 0, pos)[1];
		int thisWater = 0;
		for (int i = thisPos; i < pos; i++) {
			thisWater += (thisMax - testArray[i]);
		}
		return thisWater + getLeftWater(testArray, thisPos);
	}

	static private int getRightWater(int[] testArray, int pos) {
		int len = testArray.length;
		if (pos == len-1||pos==len-2)
			return 0;

		int thisMax = searchMax(testArray, pos+1, len)[0];
		int thisPos = searchMax(testArray, pos+1, len)[1];
		int thisWater = 0;
		for (int i = pos + 1; i < thisPos; i++) {
			thisWater += (thisMax - testArray[i]);
		}
		return thisWater + getRightWater(testArray, thisPos);
	}

	static private int[] searchMax(int[] testArray, int low, int high) {
		int max = Integer.MIN_VALUE;
		int pos = -1;
		for (int i = low; i < high; i++) {
			if (max <= testArray[i]) {
				max = testArray[i];
				pos = i;
			}
		}
		int[] outPut = new int[2];
		outPut[0] = max;
		outPut[1] = pos;
		return outPut;
	}

	public static void main(String[] args) {
		final int[] testArray = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(calcuteWater(testArray));
	}

}
