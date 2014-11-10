import java.util.Scanner;
public class FindTheNthLastNode {
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
	    System.out.println("Please enter the number from tail you want to output");
	    j= input.nextInt();
	    System.out.println(FindTheNthLastNode(list1, j));
	}

	private static String FindTheNthLastNode(LinkedList<String> list1, int j) {
		LinkedListNode<String> starter=list1.getfirst(), follower=list1.getfirst();
		if(j>=list1.get_size()) return(follower.data);
		else{
				for(int index=0;index<j;index++){
					if(starter==null||starter.next==null) {
						return follower.data;
					}
					else starter=starter.next;
				}
				while(starter.next!=null){
					starter=starter.next;
					follower=follower.next;
				}
				return follower.data;
			}
		}

}
