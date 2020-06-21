package challenge.coding;

import java.util.List;
import java.util.stream.Collectors;

public class JewelsAndStones {
	public static void main(String[] args) {
		JewelsAndStones jas = new JewelsAndStones();
		String J = "z";
		String S = "ZZ";
		System.out.println(jas.numJewelsInStones(J, S));
	}
	
	public int numJewelsInStones(String J, String S) {
		List<Character> cList = J.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.toList());
		int num = 0;
		for (Character c : S.toCharArray()) {
			if (cList.contains(c)) {
				num++;
			}
		}
		return num;
	}
}
