/**
 * 
 */
package twoPointers;

import java.util.HashMap;

/**
 * @author gummadisunil.kumar
 *
 */
public class PairWithTargetSumAnotherApproch {

	/**
	 * Given an array of sorted numbers and a target sum, find a pair in the array
	 * whose sum is equal to the given target . Write a function to return the
	 * indices of the two numbers such that they add up to the given target
	 * input:[1,2,3,4,6], target=6 output:[1,3] input:[2,5,39,11], target=11
	 * output:[0,2]
	 */
	static int[] result;

	/**
	 * Instead of using a two pointer or a binary approach we can utilize a hash
	 * table to search for the required pair. We can iterate through the array one
	 * number at a time and search for y which is equivalent to target-x
	 */
	public static void main(String[] args) {
		result = search(new int[] { 1, 2, 3, 4, 6 }, 6);
		System.out.println(
				"input:[1,2,3,4,6], target=6 output:[1,3] got : " + "[ " + result[0] + ", " + result[1] + " ]");
		result = search(new int[] { 2, 5, 9, 11 }, 11);
		System.out.println(
				"input:[2,5,9,11], target=11 output:[0,2] got : " + "[ " + result[0] + ", " + result[1] + " ]");
	}

	public static int[] search(int[] arr, int targetSum) {

		
		HashMap<Integer, Integer> numFreq = new HashMap<>();
		int x;
		for (int i = 0; i < arr.length; i++) {
			x = arr[i];
			if (numFreq.containsKey(targetSum - x)) {
				return new int[] { numFreq.get(targetSum - x),i };
			}
			numFreq.put(x, i);
		}
		return new int[] { -1, -1 };
	}
}
