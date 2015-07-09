package com.leetcode.String_3;

public class _4_AddTwoBinary {
	public static void main(String[] args) {
		String bin1 = "    11";
		String bin2 = "1";
		System.out.println(new _4_AddTwoBinary().addTwobinary(bin1, bin2));
	}

	private String addTwobinary(String bin1, String bin2) {
		bin1=bin1.trim();
		bin2=bin2.trim();
		if (bin1.equals("") && bin2.equals("")) {
			return null;
		}
		if (bin1.equals("")) {
			return bin2;
		} else if (bin2.equals("")) {
			return bin1;
		}
		int len = bin1.length() > bin2.length() ? bin1.length() : bin2.length();
		StringBuilder sb;
		if (len == bin1.length()) {
			sb = new StringBuilder(bin2);
			for (int i = 0; i < len - bin2.length(); i++) {
				sb.insert(0, '0');
			}
			bin2 = sb.toString();
		} else if (len == bin2.length()) {
			sb = new StringBuilder(bin1);
			for (int i = 0; i < len - bin1.length(); i++) {
				sb.insert(0, '0');
			}
			bin1 = sb.toString();
		}
		sb = new StringBuilder();
		// ÊÇ·ñ½øÎ»
		int isPlus = 0;
		for (int i = len - 1; i >= 0; i--) {
			int sum = bin1.charAt(i) - '0' + bin2.charAt(i) - '0' + isPlus;
			if (sum == 2) {
				isPlus = 1;
				sb.append("0");
			} else if (sum == 3) {
				isPlus = 1;
				sb.append("1");
			} else {
				isPlus = 0;
				sb.append(sum);
			}
		}
		if (isPlus == 1) {
			sb.append("1");
		}
		return sb.reverse().toString();

	}

}
