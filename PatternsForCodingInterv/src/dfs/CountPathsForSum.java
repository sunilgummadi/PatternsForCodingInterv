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
public class CountPathsForSum {

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
		List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		findAllCount(root, allPaths, currentPath);
		int count = 0;
		int sum;
		for (int i = 0; i < allPaths.size(); i++) {
			sum = 0;
			for (int j = 0; j < allPaths.get(i).size(); j++) {
				sum += allPaths.get(i).get(j);
				if (sum == S) {
					count++;
					break;
				}
				if (sum > S && j > 0) {
					sum -= allPaths.get(i).get(j - 1);
				}
			}
		}
		return count;
	}

	public static void findAllCount(TreeNode root, List<List<Integer>> allPaths, List<Integer> currentPath) {
		if (root == null)
			return;
		currentPath.add(root.val);
		if (root.left == null && root.right == null)
			allPaths.add(new ArrayList<>(currentPath));
		else {
			findAllCount(root.left, allPaths, currentPath);
			findAllCount(root.right, allPaths, currentPath);
		}
		currentPath.remove(currentPath.size() - 1);
	}

}
