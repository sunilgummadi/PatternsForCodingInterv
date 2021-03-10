/**
 * 
 */
package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class SubSets {

	/**
	 * Given a set with distinct elements find all its distinct subsets.
	 * 
	 * Input: [1,3] Output:[],[1],[3],[1,3]
	 */
	public static void main(String[] args) {
		System.out.println("Here is the list of subsets: " + findSubsets(new int[] { 1, 3 }));
		System.out.println("Here is the list of subsets: " + findSubsets(new int[] { 1, 5, 3 }));
	}

	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		int n = nums.length;
		int numberOfSubsets = (int) Math.pow(2, n);
		List<Integer> currentSubset;
		for (int i = 0; i < numberOfSubsets; i++) {
			currentSubset = new ArrayList<>();
			String bin = binary(i, n);
			for (int j = 0; j < n; j++) {
				if (bin.charAt(j) == '1')
					currentSubset.add(nums[j]);

			}
			subsets.add(currentSubset);
		}
		return subsets;
	}

	public static String binary(int num, int len) {
		String result = "";
		int rem;
		while (num > 0) {
			rem = num % 2;
			result = rem + result;
			num /= 2;
		}
		while (result.length() != len)
			result = "0" + result;

		return result;
	}
}
