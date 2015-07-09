package com.leetcode.String_3;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * Implement regular expression matching with support for '.' and '*'.
 '.' Matches any single character. '*' Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).
 */
public class _6_RegularMatch {

	public static void main(String[] args) {
		String mstr = "aaaaabbbbcd";
		String patt = "a*a*abbbb.d";
		String patt1 = "a*a*b*b.d";

		String mstr2 = "aaadesabbabad1";
		String patt2 = ".*abad."; // greedy mode
		String patt3 = ".*abad.*"; // greedy mode
		System.out.println(new _6_RegularMatch().findMatch(mstr2, patt3));
	}

	/**
	 * 
	 * @param str
	 *            The substring remain to match
	 * @param patt
	 *            The partten
	 * @return
	 */
	private boolean findMatch(String str, String patt) {
		return findMatch(str, patt, ' ', 0);
	}

	/**
	 * use recurrence to match string
	 * 
	 * @param str
	 *            The substring remain to match
	 * @param patt
	 *            The partten
	 * @param c
	 *            "*" matched char
	 * @param num
	 *            Number of char c(below) has been matched
	 * @return
	 */
	private boolean findMatch(String str, String patt, char c, int num) {
		if (patt.equals(str)) {
			return true;
		}
		if (!patt.contains("*") && !patt.contains(".") && !patt.equals(str)
				&& num == 0) {
			return false;
		}
		if (str.length() == 0 && patt.length() == 0) {
			return true;
		}
		if (patt.indexOf('*') != 1) {
			if (patt.indexOf(".") == 0) {
				if (num > 1) {
					return findMatch(str.substring(1), patt.substring(1), c,
							num - 1);
				} else {
					return findMatch(str.substring(1), patt.substring(1), ' ',
							0);
				}
			} else if (patt.charAt(0) == c) {
				if (num > 1) {
					return findMatch(str, patt.substring(1), c, num - 1);
				} else {
					return findMatch(str, patt.substring(1), ' ', 0);
				}
			} else if (patt.charAt(0) == str.charAt(0)) {
				return findMatch(str.substring(1), patt.substring(1), ' ', 0);
			}
		} else {
			char c1 = patt.charAt(0);
			if (c1 == '.') {
				if (str.length() == 1) {
					return true;
				}
				char c2 = patt.charAt(2);
				boolean isContainStart = patt.substring(2).contains("*");
				if (!isContainStart) {
					int index2 = findCharFromTail(str, c2, patt.length() - 2);
					return findMatch(str.substring(index2), patt.substring(2),
							' ', 0);
				} else {
					return tryAndBack(str, patt.substring(2));
				}
			}
			int count = getCount(str, c1);
			if (c1 == c) {
				return findMatch(str, patt.substring(2), c, num);
			}
			if (count > 0) {
				return findMatch(str.substring(count), patt.substring(2), c1,
						count);
			} else {
				return findMatch(str, patt.substring(2), ' ', 0);
			}
		}
		return false;
	}

	// Coping this situation
	// String mstr2 = "aaaaabadesscsabbabad1";
	// String patt3 = ".*abad.*"; // greedy mode
	// String patt3 = ".*abad1*"; // greedy mode
	private boolean tryAndBack(String str, String patt) {
		char c4 = patt.charAt(0);
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c4) {
				al.add(i);
			}
		}
		Iterator<Integer> it = al.iterator();
		while (it.hasNext()) {
			int i = (int) it.next();
			String str4 = str.substring(i);
			if (findMatch(str4, patt)) {
				return true;
			}
		}
		return false;
	}

	private int getCount(String str, char c1) {
		int len = str.length();
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == c1) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	private int findCharFromTail(String str, char c, int pattLen) {
		int strlen = str.length();
		if (pattLen < str.length()) {
			for (int i = strlen - pattLen; i >= 0; i--) {
				if (c == str.charAt(i)) {
					return i;
				}
			}
		}
		return -1;
	}

}
