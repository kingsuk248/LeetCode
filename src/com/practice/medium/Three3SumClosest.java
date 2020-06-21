package com.practice.medium;

public class Three3SumClosest {
	public static void main(String[] args) {
		Three3SumClosest t3sc = new Three3SumClosest();
		int[] nums = { -1, 2, 1, -4 };
		int target = 1;
		int sum = t3sc.threeSumClosest(nums, target);
		System.out.println(sum);
	}

	public int threeSumClosest(int[] nums, int target) {
		int diff = Integer.MAX_VALUE;
		int returnValue = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					if (Math.abs(sum - target) < diff) {
						diff = Math.abs(sum - target);
						returnValue = sum;
					}
				}
			}
		}
		return returnValue;
	}
}
