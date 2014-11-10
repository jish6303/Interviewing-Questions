import java.util.Scanner;
import java.util.Stack;
public class ifPalindrome {
	public static void main(String[] args){
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		System.out.println("Please enter the size of the LinkedList");
	    Scanner input = new Scanner(System.in);
	    int n = input.nextInt();
	    int x;
	    String node = input.nextLine();
	    for(int i=0;i<n;i++)
	    {
	    	x = input.nextInt();
	    	list1.addLast(x);
	    }
	    System.out.println("LinkedList constructed is:");
	    list1.print();
	    System.out.println(ifPalindrome(list1));
	}

	private static boolean ifPalindrome(LinkedList<Integer> list) {
		Stack<Integer> reverselist = new Stack<Integer>();
		LinkedListNode<Integer> cursor = list.getfirst();
		for(int i=0;i<list.get_size();i++)
		{
			reverselist.add(cursor.data);
			cursor=cursor.next;
		}
		cursor = list.getfirst();
		for(int i=0;i<list.get_size();i++){
			if(reverselist.pop()!=cursor.data) return false;
			cursor=cursor.next;
		}
		return true;
	}

}
