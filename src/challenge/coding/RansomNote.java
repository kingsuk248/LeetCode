package challenge.coding;

import java.util.List;
import java.util.stream.Collectors;

public class RansomNote {
	public static void main(String[] args) {
		RansomNote rn = new RansomNote();
		String ransomNote = "aa";
		String magazine = "aab";
		System.out.println(rn.canConstruct(ransomNote, magazine));
	}
	
	public boolean canConstruct(String ransomNote, String magazine) {
		boolean canConstruct = true;
		List<Character> mArray = magazine.chars()
				.mapToObj(c -> (char)c)
				.collect(Collectors.toList());
		for (Character c : ransomNote.toCharArray()) {
			if (!mArray.remove(c)) {
				return false;
			}
		}
		return canConstruct;
	}
}
