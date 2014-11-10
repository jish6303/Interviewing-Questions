import java.util.Hashtable;
import java.util.Scanner;
public class delete_duplicate {
	public static void main(String[] args){
		LinkedList<String> list1 = new LinkedList<String>();
		System.out.println("Please enter the size of the LinkedList");
	    Scanner input = new Scanner(System.in);
	    int n = input.nextInt();
	    String node;
	    for(int i=0;i<=n;i++)
	    {
	    	node = input.nextLine();
	    	list1.addLast(node);
	    }
	    System.out.println("Before Removing:");
	    list1.print();
	    delete_duplicate(list1);
	}

	private static LinkedList<String> delete_duplicate(LinkedList<String> list1) {	
		Hashtable table = new Hashtable();
		boolean remove=false;
		LinkedListNode<String> previous = list1.getfirst();
		LinkedListNode<String> cursor = list1.getfirst();
		while(cursor.next!=null){
			if(table.containsKey(cursor.data)){
				remove=true;
				previous.next=cursor.next;
			}
			else{
				table.put(cursor.data, true);
				previous=cursor;
			}
			cursor=cursor.next;
		}
		if(remove==true) {
			System.out.println("After Removing:");
			list1.print();
		}
		else System.out.println("No need to remove");
		return list1;
	}
}
