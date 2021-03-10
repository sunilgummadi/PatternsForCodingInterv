/**
 * 
 */
package dfs;

/**
 * @author gummadisunil.kumar
 *
 */
public class PathWithMaximumSum {

	/**
	 * Find the path with the maximum sum in a given binary tree. Write a function
	 * that returns the maximum sum.
	 * 
	 * A path can be defined as a sequence of nodes between any two nodes and
	 * doesn't necessarily pass through the root. The path must contain at least one
	 * node.
	 * 
	 * Output: 16 Path with maximum sum is [4,2,1,3,6] [[1],[2,3],[4,5,6]]
	 * 
	 * Output: 31 The Path with maximum sum is [8,5,3,6,9]
	 * [[1],[2,3],[1,3,5,6],[7,8,9]]
	 */
	private static int maxSum;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println("Maximum path sum 6 got : " + findMaximumPathSum(root));
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		System.out.println("Manimum path sum 31 got :" + findMaximumPathSum(root));
		
		root = new TreeNode(-1);
		root.left = new TreeNode(-3);
		System.out.println("Maximum path sum -1 got : " + findMaximumPathSum(root));
	}

	public static int findMaximumPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		findMaxSum(root);
		return maxSum;
	}

	public static int findMaxSum(TreeNode currentNode) {
		if (currentNode == null)
			return 0;
		int leftSum = findMaximumPathSum(currentNode.left);
		int rightSum = findMaximumPathSum(currentNode.right);
		//ignore paths with negative sum, since we need to find the maximum sum we should 
		//ignore any path which has an overall negative sum.
		leftSum = Math.max(leftSum, 0);
		rightSum = Math.max(rightSum, 0);
		int sum = leftSum + rightSum + currentNode.val;
		//update the global maximum sum
		maxSum = Math.max(maxSum, sum);
		//maximum sum of any path from the current node will be equal to the maximum of 
		//the sums from left or right subtrees plus the value of the current node.
		return Math.max(leftSum, rightSum) + currentNode.val;
	}
}
