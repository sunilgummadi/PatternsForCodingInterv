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
public class ConnectAllLevelOrderSiblings {

	/**
	 * Given a binary tree, connect each node with its level order successor. The
	 * last node of each level should point to the first node of the next level.
	 */
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(12);
		root.left = new BinaryTree(7);
		root.right = new BinaryTree(1);
		root.left.left = new BinaryTree(9);
		root.right.left = new BinaryTree(10);
		root.right.right = new BinaryTree(5);
		connect(root);
		while (root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
	}

	public static void connect(BinaryTree root) {
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.offer(root);
		BinaryTree previous = null;
		while (!queue.isEmpty()) {
			BinaryTree node = queue.poll();
			if (previous != null)
				previous.next = node;
			previous = node;
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}
}
