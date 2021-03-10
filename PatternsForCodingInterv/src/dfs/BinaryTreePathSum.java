/**
 * 
 */
package dfs;

/**
 * @author gummadisunil.kumar
 *
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
};

public class BinaryTreePathSum {

	/**
	 * Given a binary tree and a number s, find if the tree has a path from root to
	 * leaf such that the sum of all the node values of that path equals s.
	 * 
	 * S:10 Output: true [[1],[2,3],[4,5,6,7]] path:1->3->6
	 * 
	 * S:23 Output: true [[12],[7,1],[9,10,5]] path:12->1->10 S:16 output:false
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path for sum 23: " + hasPath(root, 23));
		System.out.println("Tree has path for sum 16: " + hasPath(root, 16));
	}

	public static boolean hasPath(TreeNode root, int sum) {
		if (root == null)
			return false;
		// if the current node is a leaf and its value is equal to the sum we've found a
		// path
		if (root.val == sum && root.left == null && root.right == null)
			return true;
		// recursively call to traverse the left and right sub-tree
		// return true if any of the two recursive call return true.
		return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
	}
}
