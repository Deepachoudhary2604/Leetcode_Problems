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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans; 
        }
        int h=height(root);
        for(int i=1;i<=h;i++){
            List<Integer> l1=new ArrayList<>();
            helper(l1,root,i);
            ans.add(new ArrayList<>(l1));
        }
        return ans;
    }
    public void helper(List<Integer> l1,TreeNode root,int level){
        if(root==null){
            return;
        }
        if(level==1){
            l1.add(root.val);
        }
        helper(l1,root.left,level-1);
        helper(l1,root.right,level-1);
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
}