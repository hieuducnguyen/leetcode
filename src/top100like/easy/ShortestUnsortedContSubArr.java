/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author hieund3
 */
public class ShortestUnsortedContSubArr {

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 4, 2};
		int len = process(arr);
		System.out.println("len: " + len);
	}

	public int findUnsortedSubarray(int[] nums) {
		Stack< Integer> stack = new Stack<>();
		int l = nums.length, r = 0;
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
				l = Math.min(l, stack.pop());
			}
			stack.push(i);
		}
		stack.clear();
		for (int i = nums.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				r = Math.max(r, stack.pop());
			}
			stack.push(i);
		}
		return r - l > 0 ? r - l + 1 : 0;
	}

	private static int process(int[] arr) {
		int start = Integer.MAX_VALUE, end = -1;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> tmpStack = new Stack<>();
		stack.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (stack.peek() <= arr[i]) {
				stack.add(arr[i]);
			} else {
				while (!stack.isEmpty()) {
					Integer value = stack.peek();
					if (value > arr[i]) {
						tmpStack.add(stack.pop());
					} else {
						break;
					}
				}
				start = Math.min(i - tmpStack.size(), start);
				end = i;
				stack.add(arr[i]);
				while (!tmpStack.isEmpty()) {
					stack.add(tmpStack.pop());
				}
			}
		}
		return start != Integer.MAX_VALUE ? end - start + 1 : 0;
	}

	private static int process1(int[] arr) {
		int[] tmpArr = arr.clone();
		Arrays.sort(tmpArr);
		int start = -1, end = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != tmpArr[i]) {
				if (start == -1) {
					start = i;
				}
				end = i;
			}
		}
		return start != -1 ? end - start + 1 : 0;
	}

}
