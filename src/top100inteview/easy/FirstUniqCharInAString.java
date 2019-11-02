/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hieund3
 */
public class FirstUniqCharInAString {

	static final FirstUniqCharInAString INSTANCE = new FirstUniqCharInAString();

	public static void main(String[] args) {
		String s = "loveleetcode";
		int firstUniqChar = INSTANCE.firstUniqChar(s);
		System.out.println(firstUniqChar);
	}

	public int firstUniqChar(String s) {
		int[] frequency = new int[26];
		Map<Character, Integer> map = new HashMap<>();
		Arrays.fill(frequency, 1);
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			frequency[chars[i] - 'a']--;
			map.put(chars[i], i);
		}

		for (int i = 0; i < chars.length; i++) {
			if (frequency[chars[i] - 'a'] == 0) {
				return map.get(chars[i]);
			}
		}
		return -1;
	}
}
