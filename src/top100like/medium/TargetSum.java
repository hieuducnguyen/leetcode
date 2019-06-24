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
public class TargetSum {

	public static void main(String[] args) {
		int[] nums = new int[]{1};
		int target = 1;
		int value = process1(nums, target);
		System.out.println("value: " + value);
	}

	private static int process(int[] nums, int target) {
		return count(0, 0, nums, target);
	}

	private static int count(int index, int nowSum, int[] nums, int target) {
		if (index > nums.length - 1) {
			return nowSum == target ? 1 : 0;
		}
		return count(index + 1, nowSum + nums[index], nums, target)
			+ count(index + 1, nowSum - nums[index], nums, target);
	}

	private static int process1(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return Math.abs(nums[0]) == Math.abs(target) ? 1 : 0;
		}
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(target - nums[0], 1);
		map.put(target + nums[0], map.getOrDefault(target + nums[0], 0) + 1);
		Map<Integer, Integer> tmpMap;
		for (int i = 1; i < nums.length - 1; i++) {
			tmpMap = map;
			map = new HashMap<>();
			for (Integer key : tmpMap.keySet()) {
				map.merge(key - nums[i], tmpMap.get(key), (u, v) -> u + v);
				map.merge(key + nums[i], tmpMap.get(key), (u, v) -> u + v);
			}
		}
		return map.getOrDefault(nums[len - 1], 0) + map.getOrDefault(-nums[len - 1], 0);
	}
	
}
