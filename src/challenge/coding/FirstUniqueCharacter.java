package challenge.coding;

public class FirstUniqueCharacter {
	public static void main(String[] args) {
		FirstUniqueCharacter fuc = new FirstUniqueCharacter();
		String s = "loveleetcode";
		System.out.println(fuc.firstUniqChar(s));
	}

	public int firstUniqChar(String s) {
		int reducFactor = Integer.valueOf('a');
		boolean[] flagArray = new boolean[26];
		int[] flagIndexArray = new int[26];
		char[] cArray = s.toCharArray();
		for (int i = 0; i < cArray.length; i++) {
			char c = cArray[i];
			int intValOfChar = Integer.valueOf(c);
			flagArray[intValOfChar - reducFactor] = true;
			flagIndexArray[intValOfChar - reducFactor] += 1; 
		}
		for (int i = 0; i < cArray.length; i++) {
			char c = cArray[i];
			int intValOfChar = Integer.valueOf(c);
			if (flagIndexArray[intValOfChar - reducFactor] == 1) {
				return s.indexOf(c);
			}
		}
		return -1;
	}
}
