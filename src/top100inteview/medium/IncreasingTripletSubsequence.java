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
public class IncreasingTripletSubsequence {

	static IncreasingTripletSubsequence INSTANCE = new IncreasingTripletSubsequence();

	public static void main(String[] args) {
		int[] nums = {5, 6, 1, 2, -2, -1, 7};
		boolean increasingTriplet = INSTANCE.increasingTriplet(nums);
		System.out.println("increasingTriplet: " + increasingTriplet);
	}

	public boolean increasingTriplet(int[] nums) {
		int a1 = 0, a2 = 0;
		int size = 0;
		for (int i = 0; i < nums.length; i++) {
			switch (size) {
				case 0:
					a1 = nums[i];
					size++;
					break;
				case 1:
					if (nums[i] > a1) {
						a2 = nums[i];
						size++;
					} else {
						a1 = nums[i];
					}
					break;
				case 2:
					if (nums[i] > a2) {
						return true;
					} else if (a1 < nums[i]) {
						a2 = nums[i];
					} else {
						a1 = nums[i];
					}
					break;
			}
		}
		return false;
	}
}
