/**
 * 
 */
package fastAndSlowPointer;

/**
 * @author gummadisunil.kumar
 *
 */
public class PalindromeLinkedListAct {

	/**
	 * Given the head of a singly LinkedList write a method to check if the
	 * LinkedList is a palindrome or not. Your algorithm should use constant space
	 * and the input LinkedList should be in the original form once the algorithm is
	 * fininshed. The algorithm should have O(N) time complexity where 'N' is the
	 * number of nodes in the LinkedList.
	 * 
	 * Input:2->4->6->4->2->null Output:true
	 * 
	 * Input: 2->4->6->4->2->2->null Output:false
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		System.out.println("Is palindrome: true got :" + isPalindrome(head));
		head.next.next.next.next.next = new ListNode(2);
		System.out.println("Is palindrome: false got :" + isPalindrome(head));
	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode headSecondHalf = reverse(slow);
		ListNode copyHeadSecondHalf = headSecondHalf;

		while (head != null && headSecondHalf != null) {
			if (head.value != headSecondHalf.value)
				break;
			head = head.next;
			headSecondHalf = headSecondHalf.next;
		}
		reverse(copyHeadSecondHalf);
		if (head == null || headSecondHalf == null)
			return true;
		return false;
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
