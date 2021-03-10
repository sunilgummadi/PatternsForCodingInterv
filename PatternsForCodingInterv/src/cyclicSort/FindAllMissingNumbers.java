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
public class FindAllMissingNumbers {

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
		int[] check = new int[nums.length];
		for (int num : nums)
			check[num-1]=1;
		for (int i = 0; i < check.length; i++) {
			if (check[i] == 0)
				missingNumbers.add(i + 1);
		}
		return missingNumbers;
	}
}
