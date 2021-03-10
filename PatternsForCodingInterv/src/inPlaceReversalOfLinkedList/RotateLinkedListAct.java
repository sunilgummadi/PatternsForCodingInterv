/**
 * 
 */
package inPlaceReversalOfLinkedList;

/**
 * @author gummadisunil.kumar
 *
 */
public class RotateLinkedListAct {

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
		if (head == null || head.next == null || rotations <= 0)
			return head;

		// find the length and the last node of the list
		ListNode lastNode = head;
		int listLength = 1;
		while (lastNode.next != null) {
			lastNode = lastNode.next;
			listLength++;
		}
		lastNode.next = head;// connect the last node with the head to make it a circular list
		rotations %= listLength;
		int skipLength = listLength - rotations;
		ListNode lastNodeOfRotatedList = head;
		for (int i = 0; i < skipLength - 1; i++) {
			lastNodeOfRotatedList = lastNodeOfRotatedList.next;
		}
		head = lastNodeOfRotatedList.next;
		lastNodeOfRotatedList.next = null;
		return head;
	}
}
