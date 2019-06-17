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
public class KthLargestElement {

	public static void main(String[] args) {
		int[] nums = new int[]{3, 2, 3};
		int k = 2;
		int ret = process(nums, k);
		System.out.println("k: " + ret);//5
	}

	private static int process(int[] nums, int k) {
		return quicksearch(nums, 0, nums.length, k);
	}

	private static int quicksearch(int[] nums, int start, int end, int k) {
		int pos = partition(nums, start, end);
		if (end - pos == k) {
			return nums[pos];
		} else if (end - pos > k) {
			return quicksearch(nums, pos + 1, end, k);
		} else {
			return quicksearch(nums, start, pos, k - (end - pos));
		}
	}

	private static int partition(int[] nums, int start, int end) {
		int pivot = nums[end - 1];
		int i = start - 1;
		for (int j = start; j < end - 1; j++) {
			if (nums[j] < pivot) {
				i++;
				basic.BasicTest.swap2Element(nums, j, i);
			}
		}
		i++;
		basic.BasicTest.swap2Element(nums, i, end - 1);
		return i;
	}
}
