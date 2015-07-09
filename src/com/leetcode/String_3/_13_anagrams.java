package com.leetcode.String_3;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class _13_anagrams {
	/*
	 * Given an array of strings, return all groups of strings that are
	 * anagrams. Note: All inputs will be in lower-case. 分析
	 * Anagram（回文构词法）是指打乱字母顺序从而得到新的单词，比如"dormitory" 打乱字母顺 序会变成"dirty room"
	 * ，"tea" 会变成"eat"。
	 */
	public static void main(String[] args) {
		String[] strs = { "dormitory", "zhang","dirty room", "dtyirroom", "roomdtyri",
				"tea", "eat" ,"angz","zhagn","azhng"};
		new _13_anagrams().getGroup(strs);
	}

	public void getGroup(String[] strs) {
		int len = strs.length;
		ArrayList<String> list = new ArrayList();
		HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
		for (int i = 0; i < len; i++) {
			String str = strs[i];
			Integer[] ints = getIntArray(str);
			list.add(ints2String(ints));
		}
		for (int i = 0; i < len; i++) {
			String s = list.get(i);
			if (!hashMap.containsKey(s)) {
				ArrayList<Integer> arrayList = new ArrayList<>();
				arrayList.add(i);
				hashMap.put(s, arrayList);
			} else {
				ArrayList<Integer> arrayList = hashMap.get(s);
				arrayList.add(i);
				hashMap.replace(s, arrayList);
			}
		}
		Collection<ArrayList<Integer>> l =  hashMap.values();
		ArrayList<ArrayList<Integer>> al=new ArrayList<>(l);
		Collections.reverse(al);
        Iterator<ArrayList<Integer>> iter1=al.iterator();
        while(iter1.hasNext()){
        	ArrayList<Integer> a=iter1.next();
        	int size=a.size();
        	for(int i=0;i<size;i++){
        		System.out.print(strs[a.get(i)]+" ");
        	}
        	System.out.println();
        }
	}

	public Integer[] getIntArray(String str) {
		Integer[] ints = new Integer[26];
		for (int i = 0; i < 26; i++) {
			ints[i] = 0;
		}
		int strlen = str.length();
		for (int j = 0; j < strlen; j++) {
			int pos = str.charAt(j) - 'a';
			if (pos < 26 && pos >= 0) {
				ints[pos]++;
			}
		}
		return ints;
	}

	public String ints2String(Integer[] ints) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (ints[i] != 0) {
				char c = (char) ('a' + i);
				sb.append(ints[i] + "" + String.valueOf(c));
			}
		}
		return sb.toString();

	}

}
