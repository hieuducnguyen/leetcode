/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class ShuffleAnArray {

	List<Integer> resetIndex;
	int[] nums;

	public ShuffleAnArray(int[] nums) {
		resetIndex = new ArrayList<>(nums.length);
		this.nums = nums;
		for (int i = 0; i < nums.length; i++) {
			resetIndex.add(i);
		}
	}

	public int[] reset() {
		return nums;
	}

	public int[] shuffle() {
		Collections.shuffle(resetIndex);
		int[] tmpNums = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			tmpNums[i] = nums[resetIndex.get(i)];
		}
		return tmpNums;
	}

	public static void main(String[] args) {
//		int[] nums = {0, 1, 2, 3, 4, 5};
		int[] nums = {2};
		ShuffleAnArray INSTANCE = new ShuffleAnArray(nums);
		int[] shuffle = INSTANCE.shuffle();
		basic.BasicTest.printArray(shuffle);
		int[] reset = INSTANCE.reset();
		basic.BasicTest.printArray(reset);
	}
}
