package com.leetcode.arraryList_2;

public class TrapWater {
	/**
	 * Given n non-negative integers representing an elevation map where the
	 * width of each bar is 1, compute how much water it is able to trap after
	 * raining. For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 * 
	 * @param args
	 */
	static private int calcuteWater(int[] testArray) {
		int len = testArray.length;
		int[] outPut = searchMax(testArray, 0, len);
		int mMax = outPut[0];
		int mMaxPos = outPut[1];
		return 0;
	}

	static private int getWater(int []testArray,int pos, int mMax) {
		int len = testArray.length;
		if (pos > mMax) {
           int thisMax=searchMax(testArray, pos, len)[0];
           int thisPos=searchMax(testArray, pos, len)[1];
           int thisWater=0;
           for(int i=pos+1;i<thisPos;i++){
        	   thisWater+=thisMax-testArray[i];
           }
           return thisWater+getWater(testArray, thisPos, mMax);
		}
           else {
			return 0;
		}
	
	}

	static private int[] searchMax(int[] testArray, int low, int high) {
		int max = Integer.MAX_VALUE;
		int pos = -1;
		for (int i = low; i < high; i++) {
			if (max < testArray[i]) {
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
