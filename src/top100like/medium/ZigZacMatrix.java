/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class ZigZacMatrix {

	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static final int DOWN_RIGHT = 4;
	public static final int UP_LEFT = 5;

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1, 3, 4, 10}, {2, 5, 9, 11}, {6, 8, 12, 15}, {7, 13, 14, 16}};
		List<Integer> result = zigzacMatrix(matrix);
		System.out.println(result);
	}

	private static List<Integer> zigzacMatrix(int[][] matrix) {

		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		int R = matrix.length, C = matrix[0].length;
		int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {-1, 1}, {1, -1}};
		int r = 0, c = 0;
		int dr = 1, dc = 0;
		result.add(matrix[r][c]);
		for (int i = 0; i < R * C - 1; i++) {
			r += dr;
			c += dc;
			result.add(matrix[r][c]);
			if (dr == direction[UP][0] && dc == direction[UP][1]) {
				if (c + direction[DOWN_RIGHT][1] < C) {
					dr = direction[DOWN_RIGHT][0];
					dc = direction[DOWN_RIGHT][1];
				} else {
					dr = direction[UP_LEFT][0];
					dc = direction[UP_LEFT][1];
				}
				continue;
			}
			if (dr == direction[DOWN_RIGHT][0] && dc == direction[DOWN_RIGHT][1]) {
				if (r + dr < 0 || c + dc >= C) {
					if (c + direction[RIGHT][1] < C) {
						dr = direction[RIGHT][0];
						dc = direction[RIGHT][1];
					} else {
						dr = direction[UP][0];
						dc = direction[UP][1];
					}
				}
				continue;
			}
			if (dr == direction[RIGHT][0] && dc == direction[RIGHT][1]) {
				if (r + direction[UP_LEFT][0] < R) {
					dr = direction[UP_LEFT][0];
					dc = direction[UP_LEFT][1];

				} else {
					dr = direction[DOWN_RIGHT][0];
					dc = direction[DOWN_RIGHT][1];
				}
				continue;
			}
			if (dr == direction[UP_LEFT][0] && dc == direction[UP_LEFT][1]) {
				if (r + dr >= R || c + dc < 0) {
					if (r + direction[UP][0] < R) {
						dr = direction[UP][0];
						dc = direction[UP][1];
					} else {
						dr = direction[RIGHT][0];
						dc = direction[RIGHT][1];
					}
				}
				continue;
			}
		}
		return result;
	}
}
