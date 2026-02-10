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
        diameter(root);
        return d-1;
    }   
    public int diameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=diameter(root.left);
        int right=diameter(root.right);
        d=Math.max(d,1+left+right);
        return 1+Math.max(left,right);
    }
}