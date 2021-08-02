package dynamicprogramming;

/*
 * Created by hieund3 on 23/06/2021
 */
public class _62_UniquePaths {
	public static final _62_UniquePaths INSTANCE = new _62_UniquePaths();

	public int uniquePaths(int m, int n) {
		int[][] uniquePaths = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					uniquePaths[i][j] = 1;
				} else {
					int minUp = i > 0 ? uniquePaths[i - 1][j] : 0;
					int minLeft = j > 0 ? uniquePaths[i][j - 1] : 0;
					uniquePaths[i][j] = (minUp + minLeft);
				}
			}
		}
		return uniquePaths[m - 1][n - 1];
	}
}
