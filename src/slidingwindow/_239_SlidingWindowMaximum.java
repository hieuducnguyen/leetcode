package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Created by hieund3 on 17/07/2021
 */
public class _239_SlidingWindowMaximum {
	public static final _239_SlidingWindowMaximum INSTANCE = new _239_SlidingWindowMaximum();

	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		Deque<Integer> maxQueue = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			while (!maxQueue.isEmpty() && maxQueue.getLast() < nums[i]) {
				maxQueue.pollLast();
			}
			maxQueue.addLast(nums[i]);
			if (i >= k - 1) {
				result[i - k + 1] = maxQueue.getFirst();
				if (nums[i - k + 1] == maxQueue.getFirst()) {
					maxQueue.pollFirst();
				}
			}
		}
		return result;
	}

	public int[] maxSlidingWindow1(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		Deque<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			while (!queue.isEmpty() && queue.getFirst() < nums[i]) {
				queue.pollFirst();
			}
			while (!queue.isEmpty() && queue.getLast() < nums[i]) {
				queue.pollLast();
			}
			queue.addLast(nums[i]);
			if (i >= k - 1) {
				result[i - k + 1] = queue.getFirst();
				if (nums[i - k + 1] == queue.getFirst()) {
					queue.pollFirst();
				}
			}
		}
		return result;
	}
}
