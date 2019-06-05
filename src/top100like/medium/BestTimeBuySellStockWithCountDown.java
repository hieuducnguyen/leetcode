/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hieund3
 */
public class BestTimeBuySellStockWithCountDown {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 4, 2};
		int profix = process(nums);
		System.out.println("profix: " + profix);
	}

	private static int process(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		int firstProfit = nums[1] > nums[0] ? nums[1] - nums[0] : 0;
		map.put(1, firstProfit);
		for (int i = 2; i < nums.length; i++) {
			int tempMax = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] - nums[j] > 0) {
					if (tempMax < ((nums[i] - nums[j]) + map.getOrDefault(j - 2, 0))) {
						tempMax = (nums[i] - nums[j]) + map.getOrDefault(j - 2, 0);
					}
				}
			}
			map.put(i, Math.max(tempMax, map.get(i - 1)));
		}
		return map.get(nums.length - 1);
	}
}
