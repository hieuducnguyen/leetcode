/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package binarysearch;

import static basic.BasicTest.POSITION_NOT_FOUND;


/**
 *
 * @author hieund3
 */
public class MinRotatedSortV2 {

	public static int process(int[] arr) {
		if (arr == null || arr.length == 0) {
			return POSITION_NOT_FOUND;
		}
		int left = 0, right = arr.length - 1;
		if (arr[left] < arr[right]) {
			return left;
		}
		while (left < right) {
			if (right - left == 1) {
				if (arr[right] < arr[left]) {
					return right;
				} else {
					return POSITION_NOT_FOUND;
				}
			}
			int m = (left + right) / 2;
			if (arr[left] <= arr[m]) {
				left = m;
			} else {
				right = m;
			}
		}
		return POSITION_NOT_FOUND;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{6, 7, 7, 8, 9, 9, 10, 1, 2, 3, 4, 5, 5};
//		int[] arr = new int[]{1, 2, 3, 3, 3, 3, 4, 5, 5, 5, 6, 7, 8, 9, 10};
//		int[] arr = new int[]{};
		int pivot = process(arr);
		System.out.println("pivot: " + pivot);
	}
}
