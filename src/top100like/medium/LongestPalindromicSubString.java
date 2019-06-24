/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

/**
 *
 * @author hieund3
 */
public class LongestPalindromicSubString {

	public static void main(String[] args) {
		String text = "babad";
		String ret = process2(text);
		System.out.println("ret: " + ret);
	}

	private static String process(String text) {
		if (text.length() == 0 || text.length() == 1) {
			return text;
		}
		String ret = text.substring(0, 1);
		char[] arr = text.toCharArray();
		for (int i = 1; i < arr.length - 1; i++) {
			int start = isPalindromic(i, arr);
			int end = i - start + i + 1;
			if (end - start > 1) {
				String substring = text.substring(start, end);
				if (ret.length() < substring.length()) {
					ret = substring;
				}
			}
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int start = isPalindromic2(i, arr);
			int end = i - start + i + 2;
			if (end - start > 0) {
				String substring = text.substring(start, end);
				if (ret.length() < substring.length()) {
					ret = substring;
				}
			}
		}
		return ret;
	}

	private static int isPalindromic(int i, char[] arr) {
		int j = i + 1;
		int k = i - 1;
		while (j < arr.length && k >= 0 && arr[j] == arr[k]) {
			j++;
			k--;
		}
		return k + 1;
	}

	private static int isPalindromic2(int i, char[] arr) {
		int j = i + 1;
		int k = i;
		while (j < arr.length && k >= 0 && arr[j] == arr[k]) {
			j++;
			k--;
		}
		return k + 1;
	}

	private static String process2(String text) {
		if (text == null || text.isEmpty() || text.length() == 1) {
			return text;
		}
		int maxSubLen = 1;
		String result = text.substring(0, 1);
		for (int i = 0; i < text.length(); i++) {
			int len1 = lenPalindrome(i, 0, text);
			int len2 = lenPalindrome(i, 1, text);
			int len = Math.max(len1, len2);
			if (maxSubLen < len) {
				maxSubLen = len;
				int offset = len % 2 == 0 ? len / 2 - 1 : len / 2;
				result = text.substring(i - offset, i + len / 2 + 1);
			}
		}
		return result;
	}

	private static int lenPalindrome(int center, int mode, String text) {
		int left = mode == 0 ? center - 1 : center;
		int right = center + 1;
		int len = mode == 0 ? 1 : 0;
		while ((left >= 0) && (right <= text.length() - 1) && (text.charAt(left) == text.charAt(right))) {
			left--;
			right++;
			len += 2;
		}
		return len;
	}

}
