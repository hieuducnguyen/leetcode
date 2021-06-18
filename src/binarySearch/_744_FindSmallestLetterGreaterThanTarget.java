package binarySearch;

/*
 * Created by hieund3 on 15/06/2021
 */

public class _744_FindSmallestLetterGreaterThanTarget {
	public static final _744_FindSmallestLetterGreaterThanTarget INSTANCE =
		new _744_FindSmallestLetterGreaterThanTarget();

	public char nextGreatestLetter(char[] letters, char target) {
		char min = letters[0];
		int l = 0, r = letters.length, m;
		while (l < r) {
			m = (l + r) / 2;
			if (compare(letters[m], target, min) > 0
				&& (m == 0 || compare(letters[m - 1], target, min) <= 0)) {
				return letters[m];
			} else if (compare(letters[m], target, min) <= 0) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return letters[0];
	}

	int compare(char letter1, char letter2, char min) {
		return realValue(letter1, min) - realValue(letter2, min);
	}

	int realValue(char letter, char min) {
		final int i = letter - min;
		return i >= 0 ? i : i + 26;
	}
}
