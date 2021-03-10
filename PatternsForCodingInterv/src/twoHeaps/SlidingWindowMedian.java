/**
 * 
 */
package twoHeaps;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author gummadisunil.kumar
 *
 */
public class SlidingWindowMedian {

	/**
	 * Given an array of numbers and a number k find the median of all the k sized
	 * sub arrays of the array.
	 */
	public static void main(String[] args) {
		System.out.println("Sliding window medians are: [1.5,0.5,1.0,4.0] got :"
				+ Arrays.toString(findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2)));
		System.out.println("Sliding window medians are: [1.0,2.0,3.0] got : "
				+ Arrays.toString(findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3)));
	}

	public static double[] findSlidingWindowMedian(int[] nums, int k) {
		double[] result = new double[nums.length - k + 1];
		int start = 0;
		int end;
		int sum = 0;
		int i = 0;
		TreeSet<Integer> sorted = new TreeSet<>();
		Integer[] arr= new Integer[k];
 		for (end = 0; end < nums.length; end++) {
			sorted.add(nums[end]);
			if (end - start + 1 > k) {
				sorted.remove(nums[start++]);
			}
			if (end - start + 1 == k) {
				arr = sorted.toArray(arr);
				if (k % 2 == 0) {
					sum = arr[(k - 2) / 2] + arr[k / 2];
					result[i++] = sum / 2.0;
				} else {	
					result[i++] = arr[k / 2] ;
				}
					
				
			}
		}
		return result;
	}
}
