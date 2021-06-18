package binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Created by hieund3 on 12/06/2021
 */
public class _349_IntersectionOfTwoArrays {
	public static final _349_IntersectionOfTwoArrays INSTANCE = new _349_IntersectionOfTwoArrays();

	public int[] intersection1(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		final Set<Integer> integers = new HashSet<>();
		int walker1 = 0, walker2 = 0;
		while (walker1 < nums1.length && walker2 < nums2.length) {
			if (nums1[walker1] == nums2[walker2]) {
				integers.add(nums1[walker1]);
				walker1++;
				walker2++;
			} else if (nums1[walker1] < nums2[walker2]) {
				walker1++;
			} else {
				walker2++;
			}
		}
		return integers.stream().mapToInt(Integer::intValue).toArray();
	}

	public int[] intersection2(int[] nums1, int[] nums2) {
		final Set<Integer> set1 = new HashSet<>();
		final Set<Integer> set2 = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set1.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (set1.contains(nums2[i])) {
				set2.add(nums2[i]);
			}
		}
		return set2.stream().mapToInt(i -> i).toArray();
	}

	public int[] intersection(int[] nums1, int[] nums2) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int j : nums1) {
			max = Math.max(max, j);
			min = Math.min(min, j);
		}
		for (int j : nums2) {
			max = Math.max(max, j);
			min = Math.min(min, j);
		}
		boolean[] arr = new boolean[max - min + 1];
		for (int i = 0; i < nums1.length; i++) {
			arr[nums1[i] - min] = true;
		}
		int[] result = new int[max - min + 1];
		int index = 0;
		for (int i = 0; i < nums2.length; i++) {
			if (arr[nums2[i] - min]) {
				result[index++] = nums2[i];
				arr[nums2[i] - min] = false;
			}
		}
		return Arrays.copyOf(result, index);
	}
}
