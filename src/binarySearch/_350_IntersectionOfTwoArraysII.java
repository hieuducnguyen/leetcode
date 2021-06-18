package binarySearch;

import java.util.Arrays;

/*
 * Created by hieund3 on 13/06/2021
 */
public class _350_IntersectionOfTwoArraysII {
	public static final _350_IntersectionOfTwoArraysII INSTANCE = new _350_IntersectionOfTwoArraysII();


	public int[] intersect(int[] nums1, int[] nums2) {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int num : nums1) {
			max = Integer.max(num, max);
			min = Integer.min(num, min);
		}
		for (int num : nums2) {
			max = Integer.max(num, max);
			min = Integer.min(num, min);
		}
		int[] nums = new int[max - min + 1];
		for (int num : nums1) {
			nums[num - min] += 1;
		}
		int idx = 0;
		int[] result = new int[max - min + 1];
		for (int num : nums2) {
			if (nums[num - min] > 0) {
				result[idx++] = num;
				nums[num - min]--;
			}
		}
		return Arrays.copyOf(result, idx);
	}

	public int[] intersect1(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int walker1 = 0, walker2 = 0;
		int[] result = new int[nums1.length];
		int idx = 0;
		while (walker1 < nums1.length && walker2 < nums2.length) {
			if (nums1[walker1] == nums2[walker2]) {
				result[idx++] = nums1[walker1];
				walker1++;
				walker2++;
			} else if (nums1[walker1] < nums2[walker2]) {
				walker1++;
			} else {
				walker2++;
			}
		}
		return Arrays.copyOf(result, idx);
	}
}
