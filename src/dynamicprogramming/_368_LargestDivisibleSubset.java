package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Created by hieund3 on 21/07/2021
 */
public class _368_LargestDivisibleSubset {
	public static final _368_LargestDivisibleSubset INSTANCE = new _368_LargestDivisibleSubset();

	public List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		Struct[] struct = new Struct[nums.length];
		for (int i = 0; i < struct.length; i++) {
			struct[i] = new Struct(-1, 1);
		}
		int max = Integer.MIN_VALUE, maxIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0) {
					if (struct[j].max + 1 > struct[i].max) {
						struct[i].max = struct[j].max + 1;
						struct[i].prePos = j;
					}
				}
			}
			if (struct[i].max > max) {
				max = struct[i].max;
				maxIndex = i;
			}
		}
		List<Integer> result = new ArrayList<>();
		while (maxIndex >= 0) {
			result.add(nums[maxIndex]);
			maxIndex = struct[maxIndex].prePos;
		}
		return result;
	}

	class Struct {
		int prePos;
		int max;

		public Struct(int prePos, int max) {
			this.prePos = prePos;
			this.max = max;
		}
	}
}
