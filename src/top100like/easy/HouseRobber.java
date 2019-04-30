/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package top100like.easy;

/**
 *
 * @author hieund3
 */
public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = new int[]{2, 7, 9, 3, 1};
		int rob = process2(nums);
		System.out.println("rob: " + rob);
	}

	private static int process2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(dp[0], nums[1]);
		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
		}
		return dp[dp.length - 1];
	}

	private static int process(int[] nums) {
		if (nums != null && nums.length != 0) {
			return rob(nums, 0, nums.length);
		}
		return 0;
	}

	private static int rob(int[] nums, int start, int end) {
		if (start + 1 > end) {
			return 0;
		}
		if (end == (start + 1)) {
			return nums[start];
		}
		int middle = (end + start) / 2;
		int maxLeft = rob(nums, start, middle);
		int maxRight = rob(nums, middle + 1, end);
		int withMiddle = nums[middle] + rob(nums, start, middle - 1) + rob(nums, middle + 2, end);
		int value = Math.max(maxLeft + maxRight, withMiddle);
		return value;
	}
}
