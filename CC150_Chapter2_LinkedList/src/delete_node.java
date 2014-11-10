import java.util.Scanner;
public class delete_node {
	public static void main(String[] args){
		LinkedList<String> list1 = new LinkedList<String>();
		System.out.println("Please enter the size of the LinkedList");
	    Scanner input = new Scanner(System.in);
	    int n = input.nextInt();
	    String node = input.nextLine();;
	    for(int i=0;i<n;i++)
	    {
	    	node = input.nextLine();
	    	list1.addLast(node);
	    }
	    System.out.println("LinkedList constructed is:");
	    list1.print();
	    System.out.println(list1.get_size());
	    int j;
	    System.out.printf("Please enter the order of node(smaller than %d) which you want to output\n", n+1);
	    j= input.nextInt();
	    LinkedListNode<String> thisnode= list1.getfirst();
	    for(int i=1;i<j&&thisnode!=null;i++)
	    {
	    	thisnode=thisnode.next;
	    }
	    delete_node(list1, thisnode);
	    System.out.println("LinkedList after deletion is:");
	    list1.print();
	}

	public static LinkedList<String> delete_node(LinkedList<String> list, LinkedListNode<String> node) {
		if(list.findFirst(node.data)==null) 
			System.out.println("Did not find node");
		else if(node.next.next==null) //tail
		{
			node.data=null;
			list.tail=node;
		}
		else{
			node.data = node.next.data;
			node.next=node.next.next;
		}
		return list;
	}
}
