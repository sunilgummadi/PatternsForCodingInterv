/**
 * 
 */
package twoPointers;

import java.util.Arrays;

/**
 * @author gummadisunil.kumar
 *
 */
public class SquaringSortedArrayAct {

	/**
	 * Given a sorted array create a new array containing squares of all the numbers
	 * of the input array in the sorted order. input=[-2,-1,0,2,3]
	 * output:[0,1,4,4,9] input=[-3,-1,0,-1,2] output:[0,1,1,4,9]
	 */
	public static void main(String[] args) {
		System.out.println("input=[-2,-1,0,2,3] output:[0,1,4,4,9] got : "
				+ Arrays.toString(makeSquares(new int[] { -2, -1, 0, 2, 3 })));
		System.out.println("input=[-3,-1,0,-1,2] output:[0,1,1,4,9] got : "
				+ Arrays.toString(makeSquares(new int[] { -3, -1, 0, -1, 2 })));
	}

	public static int[] makeSquares(int[] arr) {
		int len = arr.length;
		int start = 0;
		int i = len - 1;
		int end = len - 1;
		int[] squares = new int[len];
		int leftSquare;
		int rightSquare;
		while (start <= end) {
			leftSquare = arr[start] * arr[start];
			rightSquare = arr[end] * arr[end];
			if (leftSquare > rightSquare) {
				squares[i--] = leftSquare;
				start++;
			} else {
				squares[i--] = rightSquare;
				end--;
			}
		}
		// int start=-1;
		// int i = 0;
		// int[] squares = new int[len];
		// for (end = 0; end < len; end++) {
		// if (arr[end] < 0)
		// start++;
		// else
		// break;
		// }
		// while (true) {
		//
		// if (start >= 0 && end < len && arr[start] * arr[start] <= arr[end] *
		// arr[end]) {
		// squares[i++] = arr[start] * arr[start];
		// start--;
		// } else if (start >= 0 && end < len && arr[start] * arr[start] > arr[end] *
		// arr[end]) {
		// squares[i++] = arr[end] * arr[end];
		// end++;
		// } else if (start < 0 && end < len) {
		// squares[i++] = arr[end] * arr[end];
		// end++;
		// } else if (end >= len && start >= 0) {
		// squares[i++] = arr[start] * arr[start];
		// start--;
		// } else
		// break;
		// }
		return squares;
	}
}
