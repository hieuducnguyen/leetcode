/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class WordBreak {

	public static void main(String[] args) {
		String s = "applepenapple";
		List<String> list = Arrays.asList("apple", "pen");
		boolean result = process(s, list);
		System.out.println("result " + result);
	}

	private static boolean process(String s, List<String> list) {
		StringBuilder sb = new StringBuilder();
		return check(sb, s, list);
	}

	private static boolean check(StringBuilder sb, String s, List<String> list) {
		if (sb.toString().equals(s)) {
			return true;
		}
		if (!s.contains(sb.toString())) {
			return false;
		}
		for (int i = 0; i < list.size(); i++) {
			int pos = sb.length();
			sb.append(list.get(i));
			if (check(sb, s, list)) {
				return true;
			}
			sb.delete(pos, sb.length());
		}
		return false;
	}
}
