/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

/**
 *
 * @author hieund3
 */
public class Search2DMatrix2 {

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
			{1, 4, 7, 11, 15},
			{2, 5, 8, 12, 19},
			{3, 6, 9, 16, 22},
			{10, 13, 14, 17, 24},
			{18, 21, 23, 26, 30}
		};
		int target = 51;
		boolean ret = process(matrix, target);
		System.out.println("ret: " + ret);
	}

	private static boolean process(int[][] matrix, int target) {
		int m = matrix.length - 1;
		int n = matrix[0].length - 1;

		int i = m;
		int j = 0;

		while (i >= 0 && j <= n) {
			if (target < matrix[i][j]) {
				i--;
			} else if (target > matrix[i][j]) {
				j++;
			} else {
				return true;
			}
		}

		return false;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int m = matrix.length - 1;
		int n = matrix[0].length - 1;

		int i = m;
		int j = 0;

		while (i >= 0 && j <= n) {
			if (target < matrix[i][j]) {
				i--;
			} else if (target > matrix[i][j]) {
				j++;
			} else {
				return true;
			}
		}

		return false;
	}

}
