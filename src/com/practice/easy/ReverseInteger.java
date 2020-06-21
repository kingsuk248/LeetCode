package com.practice.easy;

public class ReverseInteger {
	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		int x = -123;
		ri.reverse(x);
	}
	
	public int reverse(int x) {
		boolean isNegative = false;
		String intString = String.valueOf(x);
		if (x < 0) {
			isNegative = true;
			intString = intString.substring(1, intString.length());
		}
		char[] revCharArray = new char[intString.length()];
		for (int i = 0; i < intString.length(); i++) {
			revCharArray[i] = intString.charAt(intString.length() - 1 - i);
		}
		String returnString = String.valueOf(revCharArray);
		int y = 0;
		try {
			y = Integer.valueOf(returnString);
		} catch (Exception e) {
			return 0;
		}
		
		if (isNegative) {
			y *= -1;
		}
		return y;
	}
}
