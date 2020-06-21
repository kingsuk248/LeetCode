package challenge.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortCharactersByFrequency {
	public static void main(String[] args) {
		String s = "";
		SortCharactersByFrequency scbf = new SortCharactersByFrequency();
		System.out.println(scbf.frequencySort(s));
	}

	public String frequencySort(String s) {
		if (s.length() == 0) {
			return "";
		}
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		List<CharFreq> charList = new ArrayList<>();
		char prevChar = chars[0];
		CharFreq cf = new CharFreq();
		cf.ch = prevChar;
		cf.freq = 1;
		charList.add(cf);
		for (int i = 1; i < chars.length; i++) {
			if (prevChar == chars[i]) {
				CharFreq cfE = charList.get(charList.size() - 1);
				cfE.freq++;
			} else {
				CharFreq cfNew = new CharFreq();
				cfNew.ch = chars[i];
				cfNew.freq = 1;
				charList.add(cfNew);
			}
			prevChar = chars[i];

		}
		Collections.sort(charList, (o1, o2) -> {
			if (o1.freq < o2.freq) {
				return 1;
			} else if (o1.freq > o2.freq) {
				return -1;
			}
			return 0;
		});
		StringBuilder builder = new StringBuilder();
		for (CharFreq chfr : charList) {
			for (int i = 0; i < chfr.freq; i++) {
				builder.append(chfr.ch);
			}
		}
		return builder.toString();
	}

	private static class CharFreq {
		char ch;
		int freq;
	}
}
