/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class PalindromePartitioning {

	static PalindromePartitioning INSTANCE = new PalindromePartitioning();

	public static void main(String[] args) {
		String s = "a";
		List<List<String>> partition = INSTANCE.partition(s);
		System.out.println(partition);
//		boolean palindrome = INSTANCE.isPalindrome(s);
//		System.out.println(palindrome);
	}

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> tempResult = new ArrayList<>();
		int index = 0;
		partition(s, index, tempResult, result);
		return result;
	}

	private void partition(String s, int index, List<String> tempResult, List<List<String>> result) {
		if (index == s.length()) {
			result.add(new ArrayList<>(tempResult));
			return;
		}
		for (int i = index; i < s.length(); i++) {
			if (isPalindrome(s.substring(index, i + 1))) {
				tempResult.add(s.substring(index, i + 1));
				partition(s, i + 1, tempResult, result);
				tempResult.remove(tempResult.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s) {
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length / 2; i++) {
			if (arr[i] != arr[arr.length - i - 1]) {
				return false;
			}
		}
		return true;
	}
}
