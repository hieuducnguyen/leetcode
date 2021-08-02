package dynamicprogramming;

/*
 * Created by hieund3 on 23/06/2021
 */
public class _64_MinimumPathSum {
	public static final _64_MinimumPathSum INSTANCE = new _64_MinimumPathSum();

	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int[][] minSum = new int[grid.length][grid[0].length];
		for (int i = 0; i < minSum.length; i++) {
			for (int j = 0; j < minSum[0].length; j++) {
				if (i == 0 && j == 0) {
					minSum[i][j] = grid[i][j];
				} else {
					int minUp = j > 0 ? minSum[i][j - 1] : Integer.MAX_VALUE;
					int minLeft = i > 0 ? minSum[i - 1][j] : Integer.MAX_VALUE;
					minSum[i][j] = Math.min(minUp, minLeft) + grid[i][j];
				}
			}
		}
		return minSum[minSum.length - 1][minSum[0].length - 1];
	}
}
