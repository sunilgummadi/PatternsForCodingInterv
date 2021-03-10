/**
 * 
 */
package cyclicSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class FindAllDuplicateNumbersAct {

	/**
	 * We are given an unsorted array containing n numbers taken from the range 1 to
	 * n. The array has some numbers appearing twice, find all these duplicate
	 * numbers without using any extra space.
	 * 
	 * Input: [3,4,4,5,5] Output:[4,5]
	 * 
	 * Input: [5,4,7,2,3,5,3] Output: [3,5]
	 */
	public static void main(String[] args) {
		System.out.println("Input: [3,4,4,5,5] Output:[4,5] got : " + findNumbers(new int[] { 3, 4, 4, 5, 5 }));
		System.out.println(
				"Input: [5,4,7,2,3,5,3] Output: [3,5] got : " + findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 }));
	}

	public static List<Integer> findNumbers(int[] nums) {
		List<Integer> duplicateNumbers = new ArrayList<>();
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
				duplicateNumbers.add(nums[i]);
		}
		return duplicateNumbers;
	}
}
