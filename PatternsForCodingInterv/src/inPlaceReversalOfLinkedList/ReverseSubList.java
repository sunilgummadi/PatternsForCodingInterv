/**
 * 
 */
package inPlaceReversalOfLinkedList;

/**
 * @author gummadisunil.kumar
 *
 */
public class ReverseSubList {

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
		ListNode prev = null;
		ListNode next = null;
		ListNode pointer1 = head;
		ListNode pointer2 = null;
		ListNode pre = null;
		while (head.value != p) {
			pre = head;
			head = head.next;
			pointer1 = head;
		}
		while (head.value != q) {
			head = head.next;
			pointer2 = head;
		}
		pointer2 = head.next;
		prev = pointer2;
		while (pointer1 != pointer2) {
			next = pointer1.next;
			pointer1.next = prev;
			prev = pointer1;
			pointer1 = next;
		}
		if (pre != null)
			pre.next = prev;
		return pre == null ? prev : pre;
	}
}
