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
public class StartOfLinkedListCycleAct {

	/**
	 * Given the head of a singly LinkedLIst that contains a cycle, write a function
	 * to find the starting node of the cycle.
	 * 
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList cycle start : 3 got : " + findCycleStart(head).value);
		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println("LinkedList cycle start : 4 got : " + findCycleStart(head).value);
		head.next.next.next.next.next.next.next = head;
		System.out.println("LinkedList cycle start : 1 got : " + findCycleStart(head).value);
	}

	// it fails for duplicate nodes
	public static ListNode findCycleStart(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		int length = 0;
		while (fast != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				do {
					slow = slow.next;
					length++;
				} while (slow != fast);
				break;
			}
		}
		slow = head;
		fast = head;
		while (length > 0) {
			fast = fast.next;
			length--;
		}
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
