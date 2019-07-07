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
public class QuickSort {

	public static void main(String[] args) {
		int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
		process(nums);
		BasicTest.printArray(nums);
	}

	private static void process(int[] nums) {
		quickSort(nums, 0, nums.length);
	}

	private static void quickSort(int[] nums, int l, int r) {
		if (l + 1 < r) {
			int pos = partition(nums, l, r);
			quickSort(nums, l, pos);
			quickSort(nums, pos + 1, r);
		}
	}

	private static int partition(int[] nums, int l, int r) {
		int i = l - 1;
		int pivot = nums[r - 1];
		for (int j = l; j < r - 1; j++) {
			if (nums[j] < pivot) {
				i++;
				BasicTest.swap2Element(nums, i, j);
			}
		}
		BasicTest.swap2Element(nums, i + 1, r - 1);
		return i + 1;
	}
}
