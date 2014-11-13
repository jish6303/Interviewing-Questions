public class TestStack {
	public static void main(String[] args){
		MyStack<String> stack0= new MyStack<String>();
		System.out.println(stack0.get_size());
		System.out.println();
		
		MyStack<String> stack1= new MyStack<String>("This");
		System.out.println(stack1.get_size());
		stack1.print_from_top();
		System.out.println();
		
		stack1.push("is");
		System.out.println(stack1.get_size());
		stack1.print_from_top();
		System.out.println();
		
		stack1.pop();
		System.out.println(stack1.get_size());
		stack1.print_from_top();
		System.out.println();
		
		stack1.push("is");
		stack1.push("another is");
		System.out.println(stack1.get_size());
		stack1.print_from_top();
		System.out.println();
		
		System.out.print("The current top is: ");
		System.out.println(stack1.peek());
		System.out.println(stack1.get_size());
		System.out.println();
	}
}
