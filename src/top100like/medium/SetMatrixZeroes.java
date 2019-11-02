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
public class SetMatrixZeroes {

	static SetMatrixZeroes INSTANCE = new SetMatrixZeroes();

	public static void main(String[] args) {
		int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
		INSTANCE.setZeroes(matrix);
		basic.BasicTest.printMatrix(matrix);
	}

	public void setZeroes(int[][] matrix) {
		long vertical = 0;
		long horizontal = 0;
		for (int i = 0; i < matrix.length; i++) {
			vertical = vertical << 1;
			for (int j = 0; j < matrix[0].length; j++) {
				horizontal = horizontal << 1;
				if (matrix[i][j] != 0) {
					vertical |= 1;
					horizontal |= 1;
				}
			}
		}
		String verticalString = Long.toString(vertical, 2);
		System.out.println(verticalString);
		String horizontalString = Long.toString(horizontal, 2);
		System.out.println(horizontalString);
//		for (int i = matrix.length - 1; i >= 0; i--) {
//			for (int j = matrix[0].length - 1; j >= 0; j--) {
//				int value = zeroIndex & 1;
//				if (value == 0) {
//					setZeros(matrix, i, j);
//				}
//				zeroIndex = zeroIndex >> 1;
//			}
//		}
	}

	private void setZeros(int[][] matrix, int i, int j) {
		for (int k = 0; k < matrix.length; k++) {
			matrix[k][j] = 0;
		}

		for (int k = 0; k < matrix[0].length; k++) {
			matrix[i][k] = 0;
		}
	}
}
