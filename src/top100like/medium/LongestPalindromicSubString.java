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
		String ret = process(text);
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
}
