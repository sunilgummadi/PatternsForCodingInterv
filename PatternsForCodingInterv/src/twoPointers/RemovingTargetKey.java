/**
 * 
 */
package twoPointers;

import java.util.Arrays;

/**
 * @author gummadisunil.kumar
 *
 */
public class RemovingTargetKey {

	/**
	 * Given an unsorted array of numbers and a target key remove all instances of
	 * key in place and return the new length of the array input =[3,2,3,6,3,10,9,3]
	 * key=3 output: 4 input =[2,11,2,2,1] key = 2 output: 2
	 */
	public static void main(String[] args) {
		System.out.println(
				"input =[3,2,3,6,3,10,9,3] key=3 output: 4 got : " + remove(new int[] { 3, 2, 3, 6, 3, 10, 9, 3 }, 3));
		System.out.println("input =[2,11,2,2,1] key=2 output: 2 got : " + remove(new int[] { 2, 11, 2, 2, 1 }, 2));
	}

	public static int remove(int[] arr, int key) {
		int start = 0;
		int len = arr.length;
		for (int end = 0; end < len; end++) {
			if (arr[end] != key) {
				arr[start++] = arr[end];
			}
		}
		System.out.println(Arrays.toString(arr));
		return start;
	}
}
