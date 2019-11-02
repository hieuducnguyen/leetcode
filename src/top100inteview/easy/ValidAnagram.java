/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.easy;

import java.math.BigInteger;

/**
 *
 * @author hieund3
 */
public class ValidAnagram {

	public static final ValidAnagram INSTANCE = new ValidAnagram();

	public static void main(String[] args) {
		boolean isAnagram = INSTANCE.isAnagram("abcdefghijklmnopqrstuvwxyz", "cba");
		System.out.println(isAnagram);
	}

	private boolean isAnagram(String s, String k) {
		if (s.length() != k.length()) {
			return false;
		}
		int[] frequency = new int[26];
		for (int i = 0; i < s.length(); i++) {
			frequency[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < k.length(); i++) {
			frequency[k.charAt(i) - 'a']--;
		}
		for (int i = 0; i < frequency.length; i++) {
			if (frequency[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
