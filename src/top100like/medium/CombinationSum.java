/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class CombinationSum {

	public static void main(String[] args) {
		int[] nums = new int[]{1};
		int target = 1;
		List<List<Integer>> result = process(nums, target);
		System.out.println("result: " + result);
	}

	private static List<List<Integer>> process(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		gen(0, nums, target, temp, result);
		return result;
	}

	private static void gen(int index, int[] nums, int target, List<Integer> temp, List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(temp));
			return;
		}
		if (target < 0) {
			return;
		}
		for (int i = index; i < nums.length; i++) {
			temp.add(nums[i]);
			gen(i, nums, target - nums[i], temp, result);
			temp.remove(temp.size() - 1);
		}
	}
}
