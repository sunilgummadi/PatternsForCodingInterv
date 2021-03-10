/**
 * 
 */
package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gummadisunil.kumar
 *
 */
public class MinimumDepthOfBinaryTree {

	/**
	 * Find the minimum depth of a binary tree. The minimum depth is the number of
	 * nodes along the shortest path from the root node to the nearest leaf node.
	 * 
	 * Minimum Depth: 2 [[1],[2,3],[4,5]] 4,5 are child's of 2
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree minimum depth :" + findDepth(root));
		root.left.left = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		System.out.println("Tree Minimum Depth :" + findDepth(root));
	}

	public static int findDepth(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null)
			return 0;
		queue.offer(root);
		int minHeight = 0;
		int levelSize = 0;
		while (!queue.isEmpty()) {
			minHeight++;
			levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();
				if (node.left == null && node.right == null)
					return minHeight;
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
		return -1;
	}
}
