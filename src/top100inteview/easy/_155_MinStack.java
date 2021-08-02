package top100inteview.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Created by hieund3 on 07/07/2021
 */
public class _155_MinStack {
	public static final _155_MinStack INSTANCE = new _155_MinStack();

	class Struct {
		Integer val;
		Integer frequence;

		public Struct(Integer val, Integer frequence) {
			this.val = val;
			this.frequence = frequence;
		}
	}

	Deque<Integer> stack;
	Deque<Struct> minStack;


	public _155_MinStack() {
		stack = new ArrayDeque<>();
		minStack = new ArrayDeque<>();
	}

	public void push(int val) {
		stack.push(val);
		if (minStack.isEmpty()) {
			minStack.push(new Struct(val, 1));
		} else {
			if (minStack.peek().val > val) {
				minStack.push(new Struct(val, 1));
			} else if (minStack.peek().val.equals(val)) {
				final Struct pop = minStack.pop();
				pop.frequence++;
				minStack.push(pop);
			}
		}
	}

	public void pop() {
		final Integer pop = stack.pop();
		final Integer val = minStack.peek().val;
		if (val.equals(pop)) {
			if (minStack.peek().frequence == 1) {
				minStack.pop();
			} else {
				final Struct pop1 = minStack.pop();
				pop1.frequence--;
				minStack.push(pop1);
			}
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek().val;
	}

}
