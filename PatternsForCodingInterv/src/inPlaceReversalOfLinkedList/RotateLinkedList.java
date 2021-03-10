/**
 * 
 */
package inPlaceReversalOfLinkedList;

/**
 * @author gummadisunil.kumar
 *
 */
public class RotateLinkedList {

	/**
	 * Given the head of a singly linkedList and a number k rotate the linkedList to
	 * the right by k nodes.
	 * 
	 * Example : 1->2->3->4->5->6->null and k = 3
	 * 
	 * Rotated LinkedList : 4->5->6->1->2->3->null
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		ListNode result = rotate(head, 8);
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}

	}

	public static ListNode rotate(ListNode head, int rotations) {
		ListNode current = head;
		int count = 0;
		while (current != null) {
			current = current.next;
			count++;
		}
		rotations = rotations % count;
		if(rotations==0)
			return head;
		current = head;
		ListNode start;
		ListNode previous = null;
		for (int i = 0; current != null && i < rotations; i++) {
			previous = current;
			current = current.next;
		}
		if(previous!=null)
			previous.next = null;
		start = current;
		while (current.next != null)
			current = current.next;
		current.next = head;
		return start;
	}
}
