/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package binarysearch;

/**
 *
 * @author hieund3
 */
public class SearchInsertPosition {

	public static int process(int[] arr, int value) {
		if (arr == null || arr.length == 1) {
			return 0;
		}
		int l = 0, r = arr.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (arr[m] == value) {
				return m;
			}
			if (arr[m] < value) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return Math.max(r, l);
	}

	public static void main(String[] args) {
//		int[] arr = new int[]{6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5};
		int[] arr = new int[]{1, 2, 3, 4, 6, 7, 9, 10};
//		int[] arr = new int[]{};
		int pivot = process(arr, 2);
		System.out.println("pivot: " + pivot);
	}
}
