/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

/**
 *
 * @author hieund3
 */
public class MaxProductSubArray {

	public static void main(String[] args) {
		//-2,0,-1
		int[] nums = new int[]{-4, -3, -2};
		int value = process(nums);
		System.out.println("value: " + value);
	}

	private static int process(int[] nums) {
		int result = nums[0];
		int max = nums[0];
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int tempMax = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			int tempMin = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
			max = tempMax;
			min = tempMin;
			result = Math.max(result, max);
		}
		return result;
	}

}
