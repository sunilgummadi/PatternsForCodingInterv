/**
 * 
 */
package twoPointers;

/**
 * @author gummadisunil.kumar
 *
 */
public class MinimumWindowSortAct {

	/**
	 * Given an array, find the length of the smallest sub array in it which when
	 * sorted will sort the whole array.
	 * 
	 * Input: [1,2,5,3,7,10,9,12] output: 5 [5,3,7,10,9]
	 * 
	 * Input: [1,3,2,0,-1,7,10] output:5 [1,3,2,0,-1]
	 * 
	 * Input: [1,2,3] output: 0
	 * 
	 * Input: [3,2,1] output: 3
	 */
	public static void main(String[] args) {
		System.out
				.println("Input: [1,2,5,3,7,10,9,12] output: 5 got : " + sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
		System.out.println("Input: [1,3,2,0,-1,7,10] output:5 got : " + sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
		System.out.println("Input: [1,2,3] output: 0 got : " + sort(new int[] { 1, 2, 3 }));
		System.out.println("Input: [3,2,1] output: 3 got : " + sort(new int[] { 3, 2, 1 }));
	}

	public static int sort(int[] arr) {
		int left = 0;
		int len = arr.length;
		int right = len - 1;
		while (left < len - 1 && arr[left] <= arr[left + 1])
			left++;
		if (left == len - 1)
			return 0;// if array is sorted
		while (right > 0 && arr[right] >= arr[right - 1])
			right--;
		int subArrayMax = Integer.MIN_VALUE;
		int subArrayMin = Integer.MAX_VALUE;
		for (int i = left; i <= right; i++) {
			subArrayMax = Math.max(subArrayMax, arr[i]);
			subArrayMin = Math.min(subArrayMin, arr[i]);
		}
		while (left > 0 && arr[left - 1] > subArrayMin)
			left--;
		while (right < len - 1 && arr[right + 1] < subArrayMax)
			right++;
		return right - left + 1;

	}

}
