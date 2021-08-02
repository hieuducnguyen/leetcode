package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Created by hieund3 on 15/07/2021
 */
public class _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
	public static final _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit INSTANCE =
		new _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit();

	public int longestSubarray(int[] nums, int limit) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		Deque<Integer> maxQueue = new ArrayDeque<>();
		Deque<Integer> minQueue = new ArrayDeque<>();
		int startWindow = 0, endWindow = 0, len = Integer.MIN_VALUE;
		while (endWindow < nums.length) {
			while (!maxQueue.isEmpty() && maxQueue.getLast() < nums[endWindow]) {
				maxQueue.pollLast();
			}
			maxQueue.addLast(nums[endWindow]);

			while (!minQueue.isEmpty() && minQueue.getLast() > nums[endWindow]) {
				minQueue.pollLast();
			}
			minQueue.addLast(nums[endWindow]);

			while (maxQueue.getFirst() - minQueue.getFirst() > limit) {
				if (nums[startWindow] == maxQueue.getFirst()) {
					maxQueue.pollFirst();
				}
				if (nums[startWindow] == minQueue.getFirst()) {
					minQueue.pollFirst();
				}
				startWindow++;
			}
			len = Math.max(len, endWindow - startWindow + 1);
			endWindow++;
		}
		return len;
	}
}
