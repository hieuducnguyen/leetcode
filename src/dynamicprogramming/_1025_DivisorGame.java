package dynamicprogramming;

/*
 * Created by hieund3 on 19/06/2021
 */
public class _1025_DivisorGame {
	public static final _1025_DivisorGame INSTANCE = new _1025_DivisorGame();

	public boolean divisorGame(int n) {
		int x = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				x++;
			}
		}
		return x % 2 != 0;
	}
}
