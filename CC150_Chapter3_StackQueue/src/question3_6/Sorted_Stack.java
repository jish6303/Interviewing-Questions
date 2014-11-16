/*
 Write a program to sort a stack in ascending order (with biggest items on top).
You may use at most one additional stack to hold items, but you may not copy the
elements into any other data structure (such as an array). The stack supports the
following operations: push, pop, peek, and isEmpty.
 */
package question3_6;

import java.util.Stack;

public class Sorted_Stack {
	public static void main(String [] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(3);
		s.push(2);
		s.push(24);
		s.push(34);
		s.push(19);
		s.push(3);
		s.push(4);
		s = sort(s);
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
	private static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()) {
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}

}
