package challenge.coding;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		int[] nums = { 2,2,1,1,1,2,2 };
		System.out.println(me.majorityElement(nums));
	}

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int i : nums) {
			if (countMap.get(i) == null) {
				countMap.put(i, 1);
			} else {
				countMap.put(i, countMap.get(i) + 1);
			}
		}
		int l = nums.length;
		for (Map.Entry<Integer, Integer> e : countMap.entrySet()) {
			if (e.getValue() > l / 2) {
				return e.getKey();
			}
		}
		return 0;
	}
}
