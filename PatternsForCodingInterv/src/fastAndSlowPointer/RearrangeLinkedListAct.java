/**
 * 
 */
package fastAndSlowPointer;

/**
 * @author gummadisunil.kumar
 *
 */
public class RearrangeLinkedListAct {

	/**
	 * Given the head of a Singly LinkedList write a method to modify the LinkedList
	 * such that the nodes from the second half of the LinkedList are inserted
	 * alternately to the nodes from the first half in reverse order. So if the
	 * LinekdList has nodes 1->2->3->4->5->6->null your method should return
	 * 1->6->2->5->3->4->null. Your algorithm should not use any extra space and the
	 * input LinkedList should be modified in place.
	 * 
	 * Input: 2->4->6->8->10->12->null Output: 2->12->4->10->6->8->null
	 * 
	 * Input: 2->4->6->8->10->null Output: 2->10->4->8->6->null
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);
		head.next.next.next.next.next = new ListNode(12);
		reorder(head);
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

	public static void reorder(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode headSecondHalf = reverse(slow);
		ListNode headFirstHalf = head;
		ListNode temp;
		while (headFirstHalf != null && headSecondHalf != null) {
			temp = headFirstHalf.next;
			headFirstHalf.next = headSecondHalf;
			headFirstHalf = temp;

			temp = headSecondHalf.next;
			headSecondHalf.next = headFirstHalf;
			headSecondHalf = temp;
		}
		if (headFirstHalf != null) {
			headFirstHalf.next = null;
		}
	}

	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

}
