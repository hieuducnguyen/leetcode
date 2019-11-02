/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

/**
 *
 * @author hieund3
 */
public class FindPeakElement {

	static FindPeakElement INSTANCE = new FindPeakElement();

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		int index = INSTANCE.findPeakElement(nums);
		System.out.println("index: " + index);
	}

	public int findPeakElement(int[] nums) {
		int l = 0, r = nums.length, m;
		while (l < r) {
			m = (l + r) / 2;
			if ((m - 1 < 0 || nums[m - 1] < nums[m])
				&& (m + 1 >= nums.length || nums[m] > nums[m + 1])) {
				return m;
			} else if ((m - 1 < 0) || (nums[m - 1] < nums[m])) {
				l = m;
			} else {
				r = m;
			}
		}
		return -1;
	}
}
