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
    public void helper(TreeNode root,List<String> l,String s){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            s+=root.val;
            l.add(s);
            return;
        }
        s+=root.val+"->";
        helper(root.left,l,s);
        helper(root.right,l,s);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l=new ArrayList<>();
        helper(root,l,"");
        return l;
    }
}