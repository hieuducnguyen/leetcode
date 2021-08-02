package array;

/*
 * Created by hieund3 on 26/06/2021
 */
public class _189_RotateArray {
	public static final _189_RotateArray INSTANCE = new _189_RotateArray();

	public void rotate1(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0) {
			return;
		}
		k = k % nums.length;
		int[] rotatedNums = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			rotatedNums[(i + k) % nums.length] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = rotatedNums[i];
		}
	}

	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0) {
			return;
		}
		k = k % nums.length;

	}
}

