/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

/**
 *
 * @author hieund3
 */
public class MaximalSquare {

	public static final MaximalSquare Instance = new MaximalSquare();

	public static void main(String[] args) {
//		char[][] matrix = {{'1', '0', '1', '0', '0'},
//		{'1', '0', '1', '1', '1'},
//		{'1', '1', '1', '1', '1'},
//		{'1', '0', '0', '1', '0'}};
		char[][] matrix = {{'1', '1'}, {'0', '1'}};
		int maximalSquare = Instance.maximalSquare(matrix);
		System.out.println(maximalSquare);
	}

	int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[][] maximalSquare = new int[matrix.length + 1][matrix[0].length + 1];
		int maximalEdge = 0;
		for (int i = 1; i < maximalSquare.length; i++) {
			for (int j = 1; j < maximalSquare[0].length; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					maximalSquare[i][j] = Math.min(Math.min(maximalSquare[i - 1][j],
						maximalSquare[i][j - 1]),
						maximalSquare[i - 1][j - 1]) + 1;
					maximalEdge = Math.max(maximalEdge, maximalSquare[i][j]);
				}
			}
		}
		return maximalEdge * maximalEdge;
	}
}
