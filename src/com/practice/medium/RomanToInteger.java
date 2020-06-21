package com.practice.medium;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public static void main(String[] args) {
		RomanToInteger rti = new RomanToInteger();
		String romanNum = "DCXXI";
		int intNum = rti.romanToInt(romanNum);
		System.out.println(intNum);
	}

	private Map<String, Integer> unusualCharactersMap;
	private Map<String, Integer> romanToIntCharactersMap;

	public int romanToInt(String s) {
		int convertedInt = 0;
		unusualCharactersMap = new HashMap<>();
		romanToIntCharactersMap = new HashMap<>();
		addRomanIntLiteralForUnusual(unusualCharactersMap);
		addRomanIntLiteralForGeneric(romanToIntCharactersMap);
		if (unusualCharactersMap.keySet().contains(s)) {
			return unusualCharactersMap.get(s);
		} else if (romanToIntCharactersMap.keySet().contains(s)) {
			return romanToIntCharactersMap.get(s);
		}
		for (int i = 0; i < s.length(); i++) {
			String nextTwoChars = getNextTwoChars(s, s.indexOf(s.charAt(i)));
			if (unusualCharactersMap.containsKey(nextTwoChars)) {
				convertedInt += unusualCharactersMap.get(nextTwoChars);
				i++;
			} else {
				convertedInt += romanToIntCharactersMap.get(s.charAt(i) + "");
			}
		}
		return convertedInt;
	}

	private String getNextTwoChars(String s, int index) {
		String nextTwoChars = "";
		if (index + 2 > s.length()) {
			nextTwoChars = s.substring(index);
		} else {
			nextTwoChars = s.substring(index, index + 2);
		}
		return nextTwoChars;
	}

	private void addRomanIntLiteralForUnusual(Map<String, Integer> romanToIntCharactersMap) {
		unusualCharactersMap.put("IV", 4);
		unusualCharactersMap.put("IX", 9);
		unusualCharactersMap.put("XL", 40);
		unusualCharactersMap.put("XC", 90);
		unusualCharactersMap.put("CD", 400);
		unusualCharactersMap.put("CM", 900);
	}

	private void addRomanIntLiteralForGeneric(Map<String, Integer> romanToIntCharactersMap) {
		romanToIntCharactersMap.put("I", 1);
		romanToIntCharactersMap.put("V", 5);
		romanToIntCharactersMap.put("X", 10);
		romanToIntCharactersMap.put("L", 50);
		romanToIntCharactersMap.put("C", 100);
		romanToIntCharactersMap.put("D", 500);
		romanToIntCharactersMap.put("M", 1000);
	}
}
