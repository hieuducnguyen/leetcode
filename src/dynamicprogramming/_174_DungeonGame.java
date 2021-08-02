package dynamicprogramming;

/*
 * Created by hieund3 on 31/07/2021
 */
public class _174_DungeonGame {
	public static final _174_DungeonGame INSTANCE = new _174_DungeonGame();

	public int calculateMinimumHP(int[][] dungeon) {
		int[][] minHealthy = new int[dungeon.length + 1][dungeon[0].length + 1];
		for (int i = 0; i < dungeon.length + 1; i++) {
			minHealthy[i][dungeon[0].length] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < dungeon[0].length + 1; i++) {
			minHealthy[dungeon.length][i] = Integer.MAX_VALUE;
		}
		for (int i = dungeon.length - 1; i >= 0; i--) {
			for (int j = dungeon[0].length - 1; j >= 0; j--) {
				if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
					minHealthy[i][j] = -dungeon[i][j];
				} else {
					minHealthy[i][j] = Math.max(Math.min(minHealthy[i][j + 1],
						minHealthy[i + 1][j]) - dungeon[i][j], 0);
				}
				if (minHealthy[i][j] + dungeon[i][j] <= 0) {
					minHealthy[i][j] += (1 - minHealthy[i][j] - dungeon[i][j]);
				}
			}
		}
		return Math.max(minHealthy[0][0], 1);
	}
}
