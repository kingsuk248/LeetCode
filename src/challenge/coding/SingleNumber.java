package challenge.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
	public static void main(String[] args) {
		int[] input1 = { 2, 2, 1 }; // 1
		int[] input2 = { 4, 1, 2, 1, 2 }; // 2
		hashMapMethod(input2);
		arraySortMethod(input1);
	}

	private static void arraySortMethod(int[] nums) {
		SingleNumber sn = new SingleNumber();
		System.out.println(sn.singleNumberM2(nums));
	}

	public int singleNumberM2(int[] nums) {
		Arrays.sort(nums);
		if (nums.length == 1) {
			return nums[0];
		}
		for (int i = 0; i < nums.length / 2; i++) {
			if (nums[i * 2] != nums[i * 2 + 1]) {
				return nums[i * 2];
			}
			if (nums[(i + 1) * 2] == nums.length - 1) {
				return nums[(i + 1) * 2];
			}
		}
		return 0;
	}

	private static void hashMapMethod(int[] nums) {
		SingleNumber sn = new SingleNumber();
		System.out.println(sn.singleNumber(nums));
	}

	public int singleNumber(int[] nums) {
		Map<Integer, Integer> intCountMap = new HashMap<>();
		for (int i : nums) {
			if (intCountMap.get(i) == null) {
				intCountMap.put(i, 1);
			} else {
				int count = intCountMap.get(i);
				intCountMap.put(i, count + 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : intCountMap.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return 0;
	}
}
