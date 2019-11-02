/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

/**
 *
 * @author hieund3
 */
public class WiggleSortII {

	public static void main(String[] args) {
		int[] nums = {4, 5, 5, 5};
//		wiggleSortII(nums);
		System.out.println(nums.length | 1);
		for (int i = 0; i < nums.length; i++) {
			int a = (1 + 2 * (i)) % (nums.length | 1);
			System.out.println(a);
		}
//		basic.BasicTest.printArray(nums);
	}

	public static void wiggleSortII(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		int[] arr = nums.clone();
		findMedia(arr);
		basic.BasicTest.printArray(arr);
		if (arr.length % 2 == 0) {
			for (int i = 0; i < arr.length; i += 2) {
				nums[i] = arr[i / 2];
				nums[i + 1] = arr[i / 2 + arr.length / 2];
			}
		} else {
			int j = -1;
			for (int i = 0; i < arr.length / 2 + 1; i += 1) {
				nums[++j] = arr[i];
				if (i != arr.length / 2) {
					nums[++j] = arr[arr.length / 2 + i + 1];
				}
			}
		}
	}

	public static int findMedia(int[] nums) {
		int median = nums.length / 2;
		return quickSelection(nums, 0, nums.length, median + 1);
	}

	private static int quickSelection(int[] nums, int start, int end, int kth) {
		int pivot = nums[end - 1];
		int j = start - 1;
		for (int i = start; i < end; i++) {
			if (nums[i] < pivot) {
				j++;
				swap2Element(nums, j, i);
			}
		}
		j++;
		swap2Element(nums, j, end - 1);
		if (j + 1 == kth) {
			return nums[j];
		} else if (j + 1 < kth) {
			return quickSelection(nums, j + 1, end, kth);
		} else {
			return quickSelection(nums, start, j, kth);
		}
	}

	public static int[] swap2Element(int[] array, int pos, int des) {
		int temp = array[pos];
		array[pos] = array[des];
		array[des] = temp;
		return array;
	}
}
