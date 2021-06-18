package binarySearch;

/*
 * Created by hieund3 on 12/06/2021
 */
public class _1064_FixedPoint {
	public static final _1064_FixedPoint INSTANCE = new _1064_FixedPoint();

	public int fixedPoint(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int l = 0, r = arr.length, m, result = -1;
		while (l < r) {
			m = (l + r) / 2;
			if (arr[m] == m) {
				result = m;
				r = m;
			} else if (arr[m] > m) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		return result;
	}
}
