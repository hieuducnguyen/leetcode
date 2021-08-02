package top100inteview.easy;

import java.util.Arrays;
import java.util.List;

/*
 * Created by hieund3 on 06/07/2021
 */
public class _125_ValidPalindrome {
	public static final _125_ValidPalindrome INSTANCE = new _125_ValidPalindrome();

	final List<Character> alphabet = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
		'M', 'N', 'O', 'P', 'Q', 'R', 'S',
		'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');


	public boolean isPalindrome(String s) {
		int l = 0, r = s.length() - 1;
		final char[] array = s.toUpperCase().toCharArray();
		while (l < r) {
			while (l < s.length() && !alphabet.contains(array[l])) {
				l++;
			}
			while (r >= 0 && !alphabet.contains(array[r])) {
				r--;
			}
			if (r < l) {
				return true;
			}
			if (array[l] != array[r]) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
