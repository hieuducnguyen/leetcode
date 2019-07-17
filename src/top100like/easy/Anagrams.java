/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author hieund3
 */
public class Anagrams {

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> output = process2(s, p);
		System.out.println("output: " + output);
	}

	private static List<Integer> process2(String s, String p) {
		if (s.length() < p.length()) {
			return new ArrayList<>();
		}
		List<Integer> answer = new ArrayList<>();
		int size = p.length();
		int[] target = new int[26];
		for (int i = 0; i < size; i++) {
			target[p.charAt(i) - 'a']++;
		}
		char[] arr = s.toCharArray();
		int l = 0, r = 0;
		while (r < arr.length) {
			if (target[arr[r] - 'a'] > 0) {
				target[arr[r] - 'a']--;
				r++;
			} else {
				target[arr[l] - 'a']++;
				l++;
			}

			if (r - l == size) {
				answer.add(l);
			}
		}
		return answer;
	}

	private static List<Integer> process(String s, String p) {
		List<Integer> list = new ArrayList<>();
		char[] array = p.toCharArray();
		char[] arraySource = s.toCharArray();
		final int arrLen = array.length;
		final int arrSourceLen = arraySource.length;
		if (arrSourceLen < arrLen) {
			return list;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (char charItem : array) {
			addMap(map, charItem);
		}
		Map<Character, Integer> inputMap = new HashMap<>();
		for (int i = 0; i < arrLen; i++) {
			addMap(inputMap, arraySource[i]);
		}
		if (compareMap(inputMap, map)) {
			list.add(0);
		}
		for (int i = 1; i <= (arrSourceLen - arrLen); i++) {
			removeMap(inputMap, arraySource[i - 1]);
			addMap(inputMap, arraySource[i + arrLen - 1]);
			if (compareMap(inputMap, map)) {
				list.add(i);
			}
		}
		return list;
	}

	private static void addMap(Map<Character, Integer> map, Character key) {
		if (map.get(key) == null) {
			map.put(key, 1);
		} else {
			Integer count = map.get(key);
			map.put(key, count + 1);
		}
	}

	private static void removeMap(Map<Character, Integer> map, Character key) {
		if (map.get(key) != null) {
			Integer value = map.get(key);
			value -= 1;
			if (value > 0) {
				map.put(key, value);
			} else {
				map.remove(key);
			}
		}
	}

	private static boolean compareMap(Map<Character, Integer> map1, Map<Character, Integer> map2) {
		if (map1.keySet().size() != map2.keySet().size()) {
			return false;
		}
		for (Character charItem : map1.keySet()) {
			if (!Objects.equals(map1.get(charItem), map2.get(charItem))) {
				return false;
			}
		}
		return true;
	}

	private static List<Integer> process1(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (s.length() < p.length()) {
			return result;
		}
		int[] pData = new int[26];
		for (int i = 0; i < p.length(); i++) {
			pData[p.charAt(i) - 'a']++;
		}
		for (int i = 0; i < p.length(); i++) {
			pData[s.charAt(i) - 'a']--;
		}
		if (isAnagram(pData)) {
			result.add(0);
		}
		for (int i = p.length(); i < s.length(); i++) {
			pData[s.charAt(i) - 'a']--;
			pData[s.charAt(i - p.length()) - 'a']++;
			if (isAnagram(pData)) {
				result.add(i - p.length() + 1);
			}
		}
		return result;
	}

	private static boolean isAnagram(int[] data) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
