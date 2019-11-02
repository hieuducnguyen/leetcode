/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.hard;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author hieund3
 */
public class FirstMissingPositive {

	public static final FirstMissingPositive INSTANCE = new FirstMissingPositive();

	public static void main(String[] args) {
		int[] nums = {0, -1, 3, 1};
		int missNumber = INSTANCE.firstMissingPositive(nums);
		System.out.println(missNumber);
	}

	public int firstMissingPositiveV1(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0 || nums[i] > nums.length) {
				continue;
			}
			if (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
				int tmp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
				i--;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	public int firstMissingPositive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				set.add(nums[i]);
			}
		}
		int missNumber = 1;
		if (set.contains(1)) {
			missNumber = Integer.MAX_VALUE;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				if (set.contains(nums[i]) && !set.contains(nums[i] - 1)) {
					int temp = nums[i];
					do {
						set.remove(temp);
						if (temp == Integer.MAX_VALUE) {
							break;
						}
						temp++;
					} while (set.contains(temp));
					missNumber = Math.min(missNumber, temp);
				}
			}
		}
		return missNumber;
	}
}
