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
public class ZigzagTraversalAct {

	/**
	 * Given a binary tree, populate an array to represent its zigzag level order
	 * traversal. You should populate the values of all nodes of the first level
	 * from left to right then right to left for the next level and keep alternating
	 * in the same manner for the following levels.
	 * 
	 * Zigzag level order traversal : [[1],[3,2],[4,5,6,7]]
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		System.out.println("Zigzag traversal :" + traverse(root));
	}

	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		boolean check = false;
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> level = new LinkedList<>();
			for (int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();
				if (!check)
					level.add(node.val);
				else
					level.add(0, node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}

			result.add(level);
			check = !check;
		}
		return result;
	}
}
