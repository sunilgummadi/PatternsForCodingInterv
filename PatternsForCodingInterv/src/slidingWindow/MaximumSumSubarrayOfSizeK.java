/**
 * 
 */
package slidingWindow;

/**
 * @author gummadisunil.kumar
 *
 */
public class MaximumSumSubarrayOfSizeK {

	/**
	 * GIven an array of positive numbers and a positive number k find the maximum
	 * sum of any contiguous subarray of size k input =[2,1,5,1,3,2] k=3 output 9
	 * input =[2,3,4,1,5] k=2 output 7
	 */
	public static void main(String[] args) {
		System.out.println(
				"input =[2,1,5,1,3,2] k=3 output 9 got : " + findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
		System.out
				.println("input =[2,3,4,1,5] k=2 output 7 got : " + findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
	}

	public static int findMaxSumSubArray(int k, int[] arr) {
		int maxSum = 0;
		int sum = 0;
		int startIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			while (i - startIndex + 1 > k) {
				sum -= arr[startIndex++];
			}
			if (i - startIndex + 1 == k) {
				maxSum = Math.max(maxSum, sum);
			}
			
		}
		return maxSum;
	}
}
