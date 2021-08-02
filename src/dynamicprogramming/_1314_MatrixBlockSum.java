package dynamicprogramming;

/*
 * Created by hieund3 on 31/07/2021
 */
public class _1314_MatrixBlockSum {
	public static final _1314_MatrixBlockSum INSTANCE = new _1314_MatrixBlockSum();

	public int[][] matrixBlockSum(int[][] mat, int k) {
		int[][] sum = new int[mat.length + 1][mat[0].length + 1];
		for (int i = 1; i <= mat.length; i++) {
			for (int j = 1; j <= mat[0].length; j++) {
				sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
			}
		}
		int[][] result = new int[mat.length][mat[0].length];
		for (int i = 1; i <= mat.length; i++) {
			for (int j = 1; j <= mat[0].length; j++) {
				int topI = Math.min(i + k, mat.length);
				int topJ = Math.min(j + k, mat[0].length);
				int bottomI = Math.max(i - k - 1, 0);
				int bottomJ = Math.max(j - k - 1, 0);
				result[i - 1][j - 1] =
					sum[topI][topJ] - sum[topI][bottomJ] - sum[bottomI][topJ] + sum[bottomI][bottomJ];
			}
		}
		return result;
	}
}
