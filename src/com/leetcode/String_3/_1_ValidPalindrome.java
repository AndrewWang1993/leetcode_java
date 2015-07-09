package com.leetcode.String_3;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases. For example, ¡±A man, a plan, a
 * canal: Panama¡± is a palindrome. ¡±race a car¡± is not a palindrome. Note: Have
 * you consider that the string might be empty? This is a good question to ask
 * during an interview. For the purpose of this problem, we define empty string
 * as valid palindrome.
 *
 */

public class _1_ValidPalindrome {
	public static void main(String[] args) {
		new _1_ValidPalindrome().checkPalindrom("A man, a plan, a canal: Panama");
		new _1_ValidPalindrome().checkPalindrom("raCe A cAr");
	}

	private boolean checkPalindrom(String str) {
		if (str == null || str == "") {
			return true;
		}
		int len = str.length();
		if (len == 1) {
			return true;
		}
		str = toUpper(str);
		int i = 0;
		int j = len - 1;
		while (i < len && j >= 0) {
			while (str.charAt(i) < 'a' || str.charAt(i) > 'z') {
				i++;
			}
			while (str.charAt(j) < 'a' || str.charAt(j) > 'z') {
				j--;
			}
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}

		return true;
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

}
