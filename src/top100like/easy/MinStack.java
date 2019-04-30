/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package top100like.easy;

/**
 *
 * @author hieund3
 */
public class MinStack {

	class Stack {

		private int[] arr = new int[1000];
		private int index = -1;

		public void push(int x) {
			arr[++index] = x;
		}

		public void pop() {
			if (index >= 0) {
				index--;
			}
		}

		public int top() {
			if (index >= 0) {
				return arr[index];
			}
			return Integer.MAX_VALUE;
		}
	}

	private int[] arr = new int[1000];
	private int index = -1;
	private Stack stack = new Stack();

	public MinStack() {
	}

	public void push(int x) {
		arr[++index] = x;
		if (x > stack.top()) {
			stack.push(stack.top());
		} else {
			stack.push(x);
		}
	}

	public void pop() {
		if (index >= 0) {
			index--;
		}
		stack.pop();
	}

	public int top() {
		if (index >= 0) {
			return arr[index];
		}
		return Integer.MAX_VALUE;
	}

	public int getMin() {
		return stack.top();
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		int min = minStack.getMin();
		System.out.println("min: " + min);
		minStack.pop();
		minStack.top();
		int min1 = minStack.getMin();
		System.out.println("min1: " + min1);
	}
}
