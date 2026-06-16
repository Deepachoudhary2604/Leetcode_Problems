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
    public int path(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int c = 0;
        if (root.val == targetSum) {
            c++;
        }

        c += path(root.left, targetSum - root.val);
        c += path(root.right, targetSum - root.val);
        return c;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int c = path(root, targetSum); // Paths starting at current node
        c += pathSum(root.left, targetSum);  // Explore left subtree
        c += pathSum(root.right, targetSum); // Explore right subtree
        return c;
    }
}