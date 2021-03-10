/**
 * 
 */
package slidingWindow;

/**
 * @author gummadisunil.kumar
 *
 */
public class SmallestSubarrayWithaGivenSum {

	/**
	 * Given an array of positive numbers and a positive number 'S' find the length
	 * of the smallest contiguous subarray whose sum is greater than or equal to
	 * 'S'. Return 0 if no subarray exists. Input=[2,1,5,2,3,2], S=7 output:2
	 * Input=[2,1,5,2,8], S=7 output:1 Input=[3,4,1,1,6], S=8 output:3
	 */
	public static void main(String[] args) {
		System.out.println(
				"Input=[2,1,5,2,3,2], S=7 output:2 got : " + findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 }));
		System.out.println("Input=[2,1,5,2,8], S=7 output:1 got :" + findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 }));
		System.out.println("Input=[3,4,1,1,6], S=8 output:3 got :" + findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 }));
	}

	public static int findMinSubArray(int S, int[] arr) {
		int startIndex = 0;
		int endIndex;
		int sum = 0;
		int min = arr.length;
		for (endIndex = 0; endIndex < arr.length; endIndex++) {
			sum += arr[endIndex];
			while (sum >= S) {
				min = Math.min(min, endIndex - startIndex + 1);
				sum -= arr[startIndex++];

			}
		}
		return min == arr.length ? 0 : min;
	}
}
