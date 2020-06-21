package com.practice.medium;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
	public static void main(String[] args) {
		IntegerToRoman itr = new IntegerToRoman();
		int num = 1994;
		String romanNumber = itr.intToRoman(num);
		System.out.println(romanNumber);
	}

	private Map<Integer, String> intRomanLiteralMap;
	
	public String intToRoman(int num) {
		intRomanLiteralMap = new HashMap<>();
		addIntRomanLiteral(intRomanLiteralMap);
		StringBuilder builder = new StringBuilder();
		if (num / 1000 >= 1) {
			//Number in 1000es
			for (int x = 1000; x >= 1; x /= 10) {
				convertSingleDigitFromPlaceValue(num, x, builder);
				num %= x;
			}
		} else if (num / 100 >= 1) {
			//Number in 100es
			for (int x = 100; x >= 1; x /= 10) {
				convertSingleDigitFromPlaceValue(num, x, builder);
				num %= x;
			}
		} else if (num / 10 >= 1) {
			//Number in 10es
			for (int x = 10; x >= 1; x /= 10) {
				convertSingleDigitFromPlaceValue(num, x, builder);
				num %= x;
			}
		} else {
			//Number in units
			convertSingleDigitFromPlaceValue(num, 1, builder);
		}
		return builder.toString();
	}
	
	private String convertSingleDigitFromPlaceValue(int digit, int placeValue, StringBuilder builder) {
		String singleDigitToRoman = null;
		int faceValue = digit / placeValue;
		if (faceValue == 5) {
			builder.append(intRomanLiteralMap.get(5 * placeValue));
		} else if (faceValue < 4) {
			for (int i = 0; i < faceValue; i++) {
				builder.append(intRomanLiteralMap.get(1 * placeValue));
			}
		} else if ((faceValue + 1) % 5 == 0) { // Digit is 4 or 9
			builder.append(intRomanLiteralMap.get(1 * placeValue)).append(intRomanLiteralMap.get((faceValue + 1) * placeValue));
		} else if (faceValue > 5) {
			builder.append(intRomanLiteralMap.get(5 * placeValue));
			for (int i = 5; i < faceValue; i++) {
				builder.append(intRomanLiteralMap.get(1 * placeValue));
			}
		}
		singleDigitToRoman = builder.toString();
		return singleDigitToRoman;
	}
	
	private void addIntRomanLiteral(Map<Integer, String> intRomanLiteralMap) {
		intRomanLiteralMap.put(1, "I");
		intRomanLiteralMap.put(5, "V");
		intRomanLiteralMap.put(10, "X");
		intRomanLiteralMap.put(50, "L");
		intRomanLiteralMap.put(100, "C");
		intRomanLiteralMap.put(500, "D");
		intRomanLiteralMap.put(1000, "M");
	}
}
