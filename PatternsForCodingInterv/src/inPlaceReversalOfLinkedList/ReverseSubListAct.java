/**
 * 
 */
package inPlaceReversalOfLinkedList;

/**
 * @author gummadisunil.kumar
 *
 */
public class ReverseSubListAct {

	/**
	 * Given the head of a LinkedList and two positions p and q, reverse the
	 * LinkedList from position p to q.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode result = reverse(head, 1, 2);
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}

	public static ListNode reverse(ListNode head, int p, int q) {
		if (p == q)
			return head;
		ListNode current = head;
		ListNode next = null;
		ListNode previous = null;
		// after skipping p-1 nodes current will point to pth node
		for (int i = 0; current != null && i < p - 1; i++) {
			previous = current;
			current = current.next;
		}
		ListNode lastNodeOfFirstPart = previous;// points to the node at index p-1
		// after reversing the linkedList current will become the last node of the
		// sub-list
		ListNode lastNodeOfSubList = current;
		for (int i = 0; current != null && i < q - p + 1; i++) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		// connecting with the first part
		if (lastNodeOfFirstPart != null) {
			lastNodeOfFirstPart.next = previous;// previous is now the first node of the sub-list
		} else// this means p==1 i.e., we are changing the first node of the linkedList
			head = previous;
		// connect with the last part
		lastNodeOfSubList.next = current;
		return head;
	}
}
