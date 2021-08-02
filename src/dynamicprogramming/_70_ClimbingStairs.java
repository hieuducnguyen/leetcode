package dynamicprogramming;

/*
 * Created by hieund3 on 19/06/2021
 */
public class _70_ClimbingStairs {
	public static final _70_ClimbingStairs INSTANCE = new _70_ClimbingStairs();

	public int climbStairs(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n <= 2) {
			return n;
		}
		int prePreClimbStairs = 1, preClimbStairs = 2, climStairs = 0;
		for (int i = 3; i <= n; i++) {
			climStairs = preClimbStairs + prePreClimbStairs;
			prePreClimbStairs = preClimbStairs;
			preClimbStairs = climStairs;
		}
		return climStairs;
	}
}
