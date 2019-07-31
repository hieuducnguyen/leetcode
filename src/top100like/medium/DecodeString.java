/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author hieund3
 */
public class DecodeString {

	public static final Set<Character> num = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'));
	public static final Map<Character, Integer> numMap = new HashMap<>();

	static {
		numMap.put('1', 1);
		numMap.put('2', 2);
		numMap.put('3', 3);
		numMap.put('4', 4);
		numMap.put('5', 5);
		numMap.put('6', 6);
		numMap.put('7', 7);
		numMap.put('8', 8);
		numMap.put('9', 9);
		numMap.put('0', 0);
	}

	public static void main(String[] args) {
		String text = "2[A2[cd]B]";
		String value = process1(text);
		System.out.println("value: " + value);
	}

	private static String process1(String text) {
		if (text == null || text.isEmpty()) {
			return text;
		}
		Stack<Integer> numberStack = new Stack<>();
		Stack<Character> textStack = new Stack<>();
		char[] arrChar = text.toCharArray();
		int index = 0;
		while (index < arrChar.length) {
			if (isNumber(arrChar[index])) {
				Result result = getNumber(index, arrChar);
				numberStack.add(result.value);
				index = result.index;
			} else if (arrChar[index] == ']') {
				Character item;
				StringBuilder sb = new StringBuilder();
				while ((item = textStack.pop()) != '[') {
					sb.append(item);
				}
				Integer number = numberStack.pop();
				for (int i = 0; i < number; i++) {
					for (int j = sb.toString().length() - 1; j >= 0; j--) {
						textStack.add(sb.charAt(j));
					}
				}
			} else {
				textStack.add(arrChar[index]);
			}
			index++;
		}
		StringBuilder sb = new StringBuilder();
		while (!textStack.isEmpty()) {
			sb.append(textStack.pop());
		}
		return sb.reverse().toString();
	}

	private static boolean isNumber(Character character) {
		return numMap.keySet().contains(character);
	}

	private static Result getNumber(int start, char[] arrChar) {
		int result = 0;
		int i = start;
		while (i < arrChar.length) {
			if (isNumber(arrChar[i])) {
				result *= 10;
				result += numMap.get(arrChar[i]);
			} else {
				break;
			}
			i++;
		}

		return new Result(result, --i);
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

	private static class Result {

		int value;
		int index;

		public Result(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

}
