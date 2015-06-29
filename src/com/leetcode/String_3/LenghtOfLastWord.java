package com.leetcode.String_3;

/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length
 of last word in the string.
 If the last word does not exist, return 0.
 Note: A word is defined as a character sequence consists of non-space characters only.
 For example, Given s = "Hello World", return 5.
 */
public class LenghtOfLastWord {
public static void main(String[] args) {
	String str="Hellow word it";
	System.out.println(new LenghtOfLastWord().getLastWordLength(str));
}
private int getLastWordLength(String str) {
	int len=str.length();
	if(len==0){
		return 0;
	}
	int count=0;
	for(int i=len-1;i>=0;i--){
		if(str.charAt(i)!=' '){
			count++;
		}else {
			break;
		}
	}
	return count;
	
}
}
