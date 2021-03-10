/**
 * 
 */
package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class TripleSumToZero {

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
				+ searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
	}
//failed some test cases if there is [-10,5] it is showing output [-10,5,5]
	public static List<List<Integer>> searchTriplets(int[] arr) {
		List<List<Integer>> triplets = new ArrayList<>();
		HashMap<Integer, Integer> intFreq = new HashMap<>();
		int len = arr.length;
		int sum = 0;
		Arrays.sort(arr);
		int start = 1;
		for (int end = 1; end < len; end++) {
			if (arr[start - 1] != arr[end]) {
				arr[start++] = arr[end];
			}
		}
		for (int i = 0; i < start; i++)
			intFreq.put(arr[i], intFreq.getOrDefault(arr[i], 0) + 1);
		for (int i = 0; i < start - 1; i++) {
			for (int j = i + 1; j < start; j++) {
				sum = arr[i] + arr[j];
				if (intFreq.containsKey(-sum) && -sum >= arr[i] && -sum >= arr[j]) {
					triplets.add(Arrays.asList( arr[i], arr[j], -sum ));
				}
			}
		}
		return triplets;
	}
}
