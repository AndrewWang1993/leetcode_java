package com.leetcode.arraryList_2;

public class GrayCode {
	/**
	 * The gray code is a binary numeral system where two successive values
	 * differ in only one bit. Given a non-negative integer n representing the
	 * total number of bits in the code, print the sequence of gray code. A gray
	 * code sequence must begin with 0. For example, given n = 2, return
	 * [0,1,3,2]. Its gray code sequence is: 00 - 0 01 - 1 11 - 3 10 - 2 Note: •
	 * For a given n, a gray code sequence is not uniquely defined. • For
	 * example, [0,2,3,1] is also a valid gray code sequence according to the
	 * above definition. • For now, the judge is able to judge based on one
	 * instance of gray code sequence. Sorry about that.
	 * 
	 * 例如，将自然二进制码1001，转换为格雷码的过程是：保留最 高位；然后将第1 位的1 和第2 位的0 异或，得到1，作为格雷码的第2 位；将第2
	 * 位的0 和第3 位 的0 异或，得到0，作为格雷码的第3 位；将第3 位的0 和第4 位的1 异或，得到1，作为格雷码的 第4
	 * 位，最终，格雷码为1101。
	 * 
	 * 例如，将格雷码1000转换为自然二进制码的过程是：保留最高 位1，作为自然二进制码的最高位；然后将自然二进制码的第1 位1 和格雷码的第2 位0
	 * 异或，得 到1，作为自然二进制码的第2 位；将自然二进制码的第2 位1 和格雷码的第3 位0 异或，得到1， 作为自然二进制码的第3
	 * 位；将自然二进制码的第3 位1 和格雷码的第4 位0 异或，得到1，作为 自然二进制码的第4 位，最终，自然二进制码为1111。
	 * 
	 */

	static int getGrey(int testInt) {
		StringBuilder sb, sb2;
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		sb.append(String.valueOf(testInt));
		int len = sb.length();
		sb2.append(sb.charAt(0));
		for (int i = 1; i < len; i++) {
			int t = Integer.valueOf(sb.charAt(i))
					^ Integer.valueOf(sb.charAt(i - 1));
			sb2.append(t);
		}
		return Integer.valueOf(sb2.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testInt = 110101;
		System.out.println(getGrey(testInt));
	}

}
