/**
 * 
 */
package twoPointers;

import java.util.Arrays;

/**
 * @author gummadisunil.kumar
 *
 */
public class SquaringSortedArray {

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
		// int[] squares = new int[len];
		for (int end = 0; end < len; end++) {
			arr[end] = arr[end] * arr[end];
		}
		Arrays.sort(arr);
		return arr;
	}
}
