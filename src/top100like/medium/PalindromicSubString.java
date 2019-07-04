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
public class PalindromicSubString {

	public static void main(String[] args) {
		String text = "aaa";
		int num = process(text);
		System.out.println("num: " + num);
	}

	private static int process(String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}
		int result = text.length();
		for (int i = 0; i < text.length() - 1; i++) {
			int palindromic1 = isPalindromic(i, i + 1, text);
			int palindromic2 = isPalindromic(i, i + 2, text);
			result += (palindromic1 + palindromic2);
		}
		return result;
	}

	private static int isPalindromic(int left, int right, String text) {
		int result = 0;
		while (left >= 0 && right <= text.length() - 1 && text.charAt(left) == text.charAt(right)) {
			result++;
			left--;
			right++;
		}
		return result;
	}
}
