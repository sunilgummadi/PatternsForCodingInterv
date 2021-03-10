/**
 * 
 */
package cyclicSort;

import java.util.Arrays;

/**
 * @author gummadisunil.kumar
 *
 */
public class FindSmallestMissingPositive {

	/**
	 * Given an unsorted array containing numbers, find the smallest missing
	 * positive number in it.
	 * 
	 * Input: [-3,1,5,4,2] Output: 3
	 * 
	 * Input: [3,-2,0,1,2] Output: 4
	 * 
	 * Input: [3,2,5,1] Output: 4
	 */
	public static void main(String[] args) {
		System.out.println("Input: [-3,1,5,4,2] Output: 3 got :" + findNumber(new int[] { -3, 1, 5, 4, 2 }));
		System.out.println("Input: [3,-2,0,1,2] Output: 4 got :" + findNumber(new int[] { 3, -2, 0, 1, 2 }));
		System.out.println("Input: [3,2,5,1] Output: 4 got :" + findNumber(new int[] { 3, 2, 5, 1 }));
	}
	
	public static int findNumber(int[] nums) {
		int i=0;
		int len = nums.length;
		int temp;
		int j;
		while(i<len) {
			if(nums[i]>0 && nums[i]<len && nums[i]!=nums[nums[i]-1]) {
				j = nums[i]-1;
				temp = nums[i];
				nums[i]=nums[j];
				nums[j]=temp;
			}else
				i++;
		}
		System.out.println(Arrays.toString(nums));
		for(i=0;i<len;i++) {
			if( nums[i]!=i+1)
				return i+1;
		}
		return len+1;
	}
}
