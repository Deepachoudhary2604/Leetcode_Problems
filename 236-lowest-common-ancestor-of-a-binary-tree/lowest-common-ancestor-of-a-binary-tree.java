/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean contains(TreeNode root,TreeNode item){
        if(root==null){
            return false;
        }
        if(root==item){
            return true;
        }
        return (contains(root.left,item)||(contains(root.right,item)));
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root || q==root){
            return root;
        }
        if(p==q){
            return p;
        }
        boolean leftp=contains(root.left,p);
        boolean rightq=contains(root.right,q);
        
        if(!leftp && rightq){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(leftp && !rightq){
            return lowestCommonAncestor(root.left,p,q);
        }
        
        return root;
        
    }
}