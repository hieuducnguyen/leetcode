/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package divide_conquer;

/**
 *
 * @author hieund3
 */
public class MinSizeSubArray {

	public static int proccess(int[] arr, int sum) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int l = 0, r = arr.length - 1;
		return minSizeSubArr(arr, l, r, sum);
	}

	private static int minSizeSubArr(int[] arr, int l, int r, int sum) {
		if (l >= r) {
			return Integer.MAX_VALUE;
		}
		int m = (l + r) / 2;
		int leftSide = minSizeSubArr(arr, l, m - 1, sum);
		int rightSide = minSizeSubArr(arr, m + 1, r, sum);
		int min = Math.min(leftSide, rightSide);
		return min;
	}

	public static void main(String[] args) {

	}
}
