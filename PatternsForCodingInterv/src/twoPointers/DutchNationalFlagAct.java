/**
 * 
 */
package twoPointers;

import java.util.Arrays;

/**
 * @author gummadisunil.kumar
 *
 */
public class DutchNationalFlagAct {

	/**
	 * Given an array containing 0's, 1's and 2's sort the array in place. You
	 * should treat numbers of the array as objects, hence we can't count 0s,1s and
	 * 2s to recreate the array . The flag of the Netherlands consists of three
	 * colors:red, white and blue; and since our input array also consists of three
	 * different numbers that is why it is called Dutch national flag problem.
	 * 
	 * Input:[1,0,2,1,0] output: [0,0,1,1,2] Input: [2,2,0,1,2,0]
	 * output:[0,0,1,2,2,2]
	 */
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 0, 2, 1, 0 };
		sort(arr);
		System.out.println(" Input:[1,0,2,1,0] output: [0,0,1,1,2] got : " + Arrays.toString(arr));
		arr = new int[] { 2, 2, 0, 1, 2, 0 };
		sort(arr);
		System.out.println(" Input: [2,2,0,1,2,0] output:[0,0,1,2,2,2] got : " + Arrays.toString(arr));
	}

	public static void sort(int[] arr) {

		int low = 0;
		int len = arr.length;
		int heigh = len - 1;
		int i = 0;
		while (i <= heigh) {
			if (arr[i] == 0) {
				swap(arr, i, low);
				low++;
				i++;
			} else if (arr[i] == 1)
				i++;
			else {
				swap(arr, i, heigh);
				heigh--;
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
