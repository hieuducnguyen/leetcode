/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hieund3
 */
public class ValidSudoku {

	int[][] DIRECTION = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	static ValidSudoku INSTANCE = new ValidSudoku();

	public static void main(String[] args) {
		char[][] board = {
			{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		boolean validSudoku = INSTANCE.isValidSudoku(board);
		System.out.println("validSudoku: " + validSudoku);
	}

	public boolean isValidSudoku(char[][] board) {
		String rowFormat = "(%s)%s";
		String columnFormat = "%s(%s)";
		String partFormat = "(%s)%s(%s)";
		Set<String> seen = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != '.') {
					String row = String.format(rowFormat, i, board[i][j]);
					String column = String.format(columnFormat, board[i][j], j);
					String part = String.format(partFormat, i / 3, board[i][j], j / 3);
					if (seen.contains(row) || seen.contains(column) || seen.contains(part)) {
						return false;
					} else {
						seen.add(row);
						seen.add(column);
						seen.add(part);
					}
				}
			}
		}
		return true;
	}
}
