/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author hieund3
 */
public class LongestSubStringWithoutRepeat {

	public static void main(String[] args) {
		String text = "abba";
		int lenght = process3(text);
		System.out.println("len: " + lenght);
	}

	private static int process(String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}
		if (text.length() == 1) {
			return 1;
		}
		Set<Character> set = new HashSet<>();
		int point = 0;
		char[] textArr = text.toCharArray();
		set.add(textArr[0]);
		int max = 1;
		for (int i = 1; i < textArr.length; i++) {
			while (set.contains(textArr[i])) {
				set.remove(textArr[point]);
				point++;
			}
			set.add(textArr[i]);
			max = max > (i - point + 1) ? max : (i - point + 1);
		}
		return max;
	}

	private static int process1(String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}
		if (text.length() == 1) {
			return 1;
		}
		Set<Character> set = new HashSet<>();
		int point = 0;
		char[] textArr = text.toCharArray();
		set.add(textArr[0]);
		int max = 1;
		int i = 1;
		while (i < textArr.length) {
			if (!set.contains(textArr[i])) {
				set.add(textArr[i]);
				max = max > (i - point + 1) ? max : (i - point + 1);
				i++;
			} else {
				set.remove(textArr[point]);
				point++;
			}
		}
		return max;
	}

	private static int process2(String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}
		if (text.length() == 1) {
			return 1;
		}
		Map<Character, Integer> map = new HashMap<>();
		int j = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < text.length(); i++) {
			if (map.containsKey(text.charAt(i))) {
				j = Math.max(map.get(text.charAt(i)), j);
			}
			max = max > (i - j + 1) ? max : (i - j + 1);
			map.put(text.charAt(i), i + 1);
		}
		return max;
	}

	private static int process3(String text) {
		System.out.println('z' - 'A');
		return 0;
	}
}
