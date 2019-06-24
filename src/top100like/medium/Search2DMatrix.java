/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package top100like.medium;

/**
 *
 * @author hieund3
 */
public class Search2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		int target = 51;
		boolean ret = process(matrix, target);
		System.out.println("ret: " + ret);

	}

	private static boolean process(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix.length == 1 && matrix[0].length == 0) {
			return false;
		}
		int row = findRow(matrix, target);
		if (row == -1) {
			return false;
		}
		int collumn = findColumn(matrix, row, target);
		return collumn != -1;
	}

	private static int findRow(int[][] matrix, int target) {
		int l = 0, r = matrix.length - 1, m;
		while (l <= r) {
			m = (l + r) / 2;
			if (matrix[m][0] <= target
				&& ((m + 1 > matrix.length - 1)
				|| (m + 1 <= matrix.length - 1 && matrix[m + 1][0] > target))) {
				return m;
			}
			if (matrix[m][0] > target) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}

	private static int findColumn(int[][] matrix, int row, int target) {
		int l = 0, r = matrix[0].length - 1, m;
		while (l <= r) {
			m = (l + r) / 2;
			if (matrix[row][m] == target) {
				return m;
			}
			if (matrix[row][m] < target) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return -1;
	}

}
