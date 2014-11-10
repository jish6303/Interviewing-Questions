import java.util.Scanner;
public class partition_by_integer {
	public static void main(String[] args){
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		System.out.println("Please enter the size of the LinkedList");
	    Scanner input = new Scanner(System.in);
	    int n = input.nextInt();
	    int x,y;
	    String node = input.nextLine();
	    for(int i=0;i<n;i++)
	    {
	    	x = input.nextInt();
	    	list1.addLast(x);
	    }
	    System.out.println("LinkedList constructed is:");
	    list1.print();
	    System.out.println("Please enter the integer you want to partition the LinkedList");
	    y= input.nextInt();
	    LinkedList_partition(list1, y);
	}

	private static void LinkedList_partition(LinkedList<Integer> list, int n) {
		int i;
		LinkedList<Integer> big= new LinkedList<Integer>(); 
		LinkedList<Integer> small= new LinkedList<Integer>();
		LinkedListNode<Integer> cursor = list.getfirst();
		for(i=0;i<list.get_size();i++)
		{
			if(cursor.data>=n) big.addLast(cursor.data);
			else small.addLast(cursor.data);
			cursor=cursor.next;
		}
		System.out.print("The bigger ones: ");
		big.print();
		System.out.print("The small ones: ");
		small.print();
	}
}
