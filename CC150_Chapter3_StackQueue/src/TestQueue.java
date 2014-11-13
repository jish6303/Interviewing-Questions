public class TestQueue {
	public static void main(String[] args){
		MyQueue<Integer> q1 = new MyQueue<Integer>();
		System.out.println(q1.get_size());
		System.out.println();
		
		MyQueue<Integer> q2 = new MyQueue<Integer>(100);
		System.out.println(q2.get_size());
		q2.print_from_head();
		System.out.println();
		q2.deleteFirst();
		System.out.println(q2.get_size());
		System.out.println();
		
		MyQueue<Integer> q3 = new MyQueue<Integer>(1);
		q3.add_last(100);
		q3.add_first(1000);
		q3.print_from_head();
		System.out.println(q3.get_size());
		System.out.println();
		
		q3.deleteFirst();
		q3.add_last(10);
		q3.add_first(10000);
		q3.deleteLast();
		q3.add_first(q3.get_last());
		q3.print_from_head();
		System.out.println(q3.get_size());
		System.out.println();
		
		MyQueue<Integer> q4 = new MyQueue<Integer>(11);
		q4.add_first(111);
		q4.add_last(1);
		q4.print_from_head();
		System.out.println(q4.get_size());
		System.out.println(q4.get_first());
		System.out.println(q4.get_last());		
	}
}
