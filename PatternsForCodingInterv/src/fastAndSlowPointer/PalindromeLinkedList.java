/**
 * 
 */
package fastAndSlowPointer;

/**
 * @author gummadisunil.kumar
 *
 */
public class PalindromeLinkedList {

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
		ListNode slow = head;
		ListNode fast = head;
		int sum = 0;
		int count = 0;
		while (fast != null && fast.next != null) {
			sum = sum * 10 + slow.value;
			slow = slow.next;
			count++;
			fast = fast.next.next;
		}
		if (count % 2 == 0)
			slow = slow.next;
		int secondSum = 0;
		int i = 0;
		while (slow != null) {
			secondSum = secondSum + slow.value * (int) Math.pow(10, i++);
			slow = slow.next;
		}
		// System.out.println(sum);
		// System.out.println(secondSu	m);
		if (sum == secondSum)
			return true;
		return false;
	}
}
