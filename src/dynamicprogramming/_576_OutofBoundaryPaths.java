package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by hieund3 on 01/08/2021
 */
public class _576_OutofBoundaryPaths {
	public static final _576_OutofBoundaryPaths INSTANCE = new _576_OutofBoundaryPaths();

	int[][] directs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	int mod = 1000000007;

	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		int[][][] dp = new int[m][n][maxMove + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < maxMove + 1; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		return findPaths(m, n, maxMove, startRow, startColumn, dp);
	}

	private int findPaths(int m, int n, int maxMove, int startRow, int startColumn, int[][][] dp) {
		if (checkOutOfBoundary(startRow, startColumn, m, n)) {
			return 1;
		}
		if (maxMove == 0) {
			return 0;
		}
		if (dp[startRow][startColumn][maxMove] >= 0) {
			return dp[startRow][startColumn][maxMove];
		}
		int numPath = 0;
		for (int[] direct : directs) {
			final int paths = findPaths(m, n, maxMove - 1, startRow + direct[0], startColumn + direct[1], dp);
			if (startRow + direct[0] >= 0 && startRow + direct[0] < m && startColumn + direct[1] >= 0 && startColumn + direct[1] < n) {
				dp[startRow + direct[0]][startColumn + direct[1]][maxMove - 1] = paths % mod;
			}
			numPath += paths % mod;
		}
		dp[startRow][startColumn][maxMove] = numPath % mod;
		return dp[startRow][startColumn][maxMove];
	}

	boolean checkOutOfBoundary(int x, int y, int m, int n) {
		return (x < 0 || y < 0 || x >= m || y >= n);
	}
}
