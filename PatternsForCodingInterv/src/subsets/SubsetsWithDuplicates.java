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
public class SubsetsWithDuplicates {

	/**
	 * Given a set of numbers that might contain duplicates find all its distinct
	 * subsets.
	 * 
	 * Input: [1,3,3] Output:[],[1],[3],[1,3],[3,3],[1,3,3]
	 */
	public static void main(String[] args) {
		System.out.println("Here is the list of subsets: " + findSubsets(new int[] { 1, 3, 3 }));
		System.out.println("Here is the list of subsets: " + findSubsets(new int[] { 1, 5, 3, 3 }));
	}

	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		subsets.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			int n = subsets.size();
			for (int j = 0; j < n; j++) {
				List<Integer> subset = new ArrayList<>(subsets.get(j));
				subset.add(nums[i]);
				if (!subsets.contains(subset)) {
					subsets.add(subset);
				}
			}
		}
		return subsets;
	}
}
