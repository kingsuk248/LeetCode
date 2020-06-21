package com.practice.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber app = new LetterCombinationsofaPhoneNumber();
		String digits = "2";
		System.out.println(app.letterCombinations(digits));
	}

	Map<Integer, String> numLetterMap = new HashMap<>();

	public List<String> letterCombinations(String digits) {
		List<String> permutationsList = new ArrayList<>();
		try {
			digits = String.valueOf(Integer.parseInt(digits));
		} catch (Exception e) {
			return permutationsList;
		}
		constructLetterMap();
		if (digits.indexOf('1') != -1) {
			return permutationsList;
		} else if (numLetterMap.containsKey(Integer.valueOf(digits))) {
			String valString = numLetterMap.get(Integer.valueOf(digits));
			for (char ch : valString.toCharArray()) {
				permutationsList.add(String.valueOf(ch));
			}
		} else {
			int firstDigit = Integer.parseInt(String.valueOf(digits.charAt(0)));
			int secondDigit = Integer.parseInt(String.valueOf(digits.charAt(1)));
			List<String> initialPermList = constructInitialPermList(numLetterMap.get(firstDigit),
					numLetterMap.get(secondDigit));
			if (digits.length() == 2) {
				return initialPermList;
			}
			permutationsList = initialPermList;
			for (int i = 2; i < digits.length(); i++) {
				permutationsList = constructAppendedPermutation(permutationsList, numLetterMap.get(Integer.parseInt(String.valueOf(digits.charAt(i)))));
			}
		}
		return permutationsList;
	}

	private List<String> constructInitialPermList(String str1, String str2) {
		List<String> strNewList = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		for (char s1 : str1.toCharArray()) {
			for (char s2 : str2.toCharArray()) {
				builder.append(s1).append(s2);
				strNewList.add(builder.toString());
				builder.setLength(0);
			}
		}
		return strNewList;

	}

	private List<String> constructAppendedPermutation(List<String> strList, String str) {
		List<String> strNewList = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		for (String s : strList) {
			for (char ch : str.toCharArray()) {
				builder.append(s).append(ch);
				strNewList.add(builder.toString());
				builder.setLength(0);
			}
		}
		return strNewList;
	}

	private void constructLetterMap() {
		numLetterMap.put(2, "abc");
		numLetterMap.put(3, "def");
		numLetterMap.put(4, "ghi");
		numLetterMap.put(5, "jkl");
		numLetterMap.put(6, "mno");
		numLetterMap.put(7, "pqrs");
		numLetterMap.put(8, "tuv");
		numLetterMap.put(9, "wxyz");
	}

}
