/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

/**
 *
 * @author hieund3
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int ret = process(height);
		System.out.println("ret: " + ret);
	}

	private static int process(int[] height) {
		if (height.length <= 2) {
			return 0;
		}
		int[] hL = new int[height.length];
		hL[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			hL[i] = Math.max(hL[i - 1], height[i]);
		}
		int[] hR = new int[height.length];
		hR[height.length - 1] = height[height.length - 1];
		for (int i = hL.length - 2; i >= 0; i--) {
			hR[i] = Math.max(hR[i + 1], height[i]);
		}
		int result = 0;
		for (int i = 1; i < height.length - 1; i++) {
			int value = Math.min(hL[i - 1], hR[i + 1]);
			int water = value - height[i] > 0 ? value - height[i] : 0;
			result += water;
		}
		return result;
	}
}
