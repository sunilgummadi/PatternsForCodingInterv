/**
 * 
 */
package inPlaceReversalOfLinkedList;

/**
 * @author gummadisunil.kumar
 *
 */
class ListNode {
	int value;
	ListNode next=null;

	public ListNode(int value) {
		this.value = value;
	}
}

public class ReverseLinkedList {

	/**
	 * Given the head of a singly linkedList reverse the linkedList. Write a
	 * function to return the new head of the reversed LinkedList.
	 * 
	 * 
	 */

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);

		ListNode result = reverse(head);
		System.out.println("Nodes of the reversed LinkedList are :");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}

	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode next;
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}
