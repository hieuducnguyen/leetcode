package top100inteview.easy;

/*
 * Created by hieund3 on 06/07/2021
 */
public class _136_SingleNumber {
	public static final _136_SingleNumber INSTANCE = new _136_SingleNumber();

	public int singleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i];
		}
		return result;
	}
}
