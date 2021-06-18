package binarySearch;

/*
 * Created by hieund3 on 16/06/2021
 */
public class _374_GuessNumberHigherOrLower {
	public _374_GuessNumberHigherOrLower(int target) {
		this.target = target;
	}
	int target;
	public int guessNumber(int n) {
		int l = 1, r = n + 1, m;
		while (l < r) {
			m = (l + r) / 2;
			if (guess(m) == 0) {
				return m;
			} else if (guess(m) > 0) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}

	int guess(int num) {
		final int compare = Integer.compare(num, target);
		return compare;
	}
}
