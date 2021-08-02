package slidingwindow;

/*
 * Created by hieund3 on 11/07/2021
 */
public class SmallestSubArrayGivenSum {
	public static final SmallestSubArrayGivenSum INSTANCE = new SmallestSubArrayGivenSum();

	public int smallestSubArray(int[] arr, int k) {
		int startWindow = 0, tempSum = 0, smallestSize = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			tempSum += arr[i];
			while (tempSum >= k) {
				smallestSize = Math.min(smallestSize, i - startWindow + 1);
				tempSum -= arr[startWindow];
				startWindow++;
			}
		}
		return smallestSize;
	}
}
