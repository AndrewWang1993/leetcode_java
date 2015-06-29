package com.leetcode.String_3;

import java.util.Iterator;
import java.util.Stack;

/*
 * Given an absolute path for a file (Unix-style), simplify it.
 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 */
public class SimplePath {
	public static void main(String[] args) {
		String path = "/home/./boy/./../../co/";
		String path1 = "/home/.//boy////./../../co/";
		String path2 = "/../";
		System.out.println(new SimplePath().simplePaht(path1));
	}

	private String simplePaht(String str) {
		int i = 0, j = 0;
		Stack<String> stack = new Stack<>();
		int len = str.length();
		if (len == 0) {
			return "";
		}
		for (int p = 0; p < len; p++) {
			if (str.charAt(p) == '/') {
				i = j;
				j = p;
				String word = str.substring(i, j);
				if (word.equals("")) {
					i++;
					j++;
					continue;
				} else if (word.equals("/")) {
					i = j;
					j = p;
					continue;
				} else if (word.equals(".")) {
					stack.pop();
				} else if (word.equals("..")) {
					stack.clear();
				} else {
					stack.add(word);
				}
				j++;
			}
		}
		StringBuilder sb = new StringBuilder();
		Iterator<String> iter = stack.iterator();
		while (iter.hasNext()) {
			sb.append("/" + iter.next());
		}
		if (sb.toString() == ""||sb.toString()==null||sb.toString().length()==0) {
			return "/";
		} else {
			return sb.toString();
		}
	}
}
