/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class Combination {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 4, 5};
		List<List<Integer>> list = process(nums);
		System.out.println(list);
	}

	private static List<List<Integer>> process(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		gen(0, nums, temp, result);
		return result;
	}

	private static void gen(int index, int[] nums, List<Integer> temp, List<List<Integer>> result) {
		for (int i = index; i < nums.length; i++) {
			temp.add(nums[i]);
			result.add(new ArrayList<>(temp));
			gen(i + 1, nums, temp, result);
			temp.remove(temp.size() - 1);
		}
	}
}
