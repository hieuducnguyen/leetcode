/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

/**
 *
 * @author hieund3
 */
public class TestKnapsack {

	public static boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if ((sum & 1) == 1) {
			return false;
		}
		sum = sum / 2;
		int[][] value = new int[nums.length][sum + 1];
		for (int i = 0; i < nums.length; i++) {
			value[i][0] = 0;
		}
		for (int i = 1; i <= sum; i++) {
			value[0][i] = nums[0];
		}
		for (int i = 1; i < nums.length; i++) {
			for (int k = 1; k <= sum; k++) {
				if (nums[i] <= k) {
					value[i][k] = Math.max(value[i - 1][k], nums[i] + value[i - 1][k - nums[i]]);
				} else {
					value[i][k] = value[i - 1][k];
				}
				if (k == sum && value[i][sum] == sum) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
//		int[] arr = {1, 5, 11, 5};
		int[] arr = {1, 2, 3, 5};
		boolean canPartition = canPartition(arr);
		System.out.println(canPartition);
	}
}
