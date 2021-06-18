package basic;

/*
 * Created by hieund3 on 16/06/2021
 */
public class FindInsertPosition {
	public static final FindInsertPosition INSTANCE = new FindInsertPosition();

	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 5, 7};
		int target = 4;
		int l = 0, r = arr.length, m;
		while (l < r) {
			m = (r + l) / 2;
			if (target <= arr[m]) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		System.out.println("r = " + r);
	}
}
