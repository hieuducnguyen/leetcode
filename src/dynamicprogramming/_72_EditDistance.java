package dynamicprogramming;

/*
 * Created by hieund3 on 24/07/2021
 */
public class _72_EditDistance {
	public static final _72_EditDistance INSTANCE = new _72_EditDistance();

	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null) {
			return 0;
		}
		if (word1 == null || word1.length() == 0) {
			return word2.length();
		}
		if (word2 == null || word2.length() == 0) {
			return word1.length();
		}
		int[][] minDistanceArr = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i < word1.length() + 1; i++) {
			minDistanceArr[i][0] = i;
		}
		for (int i = 0; i < word2.length() + 1; i++) {
			minDistanceArr[0][i] = i;
		}
		for (int i = 1; i < word1.length() + 1; i++) {
			for (int j = 1; j < word2.length() + 1; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					minDistanceArr[i][j] = minDistanceArr[i - 1][j - 1];
				} else {
					minDistanceArr[i][j] = Math.min(minDistanceArr[i - 1][j - 1], Math.min(minDistanceArr[i - 1][j],
						minDistanceArr[i][j - 1])) + 1;
				}
			}
		}
		return minDistanceArr[word1.length()][word2.length()];
	}
}
