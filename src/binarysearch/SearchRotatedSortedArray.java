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
public class SearchRotatedSortedArray {

	public static int binarySearch(int arr[], int l, int r, int value) {
		while (l <= r) {
			int m = (l + r) / 2;
			if (arr[m] == value) {
				return m;
			}
			if (arr[m] > value) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}

	public static int binarySearchMin(int arr[], int l, int r, int value) {
		while (l <= r) {
			int m = (l + r) / 2;
			if (arr[m] == value) {
				return m;
			}
			if (arr[m] > value) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}

	private static int process(int[] arr, int value) {
		if (arr == null || arr.length == 0) {
			return POSITION_NOT_FOUND;
		}
		int pivot = findPivot(arr, 0, arr.length - 1);
		int left = 0, right = arr.length - 1;
		if (pivot != -1) {
			if (arr[0] <= value && value <= arr[pivot - 1]) {
				right = pivot - 1;
			} else {
				left = pivot;
			}
		}
		return binarySearch(arr, left, right, value);
	}

	public static int findPivot(int[] arr, int l, int r) {
		if (arr == null || arr.length == 1) {
			return POSITION_NOT_FOUND;
		}
		while (l < r) {
			if (arr[l] < arr[r]) {
				return POSITION_NOT_FOUND;
			}
			int m = (l + r) / 2;
			if (arr[l] < arr[m]) {
				l = m;
			} else {
				r = m;
			}
		}
		return l + 1;
	}

	public static int processV2(int[] arr, int value) {
		if (arr == null || arr.length == 0) {
			return POSITION_NOT_FOUND;
		}
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (arr[middle] == value) {
				return middle;
			}
			if (arr[left] < arr[middle]) {
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
		int[] arr = new int[]{6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5};
//		int[] arr = new int[]{1, 2, 3, 3, 3, 3, 4, 5, 5, 5, 6, 7, 8, 9, 10};
//		int[] arr = new int[]{};
		int pivot = processV2(arr, 0);
		System.out.println("pivot: " + pivot);
	}
}
