
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author hieund3
 */
public class WordLadder {

	private static final WordLadder INSTANCE = new WordLadder();

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
		int ladderLength = INSTANCE.ladderLength(beginWord, endWord, wordList);
		System.out.println("ladderLength: " + ladderLength);
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		List<String> words = new ArrayList<>(wordList);
		words.add(beginWord);
		Map<String, Set<String>> map = new HashMap<>();
		for (int i = 0; i < words.size(); i++) {
			for (int j = 0; j < words.size(); j++) {
				if (i == j) {
					continue;
				}
				if (canChange(words.get(i), words.get(j))) {
					map.merge(words.get(i), new HashSet<>(Arrays.asList(words.get(j))), (t, v)
						-> {
						t.addAll(v);
						return t;
					});
				}
			}
		}
		System.out.println("map: " + map);
		Set<String> visited = new HashSet<>();
		int shortestPath = shortestPath(beginWord, endWord, map, visited);
		return shortestPath;
	}

	public static boolean canChange(String begin, String end) {
		int compare = 0;
		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) == end.charAt(i)) {
				compare++;
			}
		}
		return compare == begin.length() - 1;
	}

	private int shortestPath(String beginWord, String endWord,
		Map<String, Set<String>> graph, Set<String> visited) {
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		visited.add(beginWord);
		int level = 0;
		boolean found = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;
			System.out.println("queue: " + queue);
			for (int i = 0; i < size; i++) {
				String temp = queue.poll();
				visited.add(temp);
				if (temp.equalsIgnoreCase(endWord)) {
					found = true;
					break;
				}
				Set<String> adj = graph.get(temp);
				if (adj != null && !adj.isEmpty()) {
					for (String vertex : adj) {
						if (visited.contains(vertex)) {
							continue;
						}
						queue.add(vertex);
					}
				}
			}
			if (found) {
				break;
			}
		}
		return found ? level : 0;
	}
}
