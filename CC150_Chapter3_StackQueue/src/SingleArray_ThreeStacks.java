/*
 Describe how you could use a single array to implement three stacks
*/
import java.util.Scanner;
import java.util.Stack;
public class SingleArray_ThreeStacks {
	public static void main(String[] args){
		System.out.println("Please enter the size of the stack");
	    Scanner input = new Scanner(System.in);
	    int n = input.nextInt();
	    //Did not implement test cases.
	    //Did not design for dynamically assigned three stacks.
	}
	public class Array_to_3stack<Integer>{
		private int array_size;
		private int stack_size;
		int[] array = new int[array_size];
		int[] stackcount = new int[3];
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		Stack stack3 = new Stack();
		public Array_to_3stack(int n){
			array_size=3*n;
			stack_size=n;
		}
		public void push(int Num, int value) throws Exception{//Num must be a number between 1-3
			if(stackcount[Num-1]>stack_size-1) throw new Exception("Out of space.");
			else {
				array[absTopOfStack(Num)]=value;
				stackcount[Num-1]++;
			}
		}
		public int pop(int Num) throws Exception{
			int get;
			if(stackcount[Num-1]==0) throw new Exception("Can't pop an empty stack");
			else{
				get=array[absTopOfStack(Num)];
				array[absTopOfStack(Num)]=0;
				stackcount[Num-1]--;
				return get;
			}
		}
		public int peek(int Num) throws Exception{
			int get;
			if(stackcount[Num-1]==0) throw new Exception("The stack is empty");
			else{
				get=array[absTopOfStack(Num)];
				return get;
			}
		}
		public boolean is_empty(int Num){
			if(stackcount[Num-1]==0) return true;
			else return false;
		}
		public int absTopOfStack(int Num){
			return (Num-1)*stack_size+stackcount[Num-1]+1;
		}
		
	}
}
