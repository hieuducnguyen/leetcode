/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

/**
 *
 * @author hieund3
 */
public class TestSearch {

	static int search(int[] nums, int target) {
		int l = 0, r = nums.length, m;
		while (l < r) {
			m = (l + r) / 2;
			int num = !(nums[m] < nums[0] ^ target < nums[0])
				? nums[m] : (target < nums[0]) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			if (num < target) {
				l = m + 1;
			} else if (num > target) {
				r = m;
			} else {
				return m;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {7, 0, 1, 2};
//		int[] nums = {1, 2, 3, 4, 5};
		int result = search(nums, 7);
		System.out.println(result);
	}
}
