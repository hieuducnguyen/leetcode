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
public class SubArrEqualK {

	public static void main(String[] args) {
		int[] nums = {1, 1, 1};
		int k = 2;
		int value = process(nums, k);
		System.out.println("value: " + value);
	}

	private static int process(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			int total = 0;
			for (int j = i; j < nums.length; j++) {
				total += nums[j];
				if (total == k) {
					result++;
				}
			}
		}
		return result;
	}

	private static int process2(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = 0;
		int[] total = new int[nums.length];
		total[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			total[i] += (total[i - 1] + nums[i]);
		}
		int l = -1, r = nums.length - 1, subTotal = total[nums.length - 1];
		while (l < r) {
			int lVal = l == -1 ? nums[0] : nums[l];
			int rVal = nums[r];
			if (subTotal >= target) {
				if (subTotal == target) {
					result++;
				}
				if (lVal > rVal) {
					r--;
				} else {
					l++;
				}
			} else {
				if (lVal > rVal) {
					
				}
			}
			int leftTotal = l == -1 ? 0 : total[l];
			int rightTotal = total[r];
			subTotal = rightTotal - leftTotal;
		}
		return result;
	}
}
