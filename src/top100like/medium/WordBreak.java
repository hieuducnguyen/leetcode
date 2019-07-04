/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author hieund3
 */
public class WordBreak {

	public static void main(String[] args) {
		String s = "applepenapple";
		List<String> list = Arrays.asList("apple", "pen");
		boolean result = process1(s, list);
		System.out.println("result " + result);
	}

	private static boolean process(String s, List<String> list) {
		List<String> resultList = new ArrayList<>();
		return check(resultList, s, list);
	}

	private static boolean check(List<String> resultList, String s, List<String> list) {
		if (String.join("", resultList).equals(s)) {
			return true;
		}
		for (int i = 0; i < list.size(); i++) {
			resultList.add(list.get(i));
			if (s.contains(String.join("", resultList)) && check(resultList, s, list)) {
				return true;
			}
			resultList.remove(resultList.size() - 1);
		}
		return false;
	}

	private static boolean process1(String s, List<String> list) {
		if (list == null || list.isEmpty()) {
			return s == null || s.isEmpty();
		}
		Set<Integer> set = new HashSet<>();
		set.add(0);
		for (int i = 0; i < s.length(); i++) {
			if (!set.contains(i)) {
				continue;
			}
			if (set.contains(s.length())) {
				break;
			}
			for (String item : list) {
				if ((i + item.length() <= s.length()) && s.substring(i, i + item.length()).equals(item)) {
					set.add(item.length() + i);
				}
			}
		}
		return set.contains(s.length());
	}
}
