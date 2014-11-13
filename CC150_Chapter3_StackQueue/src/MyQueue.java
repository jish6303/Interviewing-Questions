public class MyQueue<E> {
	public static class MyNode<E>{
		private E data;
		private MyNode<E> next;
		public MyNode(){
			this.data = null;
			this.next = null;
		}
		public MyNode(E node){
			this.data = node;
			this.next=null;
		}
	}
	private int size;
	private MyNode<E> head;
	private MyNode<E> tail;
	public MyQueue(){
		this.head = new MyNode<E>();
		this.tail=head;
		head.data= null;
		head.next= null;
		size=0;
	}
	public MyQueue(E node){
		this.head = new MyNode<E>(node);
		this.tail=head;
		head.data=node;
		head.next=null;
		size=1;
	}
	public int get_size(){
		return size;
	}
	public boolean is_Empty(){
		if(size==0) return true;
		else return false;
	}
	public void add_first(E node){
		if(size==0) head.data=node;
		else{
			MyNode<E> temp = new MyNode<E>();
			temp.data=node;
			temp.next=null;
			temp.next=head;
			head=temp;
		}
		size++;
	}
	public void add_last(E node){
		if(size==0) tail.data=node;
		else{
			MyNode<E> temp = new MyNode<E>();
			temp.data=node;
			temp.next=null;
			tail.next=temp;
			tail=temp;
		}
		size++;	
	}
	public E deleteFirst(){
		if(size==0) {
			System.out.println("Error: can't delete an empty queue!");
			return null;
		}
		else if(size==1){
			size=0;
			System.out.println("Just reached the end of queue");
			return head.data;
		}
		else{
			E temp=head.data;
			head.data=null;
			head=head.next;
			size--;
			return temp;
		}
	}
	public E deleteLast(){
		if(size==0) {
			System.out.println("Error: can't delete an empty queue!");
			return null;
		}
		else if(size==1){
			size=0;
			System.out.println("Just reached the end of queue");
			return tail.data;
		}
		else{
			E temp=tail.data;
			MyNode<E> cursor = head;
			while(cursor.next!=tail){
				cursor=cursor.next;
			}
			tail=cursor;
			size--;
			return temp;
		}
	}
	public E get_first(){
		if(size==0) {
			System.out.println("The queue is an empty");
		}
		return head.data;
	}
	public E get_last(){
		if(size==0){
			System.out.println("The queue is an empty");
		}
		return tail.data;
	}
	public void print_from_head(){
		MyNode<E> temp= head;
		while(temp.next!=null){
			System.out.print(temp.data);
			System.out.println("->");
			temp=temp.next;
		}
		System.out.println(temp.data);
		System.out.println("Just reached the end of queue");
	}
}
