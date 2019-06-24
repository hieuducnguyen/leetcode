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
public class SearchRotatedSortedArrayV2 {

	private static int process(int[] arr, int value) {
		if (arr == null || arr.length == 0) {
			return POSITION_NOT_FOUND;
		}
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (arr[middle] == value) {
				return middle;
			}
			if (arr[left] <= arr[middle]) {
				if (arr[left] <= value && value < arr[middle]) {
					right = middle - 1;
				} else {
					left = middle + 1;
				}
			} else {
				if (arr[middle] < value && value <= arr[right]) {
					left = middle + 1;
				} else {
					right = middle - 1;
				}
			}
		}
		return POSITION_NOT_FOUND;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{5, 6, 7, 7, 7, 7, 8, 9, 9, 10, 10, 10, 0, 1, 2, 3, 4, 5, 5};
//		int[] arr = new int[]{1, 2, 3, 3, 3, 3, 4, 5, 5, 5, 6, 7, 8, 9, 10};
//		int[] arr = new int[]{};
		int pivot = process(arr, 0);
		System.out.println("pivot: " + pivot);
	}
}
