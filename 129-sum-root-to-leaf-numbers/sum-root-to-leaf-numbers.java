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
    int res=0;
    List<List<Integer>> ans=new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> temp=new ArrayList<>();
        helper(root,temp);
        for(int i=0;i<ans.size();i++){
            int sum=0;
            for(int j=0;j<ans.get(i).size();j++){
                sum=sum*10+ans.get(i).get(j);
            }
            res+=sum;
        }
        return res;
    }
    public void helper(TreeNode root,ArrayList<Integer> l1){
        if(root==null){
            return;
        }
        l1.add(root.val);
        if(root.left==null && root.right==null){
            ans.add(new ArrayList<>(l1));
        }
        helper(root.left,l1);
        helper(root.right,l1);
        l1.remove(l1.size()-1);
    }
}