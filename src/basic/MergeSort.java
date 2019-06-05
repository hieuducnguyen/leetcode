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
public class MergeSort {

	public static void main(String[] args) {
		int[] nums = new int[]{9, 7, 3, 2, 6, 8, 1};
//		int[] nums = new int[]{9, 1};
		process(nums);
		BasicTest.printArrayInt(nums);
	}

	private static void process(int[] nums) {
		mergeSort(nums, 0, nums.length);
	}

	private static void mergeSort(int[] nums, int start, int end) {
		if (start + 1 < end) {
			int middle = (start + end) / 2;
			mergeSort(nums, start, middle);
			mergeSort(nums, middle, end);
			merge(nums, start, middle, end);
		}
	}

	private static void merge(int[] nums, int start, int middle, int end) {
		int n1 = middle - start;
		int n2 = end - middle;
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];
		System.arraycopy(nums, start, arr1, 0, n1);
		System.arraycopy(nums, middle, arr2, 0, n2);
		int i = 0, j = 0, k = start;
		while (i < n1 && j < n2) {
			if (arr1[i] < arr2[j]) {
				nums[k] = arr1[i];
				i++;
			} else {
				nums[k] = arr2[j];
				j++;
			}
			k++;
		}
		if ((i + start) < middle) {
			System.arraycopy(arr1, i, nums, k, n1 - i);
		}
		if ((j + middle) < end) {
			System.arraycopy(arr2, j, nums, k, n2 - j);
		}
	}
}
