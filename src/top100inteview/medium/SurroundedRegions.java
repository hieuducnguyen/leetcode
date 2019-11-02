/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import java.util.Arrays;

/**
 *
 * @author hieund3
 */
public class SurroundedRegions {

	static SurroundedRegions INSTANCE = new SurroundedRegions();

	public static void main(String[] args) {
		char[][] board = {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
		basic.BasicTest.printMatrix(board);
		INSTANCE.solve(board);
		System.out.println("------------------------------");
		basic.BasicTest.printMatrix(board);

	}

	public void solve(char[][] board) {
		if (board.length <= 2 || board[0].length <= 2) {
			return;
		}
		for (int i = 0; i < board.length; i++) {
			mark(i, 0, board);
			mark(i, board[0].length - 1, board);
		}
		for (int i = 0; i < board[0].length; i++) {
			mark(0, i, board);
			mark(board.length - 1, i, board);
		}
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				if (board[i][j] == '-') {
//					board[i][j] = 'O';
//				} else if (board[i][j] != 'X') {
//					board[i][j] = 'X';
//				}
//			}
//		}
	}

	private void mark(int x, int y, char[][] board) {
		if (board[x][y] == 'X') {
			return;
		}
		board[x][y] = '-';
		int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		for (int i = 0; i < directions.length; i++) {
			int newX = x + directions[i][0];
			int newY = y + directions[i][1];
			if (isOnBoard(newX, newY, board) && board[newX][newY] == 'O') {
				board[newX][newY] = '-';
				mark(newX, newY, board);
			}
		}
	}

	private boolean isOnBoard(int x, int y, char[][] board) {
		return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
	}
}
