package com.leetcode.List_2.ArrayList;

public class PlusOne {
	/**
	 * Given a number represented as an array of digits, plus one to the number.
	 */

	static public String plusOneNum(String str1, String str2) {

		int len1 = str1.length();
		int len2 = str2.length();
		int num1, num2, sum;
		StringBuilder sb = new StringBuilder();
		boolean carry = false;
		while (len1 != 0 && len2 != 0) {
			len1--;
			len2--;
			num1 = str1.charAt(len1) - '0';
			num2 = str2.charAt(len2) - '0';
			sum = num1 + num2;
			if (carry) {
				sum++;
				carry = false;
			}
			if (sum > 9) {
				sum %= 10;
				carry = true;
			}

			sb.append((char) (sum + '0'));
		}
		if (len1 == 0 && len2 == 0) {
			sb.append('1');
		}
		while (--len1 >= 0) {
			if (carry) {
				sum = str1.charAt(len1) - '0' + 1;
				carry = false;
				if (sum > 9) {
					sum %= 10;
					if(len1==0){
						sb.append((char) (sum + '0'));
						sb.append((char) ('1'));	
						break;
					}
					carry = true;
				}
				sb.append((char) (sum + '0'));
			} else {
				sb.append(str1.charAt(len1));
			}
		}
		while (--len2 >= 0) {

			if (carry) {
				sum = str2.charAt(len2) - '0' + 1;
				carry = false;
				if (sum > 9) {
					sum %= 10;
					if(len2==0){
						sb.append((char) (sum + '0'));
						sb.append((char) ('1'));	
						break;
					}
					carry = true;
				}
				sb.append((char) sum + '0');
			} else {
				sb.append(str2.charAt(len2));
			}
		}

		return sb.reverse().toString();

	}

	public static void main(String[] args) {
		String numArray1 =      "88";
		String numArray2 = "1111111";
		System.out.println(plusOneNum(numArray1, numArray2));
	}

}
