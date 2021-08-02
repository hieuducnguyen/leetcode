package dynamicprogramming;

/*
 * Created by hieund3 on 31/07/2021
 */
public class _304_RangeSumQuery2DImmutable {

	private final int[][] sum;

	public _304_RangeSumQuery2DImmutable(int[][] matrix) {
		sum = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 1; i < matrix.length + 1; i++) {
			for (int j = 1; j < matrix[0].length + 1; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return this.sum[row2 + 1][col2 + 1] - this.sum[row2 + 1][col1] - this.sum[row1][col2 + 1] + this.sum[row1][col1];
	}
}
