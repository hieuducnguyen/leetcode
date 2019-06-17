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
public class RotateMatrix {

	public static void main(String[] args) {

//		int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//		int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] matrix = new int[][]{{1, 2}, {3, 4}};
		process(matrix);
		basic.BasicTest.printMatrix(matrix);
	}

	private static void process(int[][] matrix) {
		double t = ((double) matrix.length - 1) / 2;
		for (int j = 0; j > -matrix.length / 2; j--) {
			for (int i = Math.abs(j); i < matrix.length - Math.abs(j) - 1; i++) {
				int temp1 = matrix[Math.abs(j)][i];
				int temp2;
				int x;
				int y;
				for (int k = 0; k < 4; k++) {
					x = j + (int) (2 * t);
					y = -i;
					temp2 = matrix[Math.abs(y)][x];
					matrix[Math.abs(y)][x] = temp1;
					temp1 = temp2;
					i = x;
					j = y;
				}
			}
		}
	}
}
