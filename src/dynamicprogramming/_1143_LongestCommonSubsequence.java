package dynamicprogramming;

/*
 * Created by hieund3 on 19/07/2021
 */
public class _1143_LongestCommonSubsequence {
	public static final _1143_LongestCommonSubsequence INSTANCE = new _1143_LongestCommonSubsequence();

	public int longestCommonSubsequence(String text1, String text2) {
		if (text1 == null || text1.isEmpty() || text2 == null || text2.isEmpty()) {
			return 0;
		}
		int[][] longestCommonDP = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 1; i < text1.toCharArray().length + 1; i++) {
			for (int j = 1; j < text2.toCharArray().length + 1; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					longestCommonDP[i][j] = 1 + longestCommonDP[i - 1][j - 1];
				} else {
					longestCommonDP[i][j] = Math.max(longestCommonDP[i - 1][j], longestCommonDP[i][j - 1]);
				}
			}
		}
		return longestCommonDP[text1.length()][text2.length()];
	}
}
