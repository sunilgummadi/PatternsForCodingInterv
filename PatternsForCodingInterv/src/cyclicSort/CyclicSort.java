/**
 * 
 */
package cyclicSort;

import java.util.Arrays;

/**
 * @author gummadisunil.kumar
 *
 */
public class CyclicSort {

	/**
	 * We are given an array containing n objects. Each object when created was
	 * assigned a unique number from 1 to n based on their creation sequence. This
	 * means that the object with sequence number 3 was created just before the
	 * object with sequence number 4.
	 * 
	 * Write a function to sort the object in place on their creation sequence
	 * number in O(n) and without any extra space. For simplicity let's assume we
	 * are passed an integer array containing only the sequence numbers, though each
	 * number is actually an object.
	 * 
	 * Input: [3,1,5,4,2] Output:[1,2,3,4,5]
	 * 
	 * Input: [2,6,4,3,1,5] Output: [1,2,3,4,5,6]
	 * 
	 * Input: [1,5,6,4,3,2] Output:[1,2,3,4,5,6]
	 */
	public static void main(String[] args) {
		int[] arr = new int[] { 3, 1, 5, 4, 2 };
		sort(arr);
		System.out.println("Input: [3,1,5,4,2] Output:[1,2,3,4,5] : got : " + Arrays.toString(arr));
		int[] arr1 = new int[] { 2, 6, 4, 3, 1, 5 };
		sort(arr1);
		System.out.println("Input: [2,6,4,3,1,5] Output: [1,2,3,4,5,6] : got : " + Arrays.toString(arr1));
		int[] arr2 = new int[] { 1, 5, 6, 4, 3, 2 };
		sort(arr2);
		System.out.println("Input: [1,5,6,4,3,2] Output:[1,2,3,4,5,6] : got : " + Arrays.toString(arr2));

	}

	public static void sort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
	}
}
