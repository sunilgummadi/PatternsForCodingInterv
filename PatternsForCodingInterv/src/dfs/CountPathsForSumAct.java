/**
 * 
 */
package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author gummadisunil.kumar
 *
 */
public class CountPathsForSumAct {

	/**
	 * Given a binary tree and a number s, find all paths in the tree such that the
	 * sum of all the node values of each path equals s. Please note that the paths
	 * can start or end at any node but all paths must follow direction from parent
	 * to child.
	 * 
	 * S:12 Output: 3 there are three paths with sum 12 (7->5,1->9->2,9_.3)
	 * [[1],[a7,9],[6,5,2,3]]
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + countPaths(root, 11));
	}

	public static int countPaths(TreeNode root, int S) {
		List<Integer> currentPath = new ArrayList<>();

		return findAllCount(root, S, currentPath);
	}

	public static int findAllCount(TreeNode root, int S, List<Integer> currentPath) {
		if (root == null)
			return 0;
		// add current node to the path
		currentPath.add(root.val);
		int pathCount = 0;
		int pathSum = 0;
		// find the sums of all sub-paths in the current path list
		ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
		while (pathIterator.hasPrevious()) {
			pathSum += pathIterator.previous();
			if (pathSum == S)
				pathCount++;
		}

		pathCount += findAllCount(root.left, S, currentPath);
		pathCount += findAllCount(root.right, S, currentPath);

		currentPath.remove(currentPath.size() - 1);
		return pathCount;
	}

}
