package dynamicprogramming;

/*
 * Created by hieund3 on 18/06/2021
 */
public class _338_CountingBits {
	public static final _338_CountingBits INSTANCE = new _338_CountingBits();

	public int[] countBits(int n) {
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i >> 1] + (i & 1);
		}
		return arr;
	}

	public static void main(String[] args) {
		int a = 5 + (3 & 1);
		System.out.println("a = " + a);
	}


	public int[] countBits1(int n) {
		if (n == 0) {
			return new int[]{0};
		}
		int[] arr = new int[n + 1];
		arr[1] = 1;
		int i = 2, k = 0;
		while (i <= n) {
			final double x = Math.log(i) / Math.log(2);
			final boolean isInteger = isInteger(x);
			if (isInteger) {
				k = i;
			}
			arr[i] = arr[i - k] + 1;
			i++;
		}
		return arr;
	}

	public boolean isInteger(double x) {
		return Math.floor(x) == x;
	}
}
