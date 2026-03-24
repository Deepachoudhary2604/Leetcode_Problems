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
    public void helper(TreeNode root,int targetSum,List<Integer> l2,List<List<Integer>> l1){
        if(root==null){
            return ;

        }
        l2.add(root.val);
        if(root.left==null && root.right==null && root.val==targetSum){
            l1.add(new ArrayList<>(l2));
        }
        helper(root.left,targetSum-root.val,l2,l1);
        helper(root.right,targetSum-root.val,l2,l1);
        l2.remove(l2.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>(); 
        helper(root,targetSum,l2,l1);
        return l1;

    }
}