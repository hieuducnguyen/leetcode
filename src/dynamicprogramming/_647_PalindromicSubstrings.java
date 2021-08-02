package dynamicprogramming;

/*
 * Created by hieund3 on 20/06/2021
 */

public class _647_PalindromicSubstrings {
	public static final _647_PalindromicSubstrings INSTANCE = new _647_PalindromicSubstrings();


	public int countSubstrings(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int result = 0;
		boolean[][] subString = new boolean[s.length()][s.length()];
		for (int j = 0; j < s.length(); j++) {
			for (int i = 0; i < j + 1; i++) {
				if (i == j) {
					subString[i][j] = true;
					result++;
				} else if (s.charAt(i) == s.charAt(j)) {
					if (j - i == 1) {
						subString[i][j] = true;
						result++;
					} else {
						subString[i][j] = subString[i + 1][j - 1];
						if (subString[i][j]) {
							result++;
						}
					}
				}
			}
		}
		return result;
	}

	public int countSubstrings2(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			int oddSubString = oddSubString(i, s);
			int evenSubString = evenSubString(i, s);
			result += (oddSubString + evenSubString);
		}
		return result;
	}

	private int evenSubString(int i, String s) {
		int left = i, right = i + 1;
		return getResult(s, left, right);
	}

	private int getResult(String s, int left, int right) {
		int result = 0;
		while (left >= 0 && right <= s.length() - 1) {
			if (s.charAt(left) == s.charAt(right)) {
				result++;
				left--;
				right++;
			} else {
				break;
			}
		}
		return result;
	}

	private int oddSubString(int i, String s) {
		int left = i, right = i;
		return getResult(s, left, right);
	}

	public int countSubstrings1(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		final int length = s.length();
		int result = 1;
		for (int i = 2; i <= length; i++) {
			for (int j = 0; j < i; j++) {
				if (isPalindromicString(s.substring(j, i))) {
					result++;
				}
			}
		}
		return result;
	}

	private boolean isPalindromicString(String s) {
		if (s.length() == 1) {
			return true;
		}
		int middle = s.length() / 2;
		for (int i = 0; i < middle; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
