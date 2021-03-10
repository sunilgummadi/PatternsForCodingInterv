/**
 * 
 */
package cyclicSort;

import java.util.Arrays;

/**
 * @author gummadisunil.kumar
 *
 */
public class FindCorruptPair {

	/**
	 * We are given an unsorted array containing n numbers taken from the range 1 to
	 * n.The array originally contained all the numbers from 1 to n but due to a
	 * data error one of the numbers got duplicated which also resulted in one
	 * number going missing. Find both these numbers.
	 * 
	 * Input: [3,1,2,5,2] Output: [2,4]
	 * 
	 * Input:[3,1,2,3,6,4] Output: [3,5]
	 */
	public static void main(String[] args) {
		System.out.println(
				"Input: [3,1,2,5,2] Output: [2,4] got : " + Arrays.toString(findNumbers(new int[] { 3, 1, 2, 5, 2 })));
		System.out.println("Input:[3,1,2,3,6,4] Output: [3,5] got : "
				+ Arrays.toString(findNumbers(new int[] { 3, 1, 2, 3, 6, 4 })));

	}

	public static int[] findNumbers(int[] nums) {
		int i = 0;
		int j;
		int temp;
		while (i < nums.length) {
			j = nums[i] - 1;
			if (nums[i] != nums[j]) {
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			} else
				i++;
		}
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1)
				return new int[] { nums[i], i + 1 };
		}
		return new int[] { -1, -1 };
	}
}
