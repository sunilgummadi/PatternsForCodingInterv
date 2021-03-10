/**
 * 
 */
package inPlaceReversalOfLinkedList;

/**
 * @author gummadisunil.kumar
 *
 */
public class ReverseAlternatingKElementSubList {

	/**
	 * Given the head of a linkedList and a number k reverse every alternating k
	 * sized sub list starting from the head.
	 * 
	 * If in the end you are left with a sub list with less than k elements reverse
	 * it too.
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
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode result = reverse(head, 2);
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}

	public static ListNode reverse(ListNode head, int k) {
		ListNode current = head;
		ListNode previous = null;
		ListNode lastNodeOfSublist;
		ListNode lastNodeOfPrevious = null;
		ListNode next;
		while (current != null) {
			lastNodeOfSublist = current;
			lastNodeOfPrevious = previous;
			next = null;
			for (int i = 0; current != null && i < k; i++) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}
			if (lastNodeOfPrevious != null)
				lastNodeOfPrevious.next = previous;
			else
				head = previous;
			lastNodeOfSublist.next = current;
			previous = lastNodeOfSublist;
			for (int i = 0; current != null && i < k; i++) {
				previous = current;
				current = current.next;
			}
		}
		return head;
	}
}
