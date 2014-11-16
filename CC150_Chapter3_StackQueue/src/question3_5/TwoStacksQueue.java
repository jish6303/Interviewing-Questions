/*
 * Implement a MyQueue class which implements a queue using two stacks
 */
package question3_5;
import java.util.Stack;
public class TwoStacksQueue<T> {
	Stack<T> front_stack = new Stack<T>();
	Stack<T> back_stack = new Stack<T>();
    public boolean is_Empty(){
    	return (front_stack.isEmpty()&&back_stack.isEmpty());
    }
    public void add_First(T element){
    		while(!front_stack.isEmpty()){
    			back_stack.push(front_stack.pop());
    		}
    }
    public void add_Last(T element){
    		while(!back_stack.isEmpty()){
    			front_stack.push(back_stack.pop());
    		}
    		front_stack.push(element);
    }
    public int size(){
    	return front_stack.size() + back_stack.size();
    }
    public T delete_First(){
    	T value;
    	if(is_Empty()){
    		return null;
    	}
    	else if(!back_stack.isEmpty()) value=back_stack.pop();
    	else{
    		while(!front_stack.isEmpty()){
    			back_stack.push(front_stack.pop());
    		}
    		value=back_stack.pop();
    	}
    	return value;
    }
    public T delete_Last(){
    	T value;
    	if(is_Empty()){
    		return null;
    	}
    	else if(!front_stack.isEmpty()) value=front_stack.pop();
    	else{
    		while(!back_stack.isEmpty()){
    			front_stack.push(back_stack.pop());
    		}
    		value=front_stack.pop();
    	}
    	return value;
    }
    public T get_First(){
    	if(is_Empty()) return null;
    	else if(!back_stack.isEmpty()) return back_stack.peek();
    	else{
    		while(!front_stack.isEmpty()){
    			back_stack.push(front_stack.pop());
    		}
    		return back_stack.peek();
    	}
    }
    public T get_Last(){
    	if(is_Empty()) return null;
    	else if(!front_stack.isEmpty()) return front_stack.peek();
    	else{
    		while(!back_stack.isEmpty()){
    			front_stack.push(back_stack.pop());
    		}
    		return front_stack.peek();
    	}
    }
}
