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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> adj=new ArrayList<>();
        helper(root,adj);
        return adj.get(k-1);
    }
    public void helper(TreeNode root,List<Integer> adj){
        if(root==null){
            return;
        }
        helper(root.left,adj);
        adj.add(root.val);
        helper(root.right,adj);
    }


}