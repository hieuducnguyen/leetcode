package top100inteview.easy;

/*
 * Created by hieund3 on 01/07/2021
 */
public class _26_RemoveDuplicatesFromSortedArray {
	public static final _26_RemoveDuplicatesFromSortedArray INSTANCE = new _26_RemoveDuplicatesFromSortedArray();

	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int length = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[length]) {
				length++;
				nums[length] = nums[i];
			}
		}
		return length + 1;
	}
}
