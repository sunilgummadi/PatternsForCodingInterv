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
public class LevelOrderSuccessorAct {

	/**
	 * Given a binary tree and a node find the level order successor of the given
	 * node in the tree. The level order successor is the node that appears right
	 * after the given node in the level order traversal.
	 *
	 * Given node:3 Level Order Successor:4 [[1],[2,3],[4,5]]
	 *
	 * Given node:9 Level Order Successor:10 [[12],[7,1],[9,10,5]]
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		TreeNode result = findSuccessor(root, 12);
		if (result != null)
			System.out.println(result.val + " ");
		result = findSuccessor(root, 9);
		if (result != null)
			System.out.println(result.val + " ");
	}

	public static TreeNode findSuccessor(TreeNode root, int key) {
		if (root == null)
			return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
			if (node.val == key)
				break;
		}
		return queue.peek();
	}
}
