package binarySearch;

/*
 * Created by hieund3 on 13/06/2021
 */
public class _1150_CheckIfANumberIsMajorityElementInASortedArray {
	public static final _1150_CheckIfANumberIsMajorityElementInASortedArray INSTANCE =
		new _1150_CheckIfANumberIsMajorityElementInASortedArray();

	boolean isMajority(int arr[], int n, int x) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		int leftMost = findLeftMost(arr, x);
		int rightMost = findRightMost(arr, x);
		return (rightMost - leftMost + 1) > arr.length / 2;
	}

	private int findLeftMost(int[] arr, int x) {
		int l = 0, r = arr.length, m;
		while (l < r) {
			m = (l + r) / 2;
			if (arr[m] == x && (m == 0 || arr[m - 1] < x)) {
				return m;
			} else if (arr[m] <= x) {
				r = m + 1;
			} else {
				l = m;
			}
		}
		return -1;
	}

	private int findRightMost(int[] arr, int x) {
		int l = 0, r = arr.length, m;
		while (l < r) {
			m = (l + r) / 2;
			if (arr[m] == x && (m == arr.length - 1 || arr[m] < arr[m + 1])) {
				return m;
			} else if (arr[m] <= x) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return -1;
	}
}
