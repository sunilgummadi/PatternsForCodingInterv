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
public class QuadrupleSumToTarget {

	/**
	 * Given an array of unsorted numbers and a target number, find all unique
	 * quadruplets in it, whose sum is equal to the target number.
	 * 
	 * Input : [4,1,2,-1,1,-3] target = 1 output : [-3,-1,1,4], [-3,1,1,2]
	 * 
	 * Input : [2,0,-1,1,-2,2] target = 2 output : [-2,0,2,2,],[-1,0,1,2]
	 */
	public static void main(String[] args) {
		System.out.println("Input : [4,1,2,-1,1,-3] target = 1 output : [-3,-1,1,4], [-3,1,1,2] got :"
				+ searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
		System.out.println("Input : [2,0,-1,1,-2,2] target = 2 output : [-2,0,2,2,],[-1,0,1,2] got :"
				+ searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
	}

	public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
		List<List<Integer>> quadruplets = new ArrayList<>();
		Arrays.sort(arr);
		int len = arr.length;
		for (int i = 0; i < len - 3; i++) {
			if (i > 0 && arr[i] == arr[i - 1])
				continue;
			for (int j = i + 1; j < len - 2; j++) {
				if (j > i + 1 && arr[j] == arr[j - 1])
					continue;
				findPair(arr, j + 1, len - 1, quadruplets, arr[i], arr[j], target);
			}

		}
		return quadruplets;
	}

	public static void findPair(int[] arr, int left, int right, List<List<Integer>> quadruplets, int i, int j,
			int target) {
		int sum;
		int required = target - (i + j);
		while (left < right) {
			sum = arr[left] + arr[right];
			if (sum == required) {
				quadruplets.add(Arrays.asList(i, j, arr[left], arr[right]));
				left++;
				right--;
				while (left < right && arr[left] == arr[left - 1])
					left++;
				while (left < right && arr[right] == arr[right + 1])
					right--;
			} else if (sum < required)
				left++;
			else
				right--;
		}
	}
}
