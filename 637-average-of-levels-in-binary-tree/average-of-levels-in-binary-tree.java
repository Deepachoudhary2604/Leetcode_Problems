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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        helper(root,ans);
        return ans;
    }
    public void helper(TreeNode root,List<Double> ans){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            long sum=0;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                int val=node.val;
                sum+=val;
                if(node.left!=null){
                    q.add(node.left);

                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            ans.add((double)sum/size);
        }
    }
}