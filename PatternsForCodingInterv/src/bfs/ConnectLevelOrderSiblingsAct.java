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
// class BinaryTree {
// int val;
// BinaryTree left;
// BinaryTree right;
// BinaryTree next;
//
// BinaryTree(int val) {
// this.val = val;
// this.left = null;
// this.right = null;
// this.next = null;
// }
//
// void printLevelOrder() {
// BinaryTree nextLevelRoot = this;
// while (nextLevelRoot != null) {
// BinaryTree current = nextLevelRoot;
// nextLevelRoot = null;
// while (current != null) {
// System.out.print(current.val + " ");
// if (nextLevelRoot == null) {
// if (current.left != null)
// nextLevelRoot = current.left;
// else if (current.right != null)
// nextLevelRoot = current.right;
// }
// current = current.next;
// }
// System.out.println();
// }
// }
// };

public class ConnectLevelOrderSiblingsAct {

	/**
	 * Given a binary tree, connect each node with its level order successor. The
	 * last node of each level should point to a null node.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(12);
		root.left = new BinaryTree(7);
		root.right = new BinaryTree(1);
		root.left.left = new BinaryTree(9);
		root.right.left = new BinaryTree(10);
		root.right.right = new BinaryTree(5);
		connect(root);
		System.out.println("Level order traversal using next pointer");
		root.printLevelOrder();
	}

	public static void connect(BinaryTree root) {
		Queue<BinaryTree> queue = new LinkedList<>();
		int levelSize;
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTree previousNode = null;
			levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				BinaryTree node = queue.poll();
				if (previousNode != null)
					previousNode.next = node;
				previousNode = node;
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
	}
}
