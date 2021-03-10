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
public class SumOfPathNumbers {

	/**
	 * Given a binary tree where each node can only have a digit (0-9) value, each
	 * root to leaf path will represent a number. Find the total sum of all the
	 * numbers represented by all paths.
	 * 
	 * Output: 408 The sum of all path numbers:17+192+199 [[1],[7,9],[2,9]]
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println("Total sum of path Numbers: " + findSumOfPathNumbers(root));
	}

	public static int findSumOfPathNumbers(TreeNode root) {
		List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> currentList = new ArrayList<>();
		findAllPaths(root, currentList, allPaths);
		int sum = 0;
		String currentSum;
		for (int i = 0; i < allPaths.size(); i++) {
			currentSum = "";
			for (int j = 0; j < allPaths.get(i).size(); j++) {
				currentSum += allPaths.get(i).get(j);
			}
			sum += Integer.parseInt(currentSum);
		}
		return sum;
	}

	public static void findAllPaths(TreeNode root, List<Integer> currentList, List<List<Integer>> allPaths) {
		if (root == null)
			return;
		currentList.add(root.val);
		if (root.left == null && root.right == null)
			allPaths.add(new ArrayList<>(currentList));
		else {
			findAllPaths(root.left, currentList, allPaths);
			findAllPaths(root.right, currentList, allPaths);
		}
		currentList.remove(currentList.size() - 1);
	}
}
