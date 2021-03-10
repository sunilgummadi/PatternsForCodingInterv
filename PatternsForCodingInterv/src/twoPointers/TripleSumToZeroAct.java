/**
 * 
 */
package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class TripleSumToZeroAct {

	/**
	 * Given an array of unsorted numbers find all unique triplets in it that add up
	 * to zero. input:[-3,0,1,2,-1,1,-2]
	 * output:[[-3,1,2],[-2,0,2],[-2,1,1],[-1,0,1]] input:[-5,2,-1,-2,3]
	 * output:[[-5,2,3],[-2,-1,3]]
	 */
	public static void main(String[] args) {
		System.out.println("input:[-3,0,1,2,-1,1,-2] output:[[-3,1,2],[-2,0,2],[-2,1,1],[-1,0,1]] got :"
				+ searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
		System.out.println("input:[-5,2,-1,-2,3] output:[[-5,2,3],[-2,-1,3]] got :"
				+ searchTriplets(new int[] { -5, 2, -1, -2, 3}));
	}

	// done by own
	public static List<List<Integer>> searchTriplets(int[] arr) {
		List<List<Integer>> triplets = new ArrayList<>();
		int len = arr.length;
		Arrays.sort(arr);
		for (int i = 0; i < len - 2; i++) {
			if (i > 0 && arr[i] == arr[i - 1])
				continue;
			searchPair(arr, -arr[i], i + 1, len - 1, triplets);
		}
		return triplets;
	}

	public static void searchPair(int[] arr, int targetSum, int left, int right, List<List<Integer>> triplets) {
		int currentSum;
		while (left < right) {
			currentSum = arr[left] + arr[right];
			if (currentSum == targetSum) {// found triplet
				triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
				left++;
				right--;
				while (left < right && arr[left] == arr[left - 1])
					left++; // skip same element to avoid duplicate triplets
				while (left < right && arr[right] == arr[right + 1])
					right--;
			} else if (currentSum > targetSum)
				right--; // we need to pair with lower sum
			else
				left++;// we need to pair with bigger sum
		}
	}
}
