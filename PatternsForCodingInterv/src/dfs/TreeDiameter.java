/**
 * 
 */
package dfs;

/**
 * @author gummadisunil.kumar
 *
 */
public class TreeDiameter {

	/**
	 * Given a binary tree,find the length of its diameter. The diameter of a tree
	 * is the number of nodes on the longest path between any two leaf nodes. The
	 * diameter of a tree may or may not pass through the root.
	 * 
	 * Note: You can always assume that there are at least two leaf nodes in the
	 * given tree.
	 * 
	 * OutPut: 5 (4->2->1->3->6) [[1],[2,3],[4,5,6]]
	 * 
	 * Output: 7 (10,8,5,3,6,9,11) [[1],[2,3],[5,6],[7,8,9],[10,11]]
	 */
	private static int treeDiameter = 0;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		System.out.println("Tree Diameter : " + findDiameter(root));
		root.left.left = null;
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		root.right.left.right.left = new TreeNode(10);
		root.right.right.left.left = new TreeNode(11);
		System.out.println("Tree Diameter: " + findDiameter(root));

	}

	public static int findDiameter(TreeNode root) {

		calculateHeight(root);
		return treeDiameter;
	}

	public static int calculateHeight(TreeNode root) {
		if (root == null)
			return 0;
		int leftTreeHeight = calculateHeight(root.left);
		int rightTreeHeight = calculateHeight(root.right);
		// if the current node doesn't have a left or right subtree we can't have
		// a path passing through it,since we need a leaf node on each side
		if (leftTreeHeight != 0 && rightTreeHeight != 0) {
			// diameter at the current node will be equal to the height of the left subtree
			// +
			// the height of the right sub tree +1 for the current node
			int diameter = leftTreeHeight + rightTreeHeight + 1;
			treeDiameter = Math.max(treeDiameter, diameter);
		}
		return Math.max(leftTreeHeight, rightTreeHeight) + 1;
	}
}
