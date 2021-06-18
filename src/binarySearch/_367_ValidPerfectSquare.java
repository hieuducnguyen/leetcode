package binarySearch;

/*
 * Created by hieund3 on 17/06/2021
 */
public class _367_ValidPerfectSquare {
	public static final _367_ValidPerfectSquare INSTANCE = new _367_ValidPerfectSquare();

	public boolean isPerfectSquare(int num) {
		long l = 0, r = num + 1, m;
		while (l < r) {
			m = (l + r) / 2;
			long value = m * m;
			if (value == num) {
				return true;
			} else if (value < num) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return false;
	}
}
