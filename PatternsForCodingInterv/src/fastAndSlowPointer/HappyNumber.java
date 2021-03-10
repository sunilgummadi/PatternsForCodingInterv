/**
 * 
 */
package fastAndSlowPointer;

import java.util.HashMap;

/**
 * @author gummadisunil.kumar
 *
 */
public class HappyNumber {

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
		HashMap<Integer, Integer> intFreq = new HashMap<>();
		int rem = 0;
		int sum = 0;
		while (num > 0) {
			rem = 0;
			sum = 0;
			if (intFreq.containsKey(num) && num != 1)
				return false;
			else {
				intFreq.put(num, 1);
				while (num > 0) {
					rem = num % 10;
					sum += rem * rem;
					num /= 10;
				}
				if (sum == 1)
					return true;
				num = sum;

			}

		}

		return false;
	}
}
