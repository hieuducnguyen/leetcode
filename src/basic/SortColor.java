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
public class SortColor {

	public static void main(String[] args) {
		int[] nums = {1, 2, 0};
		sortColor(nums);
		basic.BasicTest.printArray(nums);
	}

	public static void sortColor(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return;
		}
		int left = 0;
		int right = nums.length - 1;
		int i = 0;
		while (i < nums.length) {
			switch (nums[i]) {
				case 0:
					if (i > left) {
						swap(nums, i, left++);
					} else {
						i++;
					}	break;
				case 2:
					if (i < right) {
						swap(nums, i, right--);
					} else {
						i++;
					}	break;
				default:
					i++;
					break;
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
