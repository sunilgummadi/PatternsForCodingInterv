/**
 * 
 */
package twoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class SubarraysWithProductLessThanTarget {

	/**
	 * Given an array with positive numbers and a target number, find all of its
	 * contiguous sub arrays whose product is less than the target number
	 * Input:[2,5,3,10], target = 30 output: [2],[5],[2,5],[3],[5,3],[10]
	 * Input:[8,2,6,5], target = 50 output: [8],[2],[8,2],[6],[2,6],[5],[6,5]
	 */
	public static void main(String[] args) {
		System.out.println("Input:[2,5,3,10], target = 30 output: [[2],[5],[2,5],[3],[5,3],[10]] got : "
				+ findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
		System.out.println("Input:[8,2,6,5], target = 50 output: [[8],[2],[8,2],[6],[2,6],[5],[6,5] got : "
				+ findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
	}

	public static List<List<Integer>> findSubarrays(int[] arr, int target) {
		//Arrays.sort(arr);
		List<List<Integer>> subarrays = new ArrayList<>();
		List<Integer> sub_array;
		int left = 0;
		int right;
		int mul = 1;
		for(right=0;right<arr.length;right++) {
			mul *= arr[right];
			while(mul>=target && left<arr.length) {
				mul/=arr[left++];
			}
			sub_array = new ArrayList<>();
			for(int i = right;i>=left;i--) {
				sub_array.add(0,arr[i]);
				subarrays.add(new ArrayList<>(sub_array));
			}
			
		}
//		for (right = 0; right < arr.length; right++) {
//			mul *= arr[right];
//			while (mul >= target) {
//				mul /= arr[left++];
//			}
//			if (mul < target) {
//				sub_array = new ArrayList<>();
//				for (int i = right; i >= left; i--) {	
//					sub_array.add(0,arr[i]);
//				}
//				subarrays.add(sub_array);
//				
//			}
//			
//		}
		return subarrays;
	}
}
