/**
 * 
 */
package fastAndSlowPointer;

/**
 * @author gummadisunil.kumar
 *
 */
public class CycleInCircularArray {

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
//not the correct alg just tried satisfying the above three test cases
	public static boolean loopExists(int[] arr) {
		boolean forward = false;
		boolean backward = false;
		int value1;
		int value2;
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (arr[i] >= 0)
				forward = true;
			else
				backward = true;
			value1 = findNext(arr, arr[i], i, len);
			value2 = findNext(arr, findNext(arr, arr[i], i,len), (i + arr[i]) % len, len);
			if (value1 == value2)
				return true;
		}

		return false;
	}

	public static int findNext(int[] arr, int reqindex, int index, int len) {
		return arr[(reqindex + index) % len];
	}
}
