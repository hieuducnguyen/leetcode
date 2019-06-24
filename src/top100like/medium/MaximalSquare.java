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
public class MaximalSquare {

	static int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public static void main(String[] args) {
//		char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
//		{'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
		char[][] matrix = {{'1'}};
		int value = process(matrix);
		System.out.println("value: " + value);
	}

	private static int process(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int max = -1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					max = Math.max(max, getSizeSquare(i, j, matrix));
				}
			}
		}
		return (max + 1) * (max + 1);
	}

	private static int getSizeSquare(int i, int j, char[][] matrix) {
		int size = 0;
		for (int k = 1; k < (matrix[0].length - j); k++) {
			for (int[] move : moves) {
				for (int l = 1; l <= k; l++) {
					i += move[0];
					j += move[1];
					if (0 > i || i > (matrix.length - 1)
						|| 0 > j || j > (matrix[0].length - 1)
						|| matrix[i][j] != '1') {
						return size;
					}
				}
			}
			size++;
		}
		return size;
	}
}
