package top100inteview.easy;

/*
 * Created by hieund3 on 01/07/2021
 */
public class _14_LongestCommonPrefix {
	public static final _14_LongestCommonPrefix INSTANCE = new _14_LongestCommonPrefix();

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		final char[] array = strs[0].toCharArray();
		for (int i = 0; i < array.length; i++) {
			final boolean isCommonPrefix = checkPrefix(strs, array, i);
			if (isCommonPrefix) {
				sb.append(array[i]);
			} else {
				break;
			}
		}
		return sb.toString();

	}

	private boolean checkPrefix(String[] strs, char[] array, int i) {
		for (int j = 1; j < strs.length; j++) {
			if (strs[j].length() - 1 < i) {
				return false;
			}
			if (strs[j].charAt(i) != array[i]) {
				return false;
			}
		}
		return true;
	}
}
