/**
 * 
 */
package fastAndSlowPointer;

/**
 * @author gummadisunil.kumar
 *
 */
public class HappyNumberAct {

	/**
	 * Any number will be called a happy number if after repeatedly replacing it
	 * with a number equal to the sum of the square of all of its digits leads us to
	 * number 1. All other(not-happy) numbers will never reach 1.Instead they will
	 * be stuck in a cycle of numbers which does not include 1.
	 * 
	 * Input: 23 Output: true(23 is a happy number)
	 * 
	 * 2^2 + 3^2 = 4 + 9 = 13
	 * 
	 * 1^2 + 3^2 = 1 + 9 = 10
	 * 
	 * 1^2 + 0^2 = 1 + 0 = 1
	 * 
	 * Input : 12 Output:false (here loop occurs between step 13 and step 5 if we
	 * solve by above approach)
	 */
	public static void main(String[] args) {
		System.out.println("Input: 23 Output: true got :" + find(23));
		System.out.println("Input : 12 Output:false got :" + find(12));
	}

	public static boolean find(int num) {
		int slow = num;
		int fast = num;
		do {
			slow = findSquares(slow); // move one step
			fast = findSquares(findSquares(fast)); // move two steps
		} while (slow != fast); // found the cycle
		return slow == 1;
	}

	public static int findSquares(int num) {
		int rem = 0;
		int sum = 0;
		while (num > 0) {
			rem = num % 10;
			sum += rem * rem;
			num /= 10;
		}
		return sum;
	}
}
