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
public class TestGreater {

	static int search(int[] nums, int target) {
		int l = 0, r = nums.length, m;
		while (l < r) {
			m = (l + r) / 2;
			if (nums[m] >= target) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 4, 5, 6, 7};
		int result = search(nums, 3);
		System.out.println(result);
	}
}
