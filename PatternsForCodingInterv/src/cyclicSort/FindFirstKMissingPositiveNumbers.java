/**
 * 
 */
package cyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gummadisunil.kumar
 *
 */
public class FindFirstKMissingPositiveNumbers {

	/**
	 * Given an unsorted array containing numbers and a number k find the first k
	 * missing positive numbers in array.
	 * 
	 * Input: [3,-1,4,5,5] k=3 Output: [1,2,6]
	 * 
	 * Input: [2,3,4] k=3 Output:[1,5,6]
	 * 
	 * Input: [-2,-3,4] k=2 Output: [1,2]
	 */
	public static void main(String[] args) {
		System.out.println(
				"Input: [3,-1,4,5,5] k=3 Output: [1,2,6] got :" + findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3));
		System.out.println("Input: [2,3,4] k=3 Output:[1,5,6] got :" + findNumbers(new int[] { 2, 3, 4 }, 3));
		System.out.println("Input: [-2,-3,4] k=2 Output: [1,2] got :" + findNumbers(new int[] { -2, -3, 4 }, 2));
	}

	public static List<Integer> findNumbers(int[] nums, int k) {
		List<Integer> missingNumbers = new ArrayList<>();
		int i = 0;
		int j;
		int temp;
		int len = nums.length;
		while (i < len) {
			j = nums[i] - 1;
			if (nums[i] > 0 && nums[i] <= len && nums[i] != nums[j]) {
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			} else
				i++;
		}
		Set<Integer> extraNumbers = new HashSet<>();
		for (i = 0; i < len; i++) {
			if (k > 0 && nums[i] != i + 1) {
				missingNumbers.add(i + 1);
				k--;
			}
			extraNumbers.add(nums[i]);
		}
		temp = len;
		while (k > 0) {
			if (!extraNumbers.contains(++temp)) {
				missingNumbers.add(temp);
				k--;
			}

		}

		return missingNumbers;
	}
}
