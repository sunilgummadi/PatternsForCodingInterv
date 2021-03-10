/**
 * 
 */
package twoPointers;

import java.util.Arrays;

/**
 * @author gummadisunil.kumar
 *
 */
public class DutchNationalFlag {

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

		// Arrays.sort(arr);
		int count_0 = 0;
		int count_1 = 0;
		int count_2 = 0;
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (arr[i] == 0)
				count_0++;
			if (arr[i] == 1)
				count_1++;
			if (arr[i] == 2)
				count_2++;
		}
		int j = 0;
		while (count_0 != 0) {
			arr[j++] = 0;
			count_0--;
		}
		while (count_1 != 0) {
			arr[j++] = 1;
			count_1--;
		}
		while (count_2 != 0) {
			arr[j++] = 2;
			count_2--;
		}
	}
}
