package challenge.coding;

public class MaximumSubarray {
	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		//int[] nums = {-1, -2};
		int output = new MaximumSubarray().maxSubArray(nums);
		System.out.println(output);
	}

	public int maxSubArray(int[] nums) {
		int maxSoFar = nums[0];
		int maxEndingHere = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}
}
