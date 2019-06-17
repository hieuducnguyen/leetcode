/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author hieund3
 */
public class TaskScheduler {

	public static void main(String[] args) {
		char[] task = new char[]{'A', 'A', 'A', 'B','B','B'};
		int inteverval = 2;
		int result = process(task, inteverval);
		System.out.println("result: " + result);
	}

	private static int process(char[] charArray, int interval) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < charArray.length; i++) {
			map.merge(charArray[i], 1, (u, v) -> (u + 1));
		}
		PriorityQueue<Task> pq = new PriorityQueue();
		map.forEach((u, v) -> {
			pq.add(new Task(u, v, 0));
		});
		int numTask = charArray.length;
		int time = 0;
		StringBuilder sb = new StringBuilder();
		while (numTask != 0) {
			Queue<Task> queue = new LinkedList<>();
			Task processTask = null;
			while (!pq.isEmpty()) {
				if (processTask == null && pq.peek().interval == 0) {
					processTask = pq.poll();
				} else {
					pq.peek().decreaseInterval();
					queue.add(pq.poll());
				}
			}
			time++;
			if (processTask != null) {
				sb.append(processTask.name);
				numTask--;
				processTask.decreaseCounter();
				if (processTask.counter != 0) {
					processTask.interval = interval;
					queue.add(processTask);
				}
			} else {
				sb.append("-");
			}
			while (!queue.isEmpty()) {
				pq.add(queue.poll());
			}
		}
		System.out.println(sb);
		return time;
	}

	public static class Task implements Comparable<Task> {

		char name;
		int counter = 0;
		int interval = 0;

		public Task(char name, int counter, int interval) {
			this.name = name;
			this.counter = counter;
			this.interval = interval;
		}

		@Override
		public int compareTo(Task other) {
			return -(counter - other.counter);
		}

		@Override
		public String toString() {
			return String.format("name %s, counter %s, interval %s", name, counter, interval);
		}

		public void decreaseInterval() {
			if (interval > 0) {
				interval--;
			}
		}

		public void decreaseCounter() {
			counter--;
		}

	}
}
