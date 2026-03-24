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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,preorder.length-1,preorder,0,inorder.length-1,inorder);
    }
    public TreeNode helper(int prelo,int prehi,int[] preorder,int inlo,int inhi,int[] inorder){
        if(prelo>prehi){
            return null;
        }
        TreeNode root=new TreeNode(preorder[prelo]);
        int i=inlo;
        while(preorder[prelo]!=inorder[i]){
            i++;
        }
        int size=i-inlo;
        root.left=helper(prelo+1,prelo+size,preorder,inlo,inlo+size-1,inorder);
        root.right=helper(prelo+size+1,prehi,preorder,inlo+size+1,inhi,inorder);
        return root;
    }
}