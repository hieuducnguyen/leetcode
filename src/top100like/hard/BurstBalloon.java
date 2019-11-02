/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author hieund3
 */
public class BurstBalloon {

	public static final BurstBalloon INSTANCE = new BurstBalloon();

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		int maxCoins = INSTANCE.maxCoins(nums);
		System.out.println("maxCoins: " + maxCoins);
	}

	public int maxCoins(int[] nums) {
		List<Integer> list = IntStream.of(nums)
			.boxed().collect(Collectors.toCollection(ArrayList::new));

		return maxCoins(list);
	}

	public int maxCoins(List<Integer> nums) {
		if (nums == null || nums.isEmpty()) {
			return 0;
		}
		if (nums.size() == 1) {
			return nums.get(0);
		}
		if (nums.size() == 2) {
			return nums.get(0) * nums.get(1) + Math.max(nums.get(0), nums.get(1));
		}
		int minIndex = 1;
		int minValue = nums.get(1);
		for (int i = 2; i < nums.size() - 1; i++) {
			if (nums.get(i) < minValue) {
				minIndex = i;
				minValue = nums.get(i);
			}
		}
		int value = nums.get(minIndex - 1) * nums.get(minIndex + 1) * nums.get(minIndex);
		nums.remove(minIndex);
		return value + maxCoins(nums);
	}
}
