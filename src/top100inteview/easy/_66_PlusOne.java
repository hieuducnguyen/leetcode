package top100inteview.easy;

/*
 * Created by hieund3 on 02/07/2021
 */
public class _66_PlusOne {
	public static final _66_PlusOne INSTANCE = new _66_PlusOne();

	public int[] plusOne(int[] digits) {
		int i = digits.length - 1;
		while (i >= 0) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i]++;
				return digits;
			}
			i--;
		}
		int[] a = new int[digits.length + 1];
		a[0] = 1;
		return a;
	}
}
