/**
 * 
 */
package twoPointers;

/**
 * @author gummadisunil.kumar
 *
 */
public class PairWithTargetSum {

	/**
	 * Given an array of sorted numbers and a target sum, find a pair in the array
	 * whose sum is equal to the given target . Write a function to return the
	 * indices of the two numbers such that they add up to the given target
	 * input:[1,2,3,4,6], target=6 output:[1,3] input:[2,5,39,11], target=11
	 * output:[0,2]
	 */
	static int[] result;

	public static void main(String[] args) {
		result = search(new int[] { 1, 2, 3, 4, 6 }, 6);
		System.out.println(
				"input:[1,2,3,4,6], target=6 output:[1,3] got : " + "[ " + result[0] + ", " + result[1] + " ]");
		result = search(new int[] { 2, 5, 9, 11 }, 11);
		System.out.println(
				"input:[2,5,9,11], target=11 output:[0,2] got : " + "[ " + result[0] + ", " + result[1] + " ]");
	}

	public static int[] search(int[] arr, int targetSum) {

		int startIndex = 0;
		int endIndex = arr.length - 1;
		int sum;
		while (startIndex < endIndex) {
			sum = arr[startIndex] + arr[endIndex];
			if (sum == targetSum) {
				return new int[] { startIndex, endIndex };
			}
			if (sum > targetSum)
				endIndex--;
			else
				startIndex++;
		}
		return new int[] { -1, -1 };
	}
}
