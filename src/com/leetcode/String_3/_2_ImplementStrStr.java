package com.leetcode.String_3;

/**
 * Implement strStr(). Returns a pointer to the first occurrence of needle in
 * haystack, or null if needle is not part of haystack.
 *
 */

public class _2_ImplementStrStr {
	public static void main(String[] args) {
		String origin = "abc32ds324ds3cs";
		String match = "324";
		new _2_ImplementStrStr().toMatch(origin, match);
	}

	// BF O(m+n)
	private int toMatch(String origin, String match) {
		int len1 = origin.length();
		int len2 = match.length();
		if (len1 == 0 && len2 > 0) {
			return -1;
		}
		if (len1 < len2 || len2 == 0) {
			return -1;
		}
		int i = 0;
		int j = 0;
		while (i < len1) {
			if (origin.charAt(i) == match.charAt(j)) {
				i++;
				j++;
			} else {
				i++;
				i -= j;
				j = 0;
			}
			if (j == len2) {
				return i - j;
			}
		}
		return -1;
	}
	
	
	//KMP O(m+n)
	//TODO implemetn KMP
	private int KMP(String origin,String match){
		return 0;
		
	}

}
