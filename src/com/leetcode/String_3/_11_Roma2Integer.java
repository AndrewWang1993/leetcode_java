package com.leetcode.String_3;

import java.util.HashMap;

public class _11_Roma2Integer {
	/*
	 * Given a roman numeral, convert it to an integer. Input is guaranteed to
	 * be within the range from 1 to 3999.
	 */
 static HashMap<String, Integer> hashMap;
	public static void main(String[] args) {
		hashMap=new HashMap<>();
		hashMap.put("I", 1);
		hashMap.put("V", 5);
		hashMap.put("X", 10);
		hashMap.put("L", 50);
		String string="XIX";
		getInt(string);
	}
	private static void getInt(String s) {
		int pre=0,sum=0;
		int len=s.length();
		for(int i=0;i<len;i++){
			int cur=hashMap.get(String.valueOf(s.charAt(i)));
			if(pre<cur){
				sum=sum-pre+(cur-pre);
			}else {
				sum+=cur;
			}
			pre=cur;
		}
		System.out.println(sum);
		
	}
	
	
}
