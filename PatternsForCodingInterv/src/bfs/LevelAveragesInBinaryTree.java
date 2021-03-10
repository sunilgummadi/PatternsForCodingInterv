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
public class LevelAveragesInBinaryTree {

	/**
	 * Given a binary tree, populate an array to represent the average of all its
	 * levels.
	 * 
	 * Level Averages:[1,2.5,5.5] [[1],[2,3],[4,5,6,7]]
	 * 
	 * 
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Level averages are :" + findLevelAverages(root));
	}

	public static List<Double> findLevelAverages(TreeNode root) {
		List<Double> result = new ArrayList<Double>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null)
			return result;
		queue.offer(root);
		int levelsize;
		Double sum;
		while (!queue.isEmpty()) {
			levelsize = queue.size();
			sum = 0.0;
			for (int i = 0; i < levelsize; i++) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			result.add(sum / levelsize);
		}
		return result;
	}
}
