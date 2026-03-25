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
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> l1=new ArrayList<>();
        helper(root,targetSum,l1);
        return ans;
    }
    public void helper(TreeNode root,int target,ArrayList<Integer> l1){
        if(root==null){
            return;
        }
        l1.add(root.val);
        if((root.left==null && root.right==null) && target==root.val){
            
            ans.add(new ArrayList<>(l1));
        }
        
        helper(root.left,target-root.val,l1);
        helper(root.right,target-root.val,l1);
        l1.remove(l1.size()-1);
    }
}