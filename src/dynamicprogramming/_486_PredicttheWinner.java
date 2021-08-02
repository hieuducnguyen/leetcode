package dynamicprogramming;

/*
 * Created by hieund3 on 30/07/2021
 */
public class _486_PredicttheWinner {
	public static final _486_PredicttheWinner INSTANCE = new _486_PredicttheWinner();

	public boolean PredictTheWinner(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return true;
		}
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		int scorePlayer1 = getMaxScore(nums, 0, nums.length - 1, true, Integer.MAX_VALUE, Integer.MAX_VALUE, 0,
			0);
		return scorePlayer1 >= (sum - scorePlayer1);
	}

	private int getMaxScore(int[] nums, int start, int end, boolean player1, int alpha, int beta, int scorePlayer1,
							int scorePlayer2) {

		return 0;
	}

	private boolean predictTheWinner1(int[] nums, int start, int end, boolean player1, int alpha, int beta,
									  int scorePlayer1, int scorePlayer2) {
		if (start == end) {
			if (player1) {
				scorePlayer1 += nums[start];
			} else {
				scorePlayer2 += nums[start];
			}
			return scorePlayer1 >= scorePlayer2;
		}
		if (player1) {
			boolean result;
			result = predictTheWinner1(nums, start + 1, end, false, alpha, beta,
				scorePlayer1 + nums[start], scorePlayer2)
				|| predictTheWinner1(nums, start, end - 1, false, alpha, beta,
				scorePlayer1 + nums[end], scorePlayer2);
			return result;
		} else {
			boolean result;
			result = predictTheWinner1(nums, start + 1, end, true, alpha, beta,
				scorePlayer1, scorePlayer2 + nums[start])
				&& predictTheWinner1(nums, start, end - 1, true, alpha, beta,
				scorePlayer1, scorePlayer2 + nums[end]);
			return result;
		}
	}


}
