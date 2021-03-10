/**
 * 
 */
package dfs;

/**
 * @author gummadisunil.kumar
 *
 */
public class SumOfPathNumbersAct {

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

		return findPathNumbers(root, 0);

	}

	public static int findPathNumbers(TreeNode root, int pathSum) {
		if (root == null)
			return 0;
		pathSum = 10 * pathSum + root.val;
		if (root.left == null && root.right == null)
			return pathSum;
		return findPathNumbers(root.left, pathSum) + findPathNumbers(root.right, pathSum);
	}
}
