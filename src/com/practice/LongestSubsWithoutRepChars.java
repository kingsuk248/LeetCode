package com.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubsWithoutRepChars {
	public static void main(String[] args) {
		LongestSubsWithoutRepChars app = new LongestSubsWithoutRepChars();
		//String s = "dvdf";
		//String s = "aab";
		String s = "aab";
		System.out.println(app.lengthOfLongestSubstring(s));
	}
	
	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		Set<Character> charSet = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				char ch = s.charAt(j);
				if (charSet.add(ch)) {
					maxLength = charSet.size() > maxLength ? charSet.size() : maxLength;
				} else {
					charSet.clear();
					break;
				}
			}
		}
		return maxLength;
	}
	
}
