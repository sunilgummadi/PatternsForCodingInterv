/**
 * 
 */
package fastAndSlowPointer;

/**
 * @author gummadisunil.kumar
 *
 */
public class MiddleOfTheLinkedListAct {

	/**
	 * Given the head of a Singly LinkedList, write a method to return the middle
	 * node of the LinkedList. If the total number of nodes in the LinkedList is
	 * even, return the second middle node.
	 * 
	 * Input: 1->2->3->4->5->null Output: 3
	 * 
	 * Input: 1->2->3->4->5->6->null Output: 4
	 * 
	 * Input: 1->2->3->4->5->6->7->null Output: 4
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println("Middle Node : 3 got : " + findMiddle(head).value);
		head.next.next.next.next.next = new ListNode(6);
		System.out.println("Middle Node : 4 got : " + findMiddle(head).value);
		head.next.next.next.next.next.next = new ListNode(7);
		System.out.println("Middle Node : 4 got : " + findMiddle(head).value);
	}

	// we can use the fast and slow pointer method such that the fast pointer is
	// always twice the nodes ahead of the slow pointer.So when the fast pointer
	// reaches the end slow pointer will be pointing at the middle node.
	public static ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
