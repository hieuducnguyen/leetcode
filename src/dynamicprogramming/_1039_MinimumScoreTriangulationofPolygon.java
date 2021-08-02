package dynamicprogramming;

/*
 * Created by hieund3 on 28/07/2021
 */
public class _1039_MinimumScoreTriangulationofPolygon {
	public static final _1039_MinimumScoreTriangulationofPolygon INSTANCE =
		new _1039_MinimumScoreTriangulationofPolygon();

	public int minScoreTriangulation(int[] values) {
		int[][] score = new int[values.length][values.length];
		return minScoreTriangulation(values, 0, values.length - 1, score);
	}

	private int minScoreTriangulation(int[] values, int start, int end, int[][] score) {
		if (end - start < 2) {
			return 0;
		}
		if (score[start][end] != 0) {
			return score[start][end];
		}
		if (end - start == 2) {
			score[start][end] = values[start] * values[start + 1] * values[end];
			return score[start][end];
		}
		int minScore = Integer.MAX_VALUE;
		for (int i = start + 1; i < end; i++) {
			final int left = minScoreTriangulation(values, start, i, score);
			final int right = minScoreTriangulation(values, i, end, score);
			int scoreTmp = left + right + values[start] * values[i] * values[end];
			minScore = Math.min(scoreTmp, minScore);
			score[start][end] = minScore;
		}
		return minScore;
	}
}
