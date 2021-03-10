/**
 * 
 */
package twoPointers;

import java.util.Arrays;

/**
 * @author gummadisunil.kumar
 *
 */
public class TripletsWithSmallerSumAct {

	/**
	 * Given an array arr of unsorted numbers and a target sum, count all triple in
	 * it such that arr[i] + arr[j] + arr[k} < target where i,j and k are three
	 * different indices. Write a function to return the count of such triplets
	 * input: [-1,0,2,3], target=3 output:2 input: [-1,4,2,1,3], target=5 output:4
	 * 
	 */
	public static void main(String[] args) {
		System.out
				.println("input: [-1,0,2,3], target=3 output:2 got : " + searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
		System.out.println(
				"input: [-1,4,2,1,3], target=5 output:4 got : " + searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
	}

	public static int searchTriplets(int[] arr, int target) {
		int count = 0;
		int len = arr.length;
		int left;
		int right;
		int currentSum;
		Arrays.sort(arr);// [-1,1,2,3,4]
		for (int i = 0; i < len - 2; i++) {
			left = i + 1;
			right = len - 1;
			while (left < right) {
				currentSum = arr[i] + arr[left] + arr[right];
				if (currentSum < target) {
					count += right - left;
					left++;
				} else {
					right--;
				}

			}
		}
		return count;
	}
}
