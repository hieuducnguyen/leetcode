/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author hieund3
 */
public class DecodeString {

	public static final Set<Character> num = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'));

	public static void main(String[] args) {
		String text = "2[A2[cd]B]";
//		String text = "2[abc]3[AB]ef";
		String value = process(text);
		System.out.println("value: " + value);
	}

	private static String process(String text) {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while (index < text.length()) {
			index = decode(index, text, sb);
		}
		return sb.toString();
	}

	private static int decode(int index, String text, StringBuilder sb) {
		StringBuilder numString = new StringBuilder();
		while (num.contains(text.charAt(index))) {
			numString.append(text.charAt(index));
			index++;
		}
		int numLoop = numString.toString().isEmpty() ? 0 : Integer.parseInt(numString.toString());
		if (numLoop > 0) {
			index++; // next [
			StringBuilder subText = new StringBuilder();
			char charAt;
			while (index < text.length() && ((charAt = text.charAt(index)) != ']')) {
				if (num.contains(charAt)) {
					StringBuilder subText2 = new StringBuilder();
					index = decode(index, text, subText2);
					subText.append(subText2.toString());
					index--;
				} else {
					subText.append(charAt);
				}
				index++;
			}
			for (int i = 0; i < numLoop; i++) {
				sb.append(subText.toString());
			}
		} else {
			sb.append(text.charAt(index));
		}
		index++; // next ] (num loop > 0) or next index
		return index;
	}

}
