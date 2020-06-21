package com.practice.medium;

import java.util.ArrayList;
import java.util.List;

public class StringToInteger {
	public static void main(String[] args) {
		StringToInteger sti = new StringToInteger();
		String str = "-000000000000000000000000000000000000000000000000001";
		//str = "20000000000000000000";
		//str = "9223372036854775808";
		//str = "words and 987";
		str = "-";
		str = "     +004500";
		str = "+";
		System.out.println(sti.myAtoi(str));
		// int spaceAscii = 32;
		// int minusAscii = 45;
		// int digitZeroAscii = 48;
		// int digitNineAscii = 57;
		// int plusAscii = 43;
	}

	public int myAtoi(String str) {
		if (str.equals("") || str.trim().equals("") || str == "" || str.trim() == "") {
			return 0;
		}

		try {
			str = String.valueOf(Long.parseLong(str));
		} catch (Exception e) {
			
		}
		boolean isNegative = false;
		boolean isExceptional = false;
		List<Character> characterList = new ArrayList<>();
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			int asciiVal = (int) c;
			if (!characterList.isEmpty() && (asciiVal < 48 || asciiVal > 57)) {
				break;
			}
			if (asciiVal != 32 && asciiVal != 45 && asciiVal != 43 && (asciiVal < 48 || asciiVal > 57)) {
				return 0;
			}
			if (asciiVal == 45) {
				isNegative = true;
			}
			if (asciiVal >= 48 && asciiVal <= 57) {
				characterList.add(c);
			} else {
				if (asciiVal == 43 && (i < (charArray.length - 1))
						&& ((int) (charArray[i + 1]) < 48 || (int) (charArray[i + 1]) > 57)) {
					break;
				}
				if (asciiVal == 45 && (i < (charArray.length - 1))
						&& ((int) (charArray[i + 1]) < 48 || (int) (charArray[i + 1]) > 57)) {
					break;
				}
				if (asciiVal != 32 && asciiVal != 45 && (asciiVal != 43)) {
					break;
				}
			}
		}
		StringBuilder builder = new StringBuilder();
		for (Character c : characterList) {
			builder.append(c);
		}
		// str = String.valueOf(Integer.valueOf(str));
		long longVal = 0;
		try {
			longVal = Long.parseLong(builder.toString());
		} catch (Exception e) {
			isExceptional = true;
		}
		if (isNegative) {
			longVal *= -1;
		}
		if (longVal > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (longVal < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		if (isExceptional) {
			if (!compare(builder.toString(), String.valueOf(Long.MAX_VALUE))) {
				if (builder.length() == 1) {
					return 0;
				}
				if (isNegative) {
					if (builder.length() > 1) {
						return Integer.MIN_VALUE;
					} else {
						return 0;
					}
				} else {
					return Integer.MAX_VALUE;
				}
			}
		}
		return (int)longVal;
	}
	
	private boolean compare(String intVal1, String intVal2) {
		if (intVal1.length() > intVal2.length()) {
			return false;
		} else if (intVal1.length() < intVal2.length()) {
			return true;
		} else {
			for (int i = 0; i < intVal1.length(); i++) {
				if (intVal1.charAt(i) > intVal2.charAt(i)) {
					return false;
				}
			}
		}
		return true;
		
	}
}
