package binarySearch;

/*
 * Created by hieund3 on 17/06/2021
 */
public class _278_FirstBadVersion {
	//test 1
	int badVersion;

	public _278_FirstBadVersion(int badVersion) {
		this.badVersion = badVersion;
	}

	public int firstBadVersion(int n) {
		long l = 1, r = (long) n + 1, m;
		while (l < r) {
			m = (l + r) / 2;
			boolean isBad = isBadVersion((int) m);
			if (isBad) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		return (int) l;
	}

	private boolean isBadVersion(int i) {
		return i >= badVersion;
	}
}
