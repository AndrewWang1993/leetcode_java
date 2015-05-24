package com.leetcode.List_2.ArrayList;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ThreeSum {
	/**
	 * Given an array S of n integers, are there elements a; b; c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero. Note: �? Elements in a triplet (a; b; c) must be in
	 * non-descending order. (ie, a  b  c) �? The solution set must not contain
	 * duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}. A
	 * solution set is: (-1, 0, 1) (-1, -1, 2)
	 */

	private static ArrayList<Integer[]> rawSolution(int[] testArray, int sum) {
		ArrayList<Integer[]> arrayList = new ArrayList<>();
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		int len = testArray.length;
		for (int i = 0; i < len; i++) {
			hashMap.put(testArray[i], i);
		}
		for (int i = 0; i < len; i++) {
			for (int j = 0; j != i && j < len; j++) {
				int target = sum - testArray[i] - testArray[j];
				if (hashMap.containsKey(target)) {
					Integer [] outputArray = { testArray[i], testArray[j], target };
			
					arrayList.add(outputArray);

				}
			}
		}

		return arrayList;

	}

	
	
	public static void main(String[] args) {
		int[] testArray = { 1, 3, 54, 4, -3, 345, 2, 52, -5 };
		Iterator<?> iterator = rawSolution(testArray, 0).iterator();
		while (iterator.hasNext()) {
			Integer[] mArray = (Integer[]) iterator.next();
			int len = mArray.length;
			for (int i = 0; i < len; i++) {
				System.out.print(mArray[i] + "  ");
			}
			System.out.println();
		}
	}

}
