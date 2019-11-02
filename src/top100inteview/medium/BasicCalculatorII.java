/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Stack;

/**
 *
 * @author hieund3
 */
public class BasicCalculatorII {

//	private static List<Character> operator = Arrays.asList('.');
//	private static List<Character> num = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
	public static void main(String[] args) {
		String expression = " 2048-20*2";
		int result = calculate2(expression);
		System.out.println(result);
	}

	public static int calculate2(String expression) {
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		String stimExp = expression.replaceAll(" ", "");
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(stimExp);
		Character sign = '+';
		while (matcher.find()) {
			String valueString = matcher.group();
			int value = Integer.parseInt(valueString);
			switch (sign) {
				case '+': {
					stack.push(value);
					break;
				}
				case '-': {
					stack.push(-value);
					break;
				}
				case '*': {
					Integer preValue = stack.pop();
					stack.push(preValue * value);
					break;
				}
				case '/': {
					Integer preValue = stack.pop();
					stack.push(preValue / value);
					break;
				}
			}
			final int end = matcher.end();
			if (end < stimExp.length()) {
				sign = stimExp.charAt(end);
			}
		}

		for (Integer value : stack) {
			result += value;
		}
		return result;
	}

	public static int calculate(String expression) {
		String strimExp = expression.replaceAll(" ", "").replaceAll("-", "+-");
		String[] exps = strimExp.split("\\+");
		int[] values = new int[exps.length];
		int result = 0;
		for (int i = 0; i < exps.length; i++) {
			values[i] = calculateExp(exps[i]);
		}
		for (int i = 0; i < exps.length; i++) {
			result += values[i];
		}
		return result;
	}

	public static int calculateExp(String expression) {
		Pattern compile = Pattern.compile("-?\\d");
		Matcher matcher = compile.matcher(expression);
		matcher.find();
		String value1String = matcher.group();
		int value1 = Integer.parseInt(value1String);
		int lastIndex = matcher.end();
		while (matcher.find()) {
			String group = matcher.group();
			int value = Integer.parseInt(group);
			if (expression.charAt(lastIndex) == '*') {
				value1 *= value;
			} else {
				value1 /= value;
			}
			lastIndex = matcher.end();
		}
		return value1;
	}
}
