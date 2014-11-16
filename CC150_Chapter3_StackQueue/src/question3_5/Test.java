//Revision from the test cases in CC150, as function names are differently implemented here
package question3_5;
import java.util.LinkedList;
import java.util.Queue;
import CareerCupLibrary.AssortedMethods;

public class Test {
	public static void main(String[] args) {
		TwoStacksQueue<Integer> my_queue = new TwoStacksQueue<Integer>();
		Queue<Integer> test_queue = new LinkedList<Integer>();
		for (int i = 0; i < 100; i++) {
			int choice = AssortedMethods.randomIntInRange(0, 10);
			if (choice <= 5) { // enqueue
				int element = AssortedMethods.randomIntInRange(1, 10);
				test_queue.add(element);
				my_queue.add_Last(element);
				System.out.println("Enqueued " + element);
			} else if (test_queue.size() > 0) {
				int top1 = test_queue.remove();
				int top2 = my_queue.delete_First();
				if (top1 != top2) { // Check for error
					System.out.println("******* FAILURE - DIFFERENT TOPS: " + top1 + ", " + top2);
				} 
				System.out.println("Dequeued " + top1);
			}
			
			if (test_queue.size() == my_queue.size()) {
				if (test_queue.size() > 0 && test_queue.peek() != my_queue.get_First()) {
					System.out.println("******* FAILURE - DIFFERENT TOPS: " + test_queue.peek() + ", " + my_queue.get_First() + " ******");
				}
			} else {
				System.out.println("******* FAILURE - DIFFERENT SIZES ******");
			}
		}
	}
}
