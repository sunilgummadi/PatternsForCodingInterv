/**
 * 
 */
package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class SubsetsWithDuplicatesAct {

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
		Arrays.sort(nums);
		subsets.add(new ArrayList<>());
		int startIndex = 0;
		int endIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			startIndex = 0;
			// if current and the previous elements are same create new subsets only from
			// the subsets added in the previous step
			if (i > 0 && nums[i] == nums[i - 1])
				startIndex = endIndex + 1;
			endIndex = subsets.size() - 1;
			for (int j = startIndex; j <= endIndex; j++) {
				// create a new subset from the existing subset and add the current element to
				// it
				List<Integer> subset = new ArrayList<>(subsets.get(j));
				subset.add(nums[i]);
				subsets.add(subset);
			}
		}
		return subsets;
	}
}
