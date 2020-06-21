package com.practice;

/**
 * TOSOLVE
 * @author kisarkar
 *
 */
public class LongestPalindromeSubstring {
	
	public static void main(String[] args) {
		LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
		String str = "cbbd";
		System.out.println(lps.longestPalindrome(str));
		
	}
	
	private String longestPalindrome(String str) {
		if (str.trim() == "") {
			return "";
		}
		
		return bruteForce(str);
	}
	
	private String bruteForce(String str) {
		int maxLength = 0;
		String longestPSubstr = "";
		for (int i = 0; i < str.length(); i++) {
			for (int j = str.length(); j > i; j--) {
				String subString = str.substring(i, j);
				if (isPalindrome(subString)) {
					if (subString.length() > maxLength) {
						longestPSubstr = subString;
						maxLength = subString.length();
					}
				}
			}
		}
		return longestPSubstr;
	}
	
	private static boolean isPalindrome(String subStr) {
		for (int i = 0; i < subStr.length() / 2; i++) {
			if (subStr.charAt(i) != subStr.charAt(subStr.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

}
