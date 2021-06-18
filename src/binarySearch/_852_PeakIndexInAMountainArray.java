package binarySearch;

/*
 * Created by hieund3 on 12/06/2021
 */
public class _852_PeakIndexInAMountainArray {
	public static final _852_PeakIndexInAMountainArray INSTANCE = new _852_PeakIndexInAMountainArray();

	public int peakIndexInMountainArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		if (arr.length == 1) {
			return 0;
		}
		int l = 0, r = arr.length, m;
		while (l < r) {
			m = (r + l) / 2;
			if (m > 0 && m < arr.length - 1 && arr[m] > arr[m - 1] && arr[m] > arr[m + 1]) {
				return m;
			} else if (arr[m - 1] < arr[m]) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return -1;
	}
}
