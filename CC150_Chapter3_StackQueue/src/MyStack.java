public class MyStack<E> {
	public static class MyNode<E>{
		private E data;
		private MyNode<E> down;
	}
	private int size;
	private MyNode<E> top;
	public MyStack(){
		this.top = new MyNode<E>();
		top.data= null;
		top.down= null;
		size=0;
	}
	public MyStack(E node){
		this.top = new MyNode<E>();
		top.data = node;
		top.down=null;
		size=1;
	}
	public int get_size(){
		return size;
	}
	public boolean is_Empty(){
		if(size==0) return true;
		else return false;
	}
	public void push(E node){
		if(size==0){
			top.data=node;
		}
		else {
			MyNode<E> temp = new MyNode<E>();
			temp.down= top;
			temp.data=node;
			top=temp;
		}
		size++;
	}
	public E pop() {
		if(size==0) {
			System.out.println("Error: can't pop an empty stack!");
			return null;
		}
		else if (size==1) {
			size=0;
			System.out.println("Just reached the end of stack");
			return top.data;
		}
		else{
			E temp=top.data;
			top.data=null;
			top=top.down;
			size--;
			return temp;	
		}
	}
	public E peek(){
		if(size==0) {
			System.out.println("The stack is empty");
		}
		return top.data;
	}
	public void print_from_top(){
		MyNode<E> temp=top;
		while(temp.down!=null){
			System.out.print(temp.data);
			System.out.println("->");
			temp=temp.down;
		}
		System.out.println(temp.data);
		System.out.println("Just reached the end of stack");
	}

}
