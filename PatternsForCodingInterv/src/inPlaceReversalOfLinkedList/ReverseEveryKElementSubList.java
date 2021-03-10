/**
 * 
 */
package inPlaceReversalOfLinkedList;

/**
 * @author gummadisunil.kumar
 *
 */
public class ReverseEveryKElementSubList {

	/**
	 * Given the head of a LinkedList and a number k reverse every k sized sub-list
	 * starting from the head.
	 * 
	 * If in the end you are left with a sublist with less than k elements reverse
	 * it too.
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode result = reverse(head, 3);
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}

	}

	public static ListNode reverse(ListNode head, int k) {
		if (k == 1)
			return head;
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		ListNode lastNodeOfPreviousPart = null;
		ListNode lastNodeOfSublist;
		while (current != null) {
			lastNodeOfPreviousPart = previous;
			// after reversing the linkedList current will become the last node of the
			// sublist
			lastNodeOfSublist = current;
			next = null;
			for (int i = 0; current != null && i < k; i++) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}
			if (lastNodeOfPreviousPart != null) {
				lastNodeOfPreviousPart.next = previous;
			} else
				head = previous;
			lastNodeOfSublist.next = current;
			// if (current == null)
			// break;
			previous = lastNodeOfSublist;
		}
		return head;
	}
}
