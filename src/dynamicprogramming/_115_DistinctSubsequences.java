package dynamicprogramming;

/*
 * Created by hieund3 on 25/07/2021
 */
public class _115_DistinctSubsequences {
	public static final _115_DistinctSubsequences INSTANCE = new _115_DistinctSubsequences();

	public int numDistinct(String s, String t) {
		if (s == null) {
			s = "";
		}
		if (t == null) {
			t = "";
		}
		int[][] numDistincts = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i < s.length() + 1; i++) {
			numDistincts[i][0] = 1;
		}
		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 1; j < t.length() + 1; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					numDistincts[i][j] = numDistincts[i - 1][j - 1] + numDistincts[i - 1][j];
				} else {
					numDistincts[i][j] = numDistincts[i - 1][j];
				}
			}
		}
		return numDistincts[s.length()][t.length()];
	}
}
