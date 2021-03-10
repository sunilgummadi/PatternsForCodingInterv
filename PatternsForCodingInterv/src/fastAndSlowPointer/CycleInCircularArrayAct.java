/**
 * 
 */
package fastAndSlowPointer;

/**
 * @author gummadisunil.kumar
 *
 */
public class CycleInCircularArrayAct {

	/**
	 * We are given an array containing positive and negative numbers. Suppose the
	 * array contains a number M at a particular index, Now, if M is positive we
	 * will move forward M indices and if M is negative move backwards M indices.
	 * You should assume that the array is circular which means two things.
	 * 
	 * 1.If while moving forward, we reach the end of the array we will jump to the
	 * first element to continue the movement.
	 * 
	 * 2.If while moving backward we reach the beginning of the array we will jump
	 * to the last element to continue the movement.The cycle should have more than
	 * one element and should follow one direction which means the cycle should not
	 * contain both forward and backward movement.
	 * 
	 * Input: [1,2,-1,2,2] Output: true cycle Indices:0->1->3->0
	 * 
	 * Input: [2,2,-1,2] Output: true cycle Indices:1->3->1
	 * 
	 * Input: [2,1,-1,-2] Output: false cycle no cycle.
	 */
	public static void main(String[] args) {
		System.out.println("Input: [1,2,-1,2,2] Output: true got :" + loopExists(new int[] { 1, 2, -1, 2, 2 }));
		System.out.println("Input: [2,2,-1,2] Output: true got :" + loopExists(new int[] { 2, 2, -1, 2 }));
		System.out.println("Input: [2,1,-1,-2] Output: false got :" + loopExists(new int[] { 2, 1, -1, -2 }));
	}

	public static boolean loopExists(int[] arr) {
		boolean forward = false;
		int slow;
		int fast;
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			forward = arr[i] >= 0;
			slow = i;
			fast = i;
			do {
				slow = findNextIndex(arr, forward, slow, len);
				fast = findNextIndex(arr, forward, fast, len);
				if (fast != -1)
					fast = findNextIndex(arr, forward, fast, len);
			} while (slow != -1 && fast != -1 && slow != fast);
			if (slow != -1 && slow == fast)
				return true;
		}

		return false;
	}

	public static int findNextIndex(int[] arr, boolean isForward, int currentIndex, int len) {
		boolean direction = arr[currentIndex] >= 0;
		if (isForward != direction)
			return -1; //change in direction return -1
		int nextIndex = (currentIndex + arr[currentIndex]) % len;
		if (nextIndex < 0)
			nextIndex += len; // wrap around for negative numbers

		// one element cycle return -1
		if (nextIndex == currentIndex)
			return -1;
		return nextIndex;
	}
}
