/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.hard;

/**
 *
 * @author hieund3
 */
public class RegularExpression {

	public static final RegularExpression INSTANCE = new RegularExpression();

	public static void main(String[] args) {
		String text = "aaa";
		String pattern = "a*a";
		boolean match = INSTANCE.isMatch(text, pattern);
		System.out.println("match: " + match);
	}

	boolean isMatch(String text, String pattern) {
		if (pattern.isEmpty()) {
			return text.isEmpty();
		}
		final boolean firstMatch = !text.isEmpty() && ((text.charAt(0) == pattern.charAt(0))
			|| pattern.charAt(0) == '.');
		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			return (firstMatch
				&& isMatch(text.substring(1), pattern))
				|| isMatch(text, pattern.substring(2));
		} else {
			return firstMatch && isMatch(text.substring(1), pattern.substring(1));
		}
	}

	public boolean isMatchV3(String text, String pattern) {
		boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
		dp[text.length()][pattern.length()] = true;

		for (int i = text.length(); i >= 0; i--) {
			for (int j = pattern.length() - 1; j >= 0; j--) {
				boolean first_match = (i < text.length()
					&& (pattern.charAt(j) == text.charAt(i)
					|| pattern.charAt(j) == '.'));
				if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
					dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
				} else {
					dp[i][j] = first_match && dp[i + 1][j + 1];
				}
			}
		}
		return dp[0][0];
	}

	public boolean isMatchV2(String text, String pattern) {
		if (pattern.isEmpty()) {
			return text.isEmpty();
		}
		boolean first_match = (!text.isEmpty()
			&& (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			return (isMatch(text, pattern.substring(2))
				|| (first_match && isMatch(text.substring(1), pattern)));
		} else {
			return first_match && isMatch(text.substring(1), pattern.substring(1));
		}
	}
}
