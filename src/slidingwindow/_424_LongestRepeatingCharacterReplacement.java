package slidingwindow;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by hieund3 on 18/07/2021
 */
public class _424_LongestRepeatingCharacterReplacement {
	public static final _424_LongestRepeatingCharacterReplacement INSTANCE =
		new _424_LongestRepeatingCharacterReplacement();

	public int lengthOfLIS(int[] nums) {
		List<Integer> increaseList = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = binSearch(increaseList, nums[i]);
			if (index == increaseList.size()) {
				increaseList.add(nums[i]);
			} else {
				increaseList.set(index, nums[i]);
			}
		}
		return increaseList.size();
	}

	private int binSearch(List<Integer> list, int num) {
		int l = 0, r = list.size(), m;
		while (l < r) {
			m = (l + r) / 2;
			if (list.get(m) == num) {
				return m;
			} else if (list.get(m) < num) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return l;
	}
}
