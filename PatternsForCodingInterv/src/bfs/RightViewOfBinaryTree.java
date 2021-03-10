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
public class RightViewOfBinaryTree {

	/**
	 * Given a binary tree, return an array containing nodes in its right view. The
	 * right view of a binary tree is the set of nodes visible when the tree is seen
	 * from the right side.
	 * 
	 * Right view: [1,3,7] [[1],[2,3],[4,5,6,7]]
	 * 
	 * Right view: [12,1,5,3] [[12],[7,1],[9,10,5],[3]]
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.left.left.left = new TreeNode(3);
		List<TreeNode> result = traverse(root);
		for (TreeNode node : result) {
			System.out.print(node.val + " ");
		}
	}

	public static List<TreeNode> traverse(TreeNode root) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode node = null;
		int levelSize;
		while (!queue.isEmpty()) {
			levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				node = queue.poll();
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			result.add(node);
		}
		return result;
	}
}
