/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // Ignore paths with negative sums
        int leftSum = Math.max(maxGain(node.left), 0);
        int rightSum = Math.max(maxGain(node.right), 0);

        // Path sum including both children
        int currentPathSum = node.val + leftSum + rightSum;

        // Update global max if current path is better
        maxSum = Math.max(maxSum, currentPathSum);

        // Return max gain if we continue this path upwards
        return node.val + Math.max(leftSum, rightSum);
    
    }
}