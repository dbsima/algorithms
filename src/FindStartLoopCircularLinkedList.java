import helpers.DoublyLinkedList;

public class FindStartLoopCircularLinkedList {

	public static DoublyLinkedList FindBeginning(DoublyLinkedList head) {
		DoublyLinkedList slow = head;
		DoublyLinkedList fast = head; 
		
		// Find meeting point (LOOP_SIZE - k steps into the linked list)
		while (fast.next != null) { 
			slow = slow.next; 
			fast = fast.next.next; 
			if (slow == fast) { 
				break; 
			}
		}

		// Error check - there is no meeting point, and therefore no loop
		if (fast.next == null) {
			return null;
		}

		/* Move slow to the head of the linked list. Each pointer is k steps
		/* from the Loop Start. If they move at the same pace, they must
		 * meet at Loop Start. */
		slow = head; 
		while (slow != fast) { 
			slow = slow.next; 
			fast = fast.next; 
		}
		// Both pointers now point to the start of the loop, so return one
		return fast;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList[] nodes = new DoublyLinkedList[10];
		
		for (int i = 0; i < 10; i++) {
			nodes[i] = new DoublyLinkedList(i, null, i > 0 ? nodes[i - 1] : null);
		}
		
		// Create loop;
		nodes[9].next = nodes[3];
		
		DoublyLinkedList loop = FindBeginning(nodes[0]);
		System.out.println(loop.data);
	}

}
