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
    List<Integer> ans=new ArrayList<>();
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null){
            return -1;
        }
        
        helper(root);
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<ans.size();i++){
            set.add(ans.get(i));

        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int num:set){
            res.add(num);
        }
        if(res.size()<=1){
            return -1;
        }
        Collections.sort(res);
        return res.get(1);
    }
    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        ans.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}