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
public class FindAllMissingNumbersAct {

	/**
	 * We are given an unsorted array containing numbers taken from the range 1 to
	 * n. The array can have duplicates, which means some numbers will be missing.
	 * Find all those missing numbers.
	 * 
	 * Input: [2,3,1,8,2,3,5,1] Output: 4,6,7
	 * 
	 * Input: [2,4,1,2] Output: 3
	 * 
	 * Input: [2,3,2,1] Output: 4
	 */
	public static void main(String[] args) {
		System.out.println(
				"Input: [2,3,1,8,2,3,5,1] Output: 4,6,7 got : " + findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 }));
		System.out.println("Input: [2,4,1,2] Output: 3 got : " + findNumbers(new int[] { 2, 4, 1, 2 }));
		System.out.println("Input: [2,3,2,1] Output: 4 got : " + findNumbers(new int[] { 2, 3, 2, 1 }));
	}

	public static List<Integer> findNumbers(int[] nums) {
		List<Integer> missingNumbers = new ArrayList<>();
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
				missingNumbers.add(i + 1);
		}
		return missingNumbers;
	}
}
