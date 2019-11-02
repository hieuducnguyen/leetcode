/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import java.util.Stack;

/**
 *
 * @author hieund3
 */
public class ShortestUnsortedContSubArr {

	static ShortestUnsortedContSubArr INSTANCE = new ShortestUnsortedContSubArr();

	public static void main(String[] args) {
//		int[] arr = {0, 1, 3, 5, 4, 2, 9, 10, 0};
		int[] arr = {-2, 1, 6, 1, 1, -1, 3};
		int len = INSTANCE.findUnsortedSubarray(arr);
		System.out.println("len: " + len);
	}

	private int findUnsortedSubarray(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		int l = nums.length;
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
				stack.pop();
				l = Math.min(l, stack.size());
			}
			stack.add(i);
		}
		int r = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				stack.pop();
				r = Math.max(r, nums.length - stack.size() - 1);
			}
			stack.add(i);
		}
		return r - l > 0 ? r - l + 1 : 0;
	}
}
