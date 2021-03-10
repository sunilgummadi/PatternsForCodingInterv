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
public class PermutationsRecursive {

	/**
	 * Given a set of distinct numbers find all of its permutations.
	 * 
	 * Permutation is defined as the re arranging of the elements of the set. For
	 * example {1,2,3} has the following six
	 * permutations.[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]
	 * 
	 * If a set has n distinct elements it will have n! permutations.
	 */
	public static void main(String[] args) {
		System.out.println("Here are all the permutations: " + findPermutations(new int[] { 1, 3, 5 }));
	}

	public static List<List<Integer>> findPermutations(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		generatePermutations(nums, 0, new ArrayList<>(), result);
		return result;
	}

	public static void generatePermutations(int[] nums, int index, List<Integer> currentPermut,
			List<List<Integer>> result) {
		if (index == nums.length)
			result.add(currentPermut);
		else {
			for (int i = 0; i <= currentPermut.size(); i++) {
				List<Integer> newPermutation = new ArrayList<>(currentPermut);
				newPermutation.add(i, nums[index]);
				generatePermutations(nums, index + 1, newPermutation, result);
			}
		}
	}
}
