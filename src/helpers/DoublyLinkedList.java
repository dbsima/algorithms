package helpers;

public class DoublyLinkedList {
	public DoublyLinkedList next;
	public DoublyLinkedList prev;
	public int data;
	public DoublyLinkedList(int d, DoublyLinkedList n, DoublyLinkedList p) {
		data = d;
		setNext(n);
		setPrevious(p);
	}
	
	public void setNext(DoublyLinkedList n) {
		next = n;
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(DoublyLinkedList p) {
		prev = p;
		if (p != null && p.next != this) {
			p.setNext(this);
		}
	}	
	
	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return ((Integer) data).toString();
		}
	}
}
