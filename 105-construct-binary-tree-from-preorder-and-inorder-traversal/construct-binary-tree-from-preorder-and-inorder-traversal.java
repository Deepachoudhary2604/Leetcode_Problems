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
        return tree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode tree(int[] preorder,int prelo,int prehi,int[] inorder,int inlo,int inhi){
        if(prelo>prehi) return null;
        TreeNode root=new TreeNode(preorder[prelo]);
        int i=inlo;
        while(preorder[prelo]!=inorder[i]){
            i++;
        }
        int size=i-inlo;
        root.left=tree(preorder,prelo+1,prelo+size,inorder,inlo,inlo+size);
        root.right=tree(preorder,prelo+size+1,prehi,inorder,inlo+size+1,inhi);
        return root;
    }

}