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
public class MergeSort1 {

	public static void main(String[] args) {
		int[] nums = {1};
		mergeSort(nums);
		basic.BasicTest.printArray(nums);
	}

	private static void mergeSort(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return;
		}
		mergeSort(nums, 0, nums.length);
	}

	private static void mergeSort(int[] nums, int start, int end) {
		if (start + 1 >= end) {
			return;
		}
		int middle = (start + end) / 2;
		mergeSort(nums, start, middle);
		mergeSort(nums, middle, end);
		int[] left = new int[middle - start + 1];
		int[] right = new int[end - middle + 1];
		for (int i = 0; i < left.length; i++) {
			left[i] = nums[start + i];
		}
		for (int i = 0; i < right.length; i++) {
			right[i] = nums[middle + i];
		}
		int i = 0, j = 0, k = 0;
		while (j < left.length && k < right.length) {
			if (left[j] < right[k]) {
				nums[i] = left[j];
				j++;
			} else {
				nums[i] = right[k];
				k++;
			}
			i++;
		}
		while (j < left.length) {
//			if()
		}
	}

}
