/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.Arrays;

/**
 *
 * @author hieund3
 */
public class ProductOfArrExceptSelf {

	public static void main(String[] args) {
		int[] num = new int[]{1, 2, 4, 4, 1};
		int[] result = process(num);
		basic.BasicTest.printArrayInt(result);
	}

	private static int[] process(int[] num) {
		int[] result = new int[num.length];
		result[0] = 1;
		result[num.length - 1] = 1;
		int numZero = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0) {
				numZero++;
			}
			if (i != 0) {
				result[i] = (num[i - 1] * result[i - 1]);
			}
		}
		if (numZero >= 2) {
			Arrays.fill(result, 0);
			return result;
		} else if (numZero == 1) {
			int ret = 1, pos = 0;
			for (int i = 0; i < num.length; i++) {
				if (num[i] != 0) {
					ret *= num[i];
				} else {
					pos = i;
				}
			}
			Arrays.fill(result, 0);
			result[pos] = ret;
			return result;
		}
		int R = 1;
		for (int i = num.length - 2; i >= 0; i--) {
			R *= num[i + 1];
			result[i] *= R;
		}
		return result;
	}

	public int[] productExceptSelf(int[] nums) {

		// The length of the input array 
		int length = nums.length;

		// Final answer array to be returned
		int[] answer = new int[length];

		// answer[i] contains the product of all the elements to the left
		// Note: for the element at index '0', there are no elements to the left,
		// so the answer[0] would be 1
		answer[0] = 1;
		for (int i = 1; i < length; i++) {

			// answer[i - 1] already contains the product of elements to the left of 'i - 1'
			// Simply multiplying it with nums[i - 1] would give the product of all 
			// elements to the left of index 'i'
			answer[i] = nums[i - 1] * answer[i - 1];
		}

		// R contains the product of all the elements to the right
		// Note: for the element at index 'length - 1', there are no elements to the right,
		// so the R would be 1
		int R = 1;
		for (int i = length - 1; i >= 0; i--) {

			// For the index 'i', R would contain the 
			// product of all elements to the right. We update R accordingly
			answer[i] = answer[i] * R;
			R *= nums[i];
		}

		return answer;
	}
}
