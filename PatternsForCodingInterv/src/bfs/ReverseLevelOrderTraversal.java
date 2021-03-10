/**
 * 
 */
package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author gummadisunil.kumar
 *
 */
public class ReverseLevelOrderTraversal {

	/**
	 * Given a binary tree populate an array to represent its level by level
	 * traversal in reverse order i.e. the lowest level comes first. You should
	 * populate the values of all nodes in each level from left to right in separate
	 * sub array.
	 * 
	 * Reverse Level Order Traversal: [[4,5,6,7],[2,3],[1]]
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		System.out.println("Reverse level order traversal: " + traverse(root));
	}

	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int levelSize;
		while (!queue.isEmpty()) {
			levelSize = queue.size();
			List<Integer> level = new ArrayList<Integer>(levelSize);
			for (int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			result.add(0, level);
		}
		return result;
	}
}
