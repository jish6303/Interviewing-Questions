import java.util.Stack;
import java.lang.Integer;
/* How would you design a stack which, in addition to push and pop, also has a
function min which returns the minimum element? Push, pop and min should all
operate in O(1) time */
public class Stack_with_min {
	public static void main(String[] args){
		MyMinStack stack1= new MyMinStack<Integer>();//Error: The type Stack_with_min.MyMinStack is not generic; it cannot be parameterized with arguments <Integer>
		stack1.push(1);
		stack1.push(11111111);
		stack1.push(111111);
		stack1.push(111);
		stack1.push(11111);
		stack1.push(1111);
		stack1.push(11);
		stack1.push(1111111);
		System.out.println(stack1.get_min());
	}
	public class MyMinStack extends Stack<Integer>{
		int min = Integer.MAX_VALUE;
		MyStack<Integer> s;
		Stack<Integer> MinStack = new Stack<Integer>();
		public MyMinStack() {
			s = new MyStack<Integer>();		
		}
		public void push(Integer node){
			super.push(node);
			if(node.intValue()<min) {
				MinStack.push(node);
				min=node.intValue();
			}
		}
		public Integer pop() {
			Integer value=super.pop();
			if(value==MinStack.peek()){
				MinStack.pop();
				min=MinStack.peek();
			}
			return value;
		}
		public int get_min() {
			return min;		
		}	
	}
}
