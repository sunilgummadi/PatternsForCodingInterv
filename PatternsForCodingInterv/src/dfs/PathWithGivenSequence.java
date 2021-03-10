/**
 * 
 */
package dfs;

/**
 * @author gummadisunil.kumar
 *
 */
public class PathWithGivenSequence {

	/**
	 * Given a binary tree and a number sequence, find if the sequence is present as
	 * a root to leaf path in the given tree.
	 * 
	 * Sequence: [1,9,9] output:true tree has path 1->9->9 [[1],[7,9],[2,9]]
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path sequence : " + findPath(root, new int[] { 1, 0, 7 }));
		System.out.println("Tree has path sequence : " + findPath(root, new int[] { 1, 1, 6 }));
	}

	public static boolean findPath(TreeNode root, int[] sequence) {
		if (root == null)
			return sequence.length == 0;

		return findPathRecursive(root, sequence, 0);
	}

	public static boolean findPathRecursive(TreeNode root, int[] sequence, int index) {
		if (root == null)
			return false;
		if (index >= sequence.length || root.val != sequence[index])
			return false;
		if (root.left == null && root.right == null && root.val == sequence[index])
			return true;
		return findPathRecursive(root.left, sequence, index + 1) || findPathRecursive(root.right, sequence, index + 1);
	}
}
