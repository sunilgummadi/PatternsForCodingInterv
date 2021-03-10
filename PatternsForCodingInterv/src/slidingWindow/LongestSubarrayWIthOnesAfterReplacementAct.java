/**
 * 
 */
package slidingWindow;

/**
 * @author gummadisunil.kumar
 *
 */
public class LongestSubarrayWIthOnesAfterReplacementAct {

	/**
	 * Given an array containing 0s and 1s if you are allowed to replace no more
	 * than k 0s with 1s, find the length of the longest contiguous sub array having
	 * all 1s array=[0,1,1,0,0,0,1,1,0,1,1] k =2 output 6
	 * array=[0,1,0,0,1,1,0,1,1,0,0,1,1] , k=3 output:9
	 * 
	 */
	public static void main(String[] args) {

		System.out.println("array = [0,1,1,0,0,0,1,1,0,1,1] k =2 output 6 got :"
				+ findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
		System.out.println("array = [0,1,0,0,1,1,0,1,1,0,0,1,1] k =3 output 9 got :"
				+ findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));

	}
	//done in first attempt i was shocked similar to previous one
	public static int findLength(int[] arr, int k) {

		int maxLength = 0;
		int startIndex = 0;
		int endIndex;
		int sum = 0;
		//int max = 0;
		int windowSize = 0;
		for (endIndex = 0; endIndex < arr.length; endIndex++) {
			sum += arr[endIndex];
			windowSize = endIndex - startIndex + 1;
			//max = Math.max(sum, Math.abs(windowSize - sum));
			if (windowSize - sum > k) {
				sum -= arr[startIndex];
				startIndex++;
			}
			maxLength = Math.max(maxLength, endIndex - startIndex + 1);
		}
		return maxLength;
	}
}
