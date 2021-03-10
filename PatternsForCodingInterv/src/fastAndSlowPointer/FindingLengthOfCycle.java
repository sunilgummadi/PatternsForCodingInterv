/**
 * 
 */
package fastAndSlowPointer;

/**
 * @author gummadisunil.kumar
 *
 */

// class ListNode {
// int value;
// ListNode next;
//
// ListNode(int value) {
// this.value = value;
// }
// }

public class FindingLengthOfCycle {

	/**
	 * Given the head of a LinkedList with a cycle, find the length of the cycle.
	 * 
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		System.out.println("Cycle length : 0 got : " + lengthOfCycle(head));
		head.next.next.next.next.next.next = head.next.next;
		System.out.println("Cycle length : 4 got : " + lengthOfCycle(head));
		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println("Cycle length : 3 got : " + lengthOfCycle(head));
	}

	public static int lengthOfCycle(ListNode head) {
		int length = 0;
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow.value == fast.value) {
				do {
					fast = fast.next;
					length++;
				} while (fast != null && slow.value != fast.value);
				break;
			}
		}	
		return length;
	}
}
