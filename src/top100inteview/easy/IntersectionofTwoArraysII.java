/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hieund3
 */
public class IntersectionofTwoArraysII {

	public static final IntersectionofTwoArraysII INTANCE = new IntersectionofTwoArraysII();

	public static void main(String[] args) {
		int[] nums1 = {4, 9, 5};
		int[] nums2 = {9, 4, 9, 8, 4};
		int[] intersect = INTANCE.intersect(nums1, nums2);
		basic.BasicTest.printArray(intersect);
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			map.merge(nums1[i], 1, (t, v) -> (t + v));
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i])) {
				map.computeIfPresent(nums2[i], (t, v) -> {
					if (v > 1) {
						return --v;
					} else {
						return null;
					}
				});
				list.add(nums2[i]);
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}
