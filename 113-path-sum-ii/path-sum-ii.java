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
        path(root,targetSum,new ArrayList<>());
        return ans;
    }
    public void path(TreeNode root,int target,List<Integer> l1){
        if(root==null){
            return;
        }
        l1.add(root.val);
        if(root.left==null && root.right==null && root.val==target){
            ans.add(new ArrayList<>(l1));
            
        }
        
        path(root.left,target-root.val,l1);
        path(root.right,target-root.val,l1);
        l1.remove(l1.size()-1);
    }
}