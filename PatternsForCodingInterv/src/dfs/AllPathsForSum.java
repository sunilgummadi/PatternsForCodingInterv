/**
 * 
 */
package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gummadisunil.kumar
 *
 */
public class AllPathsForSum {

	/**
	 * Given a binary tree and a number s, find all paths from root to leaf such
	 * that the sum of all the node values of each path equals s.
	 * 
	 * S:12 Output:2 there are two paths for 12 (1->7->4 and 1->9->2)
	 * [[1],[7,9],[4,5,2,7]]
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree Paths with sum 23 : " + findPaths(root, 23));
	}

	public static List<List<Integer>> findPaths(TreeNode root, int sum) {
		List<List<Integer>> allPaths = new ArrayList<List<Integer>>();
		List<Integer> currentPath = new ArrayList<>();
		findAllPaths(root, sum, currentPath, allPaths);
		return allPaths;
	}

	public static void findAllPaths(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
		if (root == null)
			return;
		currentPath.add(root.val);
		if (root.val == sum && root.left == null && root.right == null) {
			allPaths.add(new ArrayList<>(currentPath));
		} else {
			findAllPaths(root.left, sum - root.val, currentPath, allPaths);
			findAllPaths(root.right, sum - root.val, currentPath, allPaths);
		}
		//remove the current node from the path to backtrack
		currentPath.remove(currentPath.size() - 1);
	}
}
