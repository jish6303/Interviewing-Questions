public class LinkedList<E> {
	public LinkedListNode<E> head;
    public LinkedListNode<E> tail;
	public <E> E deleteNode(LinkedListNode<E> node) {
        if(node == null || node.next == null) return null;

        E retval = node.data;
        LinkedListNode<E> next = node.next;
        node.data = next.data;
        node.next = next.next;
        return retval;
    }
	//constructor
	public LinkedList() {
        this.head = new LinkedListNode<E>();
        this.tail = new LinkedListNode<E>();
        head.next = tail;
        tail.next = null;
    }
	
	public void addLast(E e) {
        LinkedListNode<E> node = new LinkedListNode<E>(); // e and next are null
        tail.data = e;
        tail.next = node;
        tail = node;
    }

    public void addFirst(E e) {
        LinkedListNode<E> node = new LinkedListNode<E>(); // e and next are null;
        node.next = head.next;
        node.data = e;
        head.next = node;
    }
    
    public LinkedListNode<E> getfirst(){
    	return head.next;
    }
    
    public LinkedListNode<E> getLast(){
    	return tail;
    }

    public E deleteFirst() {
        LinkedListNode<E> first = head.next;
        head.next = first.next;
        return first.data;
    }

    public E deleteLast() {
        // cannot do without iteration of the list! :-(
        throw new UnsupportedOperationException();
    }
    
    public int get_size(){
    	int i=0;
    	LinkedListNode<E> node = head.next;
    	while(node.next!=null){
    		i++;
    		node=node.next;
    	}
    	return i;
    }

    public LinkedListNode<E> findFirst(E e) {
        LinkedListNode<E> curr = head.next;
        while(curr != null) {
            if(curr.data != null && curr.data.equals(e)) return curr;
            curr = curr.next;
        }
        return null;
    }

    public void print() {
        LinkedListNode<E> curr = head.next;
        int i=0;
        while(curr.next != null) {
            System.out.print(curr.data);
            if(i<this.get_size()-1) System.out.print("-> ");
            curr = curr.next;
            i++;
        }
        System.out.println();
    }


}
