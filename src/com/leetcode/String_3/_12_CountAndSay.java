package com.leetcode.String_3;

public class _12_CountAndSay {
	/*
	 * The count-and-say sequence is the sequence of integers beginning as
	 * follows: 1, 11, 21, 1211, 111221, ... 1 is read off as "one 1" or 11. 11
	 * is read off as "two 1s" or 21. 21 is read off as "one 2", then "one 1" or
	 * 1211. Given an integer n, generate the nth sequence. Note: The sequence
	 * of integers will be represented as a string.
	 */
	public static void main(String[] args) {
		String str = "1";
		System.out.println(str);
		for (int i = 0; i < 10; i++) {
			str = new _12_CountAndSay().getCountAndSay(str);
			System.out.println(str);
		}
	}

	public String getCountAndSay(String str) {
		StringBuilder sb = new StringBuilder();
		int len = str.length();
		int count = 0, tmp = -1, i = 0, addNumCount = 0;
		while (i < len) {
			if (!(tmp == str.charAt(i) - '0')) {
				if (tmp < 0) {
					tmp = str.charAt(i++) - '0';
					count++;
					continue;
				}
//				sb.insert(i - count + addNumCount, count + "");
				sb.append(count + ""+tmp);
				addNumCount++;
				count = 1;
				tmp = str.charAt(i++) - '0';
			} else {
				count++;
				i++;
			}
		}
//			sb.insert(i - count + addNumCount, count + "");
		sb.append(count + ""+tmp);
		return sb.toString();
	}
}
