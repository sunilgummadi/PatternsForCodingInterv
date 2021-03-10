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
public class SubSetsAct {

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
		subsets.add(new ArrayList<>());
		int size;
		for (int i = 0; i < nums.length; i++) {
			size = subsets.size();
			for (int j = 0; j < size; j++) {
				List<Integer> subset = new ArrayList<>(subsets.get(j));
				subset.add(nums[i]);
				subsets.add(subset);
			}

		}

		return subsets;
	}

}
