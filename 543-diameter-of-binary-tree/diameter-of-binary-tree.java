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
    int d=0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return d-1;
    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=helper(root.left);
        int r=helper(root.right);
        d=Math.max(d,1+l+r);
        return 1+Math.max(l,r);
    }
}