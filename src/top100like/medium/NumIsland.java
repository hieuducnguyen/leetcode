/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

/**
 *
 * @author hieund3
 */
public class NumIsland {

	public static void main(String[] args) {
		char[][] grid = new char[][]{{'1', '1', '1', '1', '0'},
		{'1', '1', '0', '1', '0'},
		{'1', '1', '0', '0', '0'},
		{'0', '0', '0', '0', '0'}};

		int value = process(grid);
		System.out.println("value: " + value);
	}

	private static int process(char[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		int numIsland = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					expand(i, j, grid);
					numIsland++;
				}
			}
		}
		return numIsland;
	}

	private static void expand(int i, int j, char[][] grid) {
		if (i >= 0 && j >= 0
			&& i <= (grid.length - 1) && j <= (grid[0].length - 1) && grid[i][j] == '1') {
			grid[i][j] = '-';
			expand(i + 1, j, grid);
			expand(i - 1, j, grid);
			expand(i, j + 1, grid);
			expand(i, j - 1, grid);
		}
	}
}
