/**
 * 
 */
package fastAndSlowPointer;

import java.util.HashMap;

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
public class StartOfLinkedListCycle {

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
//it fails for duplicate nodes
	public static ListNode findCycleStart(ListNode head) {
		HashMap<Integer, Integer> intFreq = new HashMap<>();
		ListNode slow = head;
		while (slow.next != null) {
			if (intFreq.containsKey(slow.value))
				return slow;
			else
				intFreq.put(slow.value, 1);
			slow = slow.next;
		}
		return slow;
	}
}
