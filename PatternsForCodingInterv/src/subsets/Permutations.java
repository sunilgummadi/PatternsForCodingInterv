/**
 * 
 */
package subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author gummadisunil.kumar
 *
 */
public class Permutations {

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
		Queue<List<Integer>> current = new LinkedList<>();
		current.add(new ArrayList<>());
		for (int num : nums) {
			//we will take all existing permutations and add the current number to create new permutation
			int n = current.size();
			for (int i = 0; i < n; i++) {
				List<Integer> temp = current.poll();
				//create new permutation by adding the current number to every position
				for (int j = 0; j <= temp.size(); j++) {
					List<Integer> newPermutation = new ArrayList<Integer>(temp);
					newPermutation.add(j, num);
					if (newPermutation.size() == nums.length)
						result.add(new ArrayList<>(newPermutation));
					else
						current.add(new ArrayList<>(newPermutation));
				}
			}
		}
		return result;
	}
}
