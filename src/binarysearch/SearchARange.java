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
public class SearchARange {

	static class Point {

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int x;
		int y;

		@Override
		public String toString() {
			return String.format("x=%s;y=%s", x, y);
		}

	}

	public static int binSearch(int[] arr, int value) {
		if (arr == null || arr.length == 0) {
			return POSITION_NOT_FOUND;
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
		return POSITION_NOT_FOUND;
	}

	public static int modifyBinSearch(int[] arr, int l, int r, int value, boolean upper) {
		if (l > r) {
			return POSITION_NOT_FOUND;
		}
		int result = POSITION_NOT_FOUND;
		while (l <= r) {
			int m = (l + r) / 2;
			if (arr[m] == value) {
				if (upper) {
					r = m - 1;
				} else {
					l = m + 1;
				}
				result = m;
				continue;
			}
			if (arr[m] < value) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return result;
	}

	public static Point proccess(int[] arr, int value) {
		int l, r;
		int index = binSearch(arr, value);
		if (index == POSITION_NOT_FOUND) {
			return new Point(-1, -1);
		}
		int left = modifyBinSearch(arr, 0, index - 1, value, true);
		l = (left != POSITION_NOT_FOUND) ? left : index;
		int right = modifyBinSearch(arr, index + 1, arr.length - 1, value, false);
		r = (right != POSITION_NOT_FOUND) ? right : index;
		return new Point(l, r);
	}

	public static void main(String[] args) {
//		int[] arr = new int[]{6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5};
		int[] arr = new int[]{1, 2, 3, 3, 3, 3, 4, 5, 5, 5, 6, 7, 8, 9, 10};
//		int[] arr = new int[]{};
		Point point = proccess(arr, 3);
		System.out.println("point: " + point);
	}
}
