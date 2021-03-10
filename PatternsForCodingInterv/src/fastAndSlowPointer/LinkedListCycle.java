/**
 * 
 */
package fastAndSlowPointer;

/**
 * @author gummadisunil.kumar
 *
 */

class ListNode {
	int value = 0;
	ListNode next;

	ListNode(int value) {
		this.value = value;
	}
}

public class LinkedListCycle {

	/**
	 * Given the head of a singly LinkedList, write a function to determine if the
	 * LinkedList has a cycle in it or not.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		System.out.println("LinkedList has cycle: false got : " + LinkedListCycle.hasCycle(head));
		head.next.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList has cycle: true got :" + hasCycle(head));
		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println("LinkedList has cycle: true got : " + hasCycle(head));
	}

	// solved in first attempt
	public static boolean hasCycle(ListNode head) {
		ListNode slow;
		ListNode fast;
		fast = head;
		slow = head;
		while (fast.next.next != null) { // slight changes in original while condition (fast!=null && fast.next!=null)
			slow = slow.next;
			fast = fast.next.next;
			if (slow.value == fast.value)
				return true;
		}
		return false;
	}
}
