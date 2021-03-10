/**
 * 
 */
package twoPointers;

import java.util.Arrays;

/**
 * @author gummadisunil.kumar
 *
 */
public class TripleSumCloseToTarget {

	/**
	 * Given an array of unsorted numbers and a target number find a triplet in the
	 * array whose sum is as close to the target number as possible return the sum
	 * of the triplet. If there are more than one such triplet return the sum of the
	 * triplet with the smallest sum. Input: [-2,0,1,2] target=2 output:1 [-2,1,2]
	 * Input: [-3,-1,1,2] target=1 output:0 [-3,1,2] Input: [1,0,1,1] target=100
	 * Output:3 [1,1,1]
	 */
	public static void main(String[] args) {
		System.out.println("Input: [-2,0,1,2] target=2 output:1 got :" + searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
		System.out.println("Input: [-3,-1,1,2] target=1 output:0 got :" + searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
		System.out.println("Input: [1,0,1,1] target=100 Output:3 got :" + searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
	}

	public static int searchTriplet(int[] arr, int targetSum) {
		Arrays.sort(arr);
		int left;

		int max = -1;
		int len = arr.length;
		int right;
		int currentSum;
		for (int i = 0; i < len - 2; i++) {
			if (i > 0 && arr[i] == arr[i - 1])
				continue;
			left = i + 1;
			right = len - 1;
			while (left < right) {
				currentSum = arr[left] + arr[right] + arr[i];
				if (currentSum <= targetSum) {
					max = Math.max(max, currentSum);
					left++;
					//right--;
//					while (left < right && arr[left] == arr[left - 1])
//						left++;
//					while (left < right && arr[right] == arr[right + 1])
//						right--;
				} else 
					right--;
			}
		}
		return max;
	}

}
