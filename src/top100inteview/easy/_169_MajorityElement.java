package top100inteview.easy;

/*
 * Created by hieund3 on 09/07/2021
 */
public class _169_MajorityElement {
	public static final _169_MajorityElement INSTANCE = new _169_MajorityElement();

	public int majorityElement(int[] nums) {
		int candidate = 0, count = 0;
		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (candidate == num) ? 1 : -1;
		}
		return candidate;
	}
}
