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
public class UniquePath {

	public static void main(String[] args) {
		int m = 7;
		int n = 3;
		int result = process(m, n);
		System.out.println("result: " + result);
	}

	private static int process(int m, int n) {
		int[][] matrix = new int[n][m];
		int result = step(0, 0, matrix, n, m);
		return result;
	}

	private static int step(int x, int y, int[][] matrix, int n, int m) {
		if (x > n - 1 || y > m - 1) {
			return 0;
		}
		if (x == n - 1 && y == m - 1) {
			return 1;
		}
		if (matrix[x][y] == 0) {
			matrix[x][y] = step(x + 1, y, matrix, n, m) + step(x, y + 1, matrix, n, m);
		}
		return matrix[x][y];
	}
}
