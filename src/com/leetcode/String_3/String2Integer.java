package com.leetcode.String_3;

/**
 * Implement atoi to convert a string to an integer. Hint: Carefully consider
 * all possible input cases. If you want a challenge, please do not see below
 * and ask yourself what are the possible input cases. Notes: It is intended for
 * this problem to be specified vaguely (ie, no given input specs). You are
 * responsible to gather all the input requirements up front. Requirements for
 * atoi: The function first discards as many whitespace characters as necessary
 * until the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value. The
 * string can contain additional characters after those that form the integral
 * number, which are ignored and have no effect on the behavior of this
 * function. If the first sequence of non-whitespace characters in str is not a
 * valid integral number, or if no such sequence exists because either str is
 * empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 *
 */
public class String2Integer {

	// 1、去除空格，记住正负
	// 2、去除无关的英文字符
	// 3、支持八进制和十六进制，并作越界处理

	final int OCT = 8;
	final int DEC = 10;
	final int DEX = 16;

	int scale = 10;
	int flag = 1;

	public static void main(String[] args) {
		String str = "4521";
		String2Integer s2i = new String2Integer();
		str = s2i.RemoveSpace(str);
		s2i.checkSacle(str);
		str = s2i.toUpper(str);
		str = s2i.removeRedundancyChar(str);
		int i = s2i.getInteger(str);
	}

	private String RemoveSpace(String string) {
		StringBuilder sb = new StringBuilder();
		int len = string.length();
		if (len == 0) {
			return "";
		}
		for (int i = 0; i < len; i++) {
			if (string.charAt(i) != ' ') {
				sb.append(string.charAt(i));
			}
		}
		if (sb.charAt(0) == '-') {
			flag = -1;
			return sb.substring(1);
		}
		return sb.toString();
	}

	private String checkSacle(String string) {
		if (string.startsWith("0x") || string.startsWith("0X")) {
			scale = DEX;
			return string.substring(2);
		} else if (string.startsWith("0")) {
			scale = OCT;
			return string.substring(0);
		} else {
			scale = DEC;
			return string;
		}
	}

	private String toUpper(String string) {
		int len = string.length();
		char[] cs = string.toCharArray();
		for (int i = 0; i < len; i++) {
			if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
				cs[i] = (char) (string.charAt(i) + ('a' - 'A'));
			}
		}
		return String.valueOf(cs);
	}

	private String removeRedundancyChar(String str) {
		StringBuilder sb = new StringBuilder();
		int len = str.length();
		if (scale == DEC) {
			for (int i = 0; i < len; i++) {
				if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
					sb.append(str.charAt(i));
				}
			}
		} else if (scale == OCT) {
			for (int i = 0; i < len; i++) {
				if (str.charAt(i) >= '0' && str.charAt(i) <= '7') {
					sb.append(str.charAt(i));
				}
			}
		} else if (scale == DEX) {
			for (int i = 0; i < len; i++) {
				if ((str.charAt(i) >= '0' && str.charAt(i) <= '9')
						|| (str.charAt(i) >= 'a' && str.charAt(i) <= 'f')) {
					sb.append(str.charAt(i));
				}
			}
		}
		return sb.toString();
	}

	private int getInteger(String str) {
		int len = str.length();
		int mInt = 0;
		for (int i = 0; i < len; i++) {
			char c = str.charAt(len - i - 1);
			if (c > '9') {
				mInt += ((c - 'a') * ((int) Math.pow(
						scale, i)));
			} else {
				mInt += ((c - '0') * ((int) Math.pow(
						scale, i)));
			}

			// 越界检测
			if (mInt < 0 && flag == 1) {
				return Integer.MAX_VALUE;
			} else if (mInt < 0 && flag == -1) {
				return Integer.MIN_VALUE;
			}

		}
		return mInt;
	}
}
