package com.practice;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
	public static void main(String[] args) {
		ZigZagConversion zzc = new ZigZagConversion();
		String s = "PAYPALISHIRING";
		int numRows = 3;
		System.out.println(zzc.convert(s, numRows));
	}
	
    public String convert(String s, int numRows) {
    	if (numRows == 1) {
    		return s;
    	}
    	List<StringBuilder> stringBuilderList = new ArrayList<StringBuilder>();
    	for (int i = 0; i < Math.min(numRows, s.length()); i++) {
    		stringBuilderList.add(new StringBuilder());
    	}
    	boolean verticalDescent = false;
    	int index = 0;
    	for (Character c: s.toCharArray()) {
    		stringBuilderList.get(index).append(c);
    		if (index == 0 || index == numRows - 1) {
    			verticalDescent = !verticalDescent;
    		}
    		index += verticalDescent ? 1 : -1;
    	}
    	StringBuilder returnStringBuilder = new StringBuilder();
    	for (StringBuilder sb : stringBuilderList) {
    		returnStringBuilder.append(sb);
    	}
    	return returnStringBuilder.toString();
    }
}
