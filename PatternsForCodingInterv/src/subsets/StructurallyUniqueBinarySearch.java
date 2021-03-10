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
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		this.val = x;
	}
};

public class StructurallyUniqueBinarySearch {

	/**
	 * Given a number n write a function to return all structurally unique binary
	 * search tree that can store values 1 to n.
	 * 
	 * Input:1 Output: List containing root nodes of all structurally unique bsts.
	 * Explanation: here are the 2 structurally unique BSTs storing all numbers from
	 * 1 to 2.
	 * 
	 * 1->2 and 2->1
	 */
	public static void main(String[] args) {
		System.out.println("Total trees: " + findUniqueTrees(3).size());
	}

	public static List<TreeNode> findUniqueTrees(int n) {
		if (n <= 0)
			return new ArrayList<TreeNode>();

		return findUniqueTreesRecursion(1, n);
	}

	public static List<TreeNode> findUniqueTreesRecursion(int start, int end) {
		List<TreeNode> result = new ArrayList<>();
		// base condition,return null for an empty subtree consider n=1 in this case we
		// will have start=end=1, this means we should have only one tree we will have
		// two recursive calls, findUniqueTreesRecursive(1,0) & (2,1) both of these
		// should return null for the left and the right child
		if (start > end) {
			result.add(null);
			return result;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> leftSubtrees = findUniqueTreesRecursion(start, i - 1);
			List<TreeNode> rightSubtrees = findUniqueTreesRecursion(i + 1, end);
			for (TreeNode leftTree : leftSubtrees) {
				for (TreeNode rightTree : rightSubtrees) {
					TreeNode root = new TreeNode(i);
					root.left = leftTree;
					root.right = rightTree;
					result.add(root);
				}
			}
		}
		return result;
	}
}
