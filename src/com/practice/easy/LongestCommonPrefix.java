package com.practice.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		String output = new LongestCommonPrefix().longestCommonPrefix(strs);
		System.out.println(output);
	}

	public String longestCommonPrefix(String[] strs) {
		String[] strsSorted = sortStrings(strs);
		if (strsSorted.length > 0) {
			List<Character> commonPrefix = new ArrayList<>();
			String smallestString = strsSorted[0];
			for (int i = 0; i < smallestString.length(); i++) {
				char c = smallestString.charAt(i);
				for (String str : strsSorted) {
					if (str.charAt(i) != c) {
						return listOfCharsToString(commonPrefix);
					}
				}
				commonPrefix.add(c);
			}
			return listOfCharsToString(commonPrefix);
		} else {
			return "";
		}
	}

	private Comparator<String> LENGTH_COMPARATOR;

	private String[] sortStrings(String[] strs) {
		LENGTH_COMPARATOR = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length()) {
					return 1;
				} else if (o1.length() < o2.length()) {
					return -1;
				}
				return 0;
			}
		};
		Arrays.sort(strs, LENGTH_COMPARATOR);
		return strs;
	}

	private String listOfCharsToString(List<Character> chars) {
		StringBuilder builder = new StringBuilder();
		for (char ch : chars) {
			builder.append(ch);
		}
		return builder.toString();
	}
}
