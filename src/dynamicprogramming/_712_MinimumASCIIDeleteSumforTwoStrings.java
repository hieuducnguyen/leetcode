package dynamicprogramming;

import java.util.Arrays;

/*
 * Created by hieund3 on 25/07/2021
 */
public class _712_MinimumASCIIDeleteSumforTwoStrings {
	public static final _712_MinimumASCIIDeleteSumforTwoStrings INSTANCE =
		new _712_MinimumASCIIDeleteSumforTwoStrings();

	public int minimumDeleteSum(String s1, String s2) {
		if (s1 == null) {
			s1 = "";
		}
		if (s2 == null) {
			s2 = "";
		}
		int[][] minDeleteSumArr = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i < s1.length() + 1; i++) {
			minDeleteSumArr[i][0] = s1.charAt(i - 1) + minDeleteSumArr[i - 1][0];
		}
		for (int i = 1; i < s2.length() + 1; i++) {
			minDeleteSumArr[0][i] = s2.charAt(i - 1) + minDeleteSumArr[0][i - 1];
		}

		for (int i = 1; i < s1.length() + 1; i++) {
			for (int j = 1; j < s2.length() + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					minDeleteSumArr[i][j] = minDeleteSumArr[i - 1][j - 1];
				} else {
					minDeleteSumArr[i][j] = Math.min(minDeleteSumArr[i - 1][j] + s1.charAt(i - 1),
						minDeleteSumArr[i][j - 1] + s2.charAt(j - 1));
				}
			}
		}
		return minDeleteSumArr[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		String a = "seat";
		for (int i = 0; i < a.length(); i++) {
			int value = a.charAt(i);
			System.out.println("value = " + value);
		}
	}
}
