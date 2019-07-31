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
public class Test {

	private static final int NOT_FOUND = -1;

	public static void main(String[] args) {
//		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int[] nums = {1, 3};
//		int[] nums = {3};
		int[] result = searchRange(nums, 1);
		BasicTest.printArray(result);
	}

	public static int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[]{-1, -1};
		}
		int result = binSearch(nums, target);
		if (result != -1) {
			int firstElement = findFirstElement(nums, target);
			int lastElement = findLastElement(nums, target);
			return new int[]{firstElement, lastElement};
		} else {
			return new int[]{-1, -1};
		}

	}

	public static int findFirstElement(int[] nums, int target) {
		int l = 0, r = nums.length, m;
		while (l < r) {
			m = (l + r) / 2;
			if (nums[m] == target
				&& ((m == 0) || (m > 0 && nums[m - 1] < target))) {
				return m;
			} else if (nums[m] >= target) {
				r = m;
			} else {
				l = m;
			}
		}
		return -1;
	}

	public static int findLastElement(int[] nums, int target) {
		int l = 0, r = nums.length, m;
		while (l < r) {
			m = (l + r) / 2;
			if (nums[m] == target
				&& (m == nums.length - 1
				|| (m < nums.length - 1 && target < nums[m + 1]))) {
				return m;
			} else if (nums[m] > target) {
				r = m + 1;
			} else {
				l = m;
			}
		}
		return -1;
	}

	public static int binSearch(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int l = 0, r = nums.length, m;
		while (l < r) {
			m = (l + r) / 2;
			if (nums[m] == target) {
				return m;
			} else if (nums[m] > target) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}
}
