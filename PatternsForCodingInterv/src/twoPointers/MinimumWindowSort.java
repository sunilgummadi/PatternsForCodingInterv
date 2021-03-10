/**
 * 
 */
package twoPointers;

/**
 * @author gummadisunil.kumar
 *
 */
public class MinimumWindowSort {

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
		while (left >= 0 && left < len - 1) {
			if (arr[left] < arr[left + 1])
				left++;
			else
				break;
		}
		while (right > 0 && right < len) {

			if (arr[right] > arr[right - 1])
				right--;
			else
				break;
		}
		int count = 0;
		int index = left - 1;
		for (int i = right; i > left; i--) {
			if (index >= 0 && arr[i] < arr[index--])
				count++;
			if (index < 0)
				break;
		}

		return left == len - 1 && right == 0 ? 0 : right - left + 1 + count;
	}

}
