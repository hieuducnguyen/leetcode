/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author hieund3
 */
public class EvaluateReversePolishNotation {

	static EvaluateReversePolishNotation INSTANCE = new EvaluateReversePolishNotation();

	public static void main(String[] args) {
		String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		int evalRPN = INSTANCE.evalRPN(tokens);
		System.out.println("evalRPN: " + evalRPN);
	}

	public int evalRPN(String[] tokens) {
		Set<String> operation = new HashSet<>();
		operation.add("+");
		operation.add("-");
		operation.add("*");
		operation.add("/");
		Stack<Integer> stack = new Stack();
		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];
			if (operation.contains(token)) {
				Integer firstVal = stack.pop();
				Integer secondVal = stack.pop();
				int value = compute(firstVal, secondVal, token);
				stack.add(value);

			} else {
				stack.add(Integer.parseInt(token));
			}
		}
		return stack.peek();
	}

	private int compute(Integer firstVal, Integer secondVal, String token) {
		switch (token) {
			case "*":
				return secondVal * firstVal;
			case "/":
				return secondVal / firstVal;
			case "+":
				return secondVal + firstVal;
			case "-":
				return secondVal - firstVal;
		}
		return 0;
	}
}
