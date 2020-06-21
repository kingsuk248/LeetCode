package com.practice.easy;

public class PalindromeNumber {
	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		int x = 2312332;
		System.out.println(pn.isPalindrome(x));
	}

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		long multipleOf10 = 10;
		int placeValue = 1;
		while (x % multipleOf10 != x) {
			multipleOf10 *= 10;
			placeValue++;
		}
		multipleOf10 /= 10;
		for (int i = 0; i < placeValue / 2; i++) {
			long right = (x / multipleOf10) % 10;
			long left = (x % ((long)Math.pow(10, i+1)));
			if (i > 0) {
				left = left / (long)Math.pow(10, i);
			}
			if (right - left != 0) {
				return false;
			}
			multipleOf10 /= 10;
		}
		return true;
	}

	public boolean isPalindromeAfterStringConversion(int x) {
		if (x < 0) {
			return false;
		}
		String str = String.valueOf(x);
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
