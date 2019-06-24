/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hieund3
 */
public class GroupAnagram {

	public static void main(String[] args) {
		String[] text = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = process2(text);
		System.out.println("value: " + result);
	}

	private static List<List<String>> process(String[] text) {
		if (text == null || text.length == 0) {
			return new ArrayList<>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < text.length; i++) {
			String key = buildKey(text[i]);
			if (map.containsKey(key)) {
				map.get(key).add(text[i]);
			} else {
				List<String> list = new ArrayList<>();
				list.add(text[i]);
				map.put(key, list);
			}
		}
		return new ArrayList<>(map.values());
	}

	private static String buildKey(String text) {
		StringBuilder newText = new StringBuilder();
		int[] arr = new int[26];
		for (int i = 0; i < text.length(); i++) {
			arr[text.charAt(i) - 'a']++;
		}
		for (int i = 0; i < arr.length; i++) {
			newText.append((char) (i + 97));
			newText.append(arr[i]);
		}
		return newText.toString();
	}

	private static List<List<String>> process2(String[] text) {
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < text.length; i++) {
			char[] arrChar = text[i].toCharArray();
			Arrays.sort(arrChar);
			String string = new String(arrChar);
			final String name = text[i];
			map.merge(string, new ArrayList<>(Arrays.asList(text[i])), (u, v)
				-> {
				u.add(name);
				return u;
			});
		}
		return new ArrayList<>(map.values());
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<Integer, Integer> map = new HashMap<>();
		List<List<String>> retList = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < strs.length; i++) {
			int hash = hash(strs[i]);
			if (map.getOrDefault(hash, -1) != -1) {
				retList.get(map.getOrDefault(hash, -1)).add(strs[i]);
			} else {
				List<String> newOne = new ArrayList<>();
				map.put(hash, count);
				count++;
				newOne.add(strs[i]);
				retList.add(newOne);
			}
		}
		return retList;
	}

	public int hash(String enter) {
		int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199};
		int num = 1;
		for (int i = 0; i < enter.length(); i++) {
			num *= primes[enter.charAt(i) - 'a'];
		} // System.out.println(num); 
		return num;
	}

}
