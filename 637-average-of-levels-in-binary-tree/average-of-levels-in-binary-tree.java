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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res=new ArrayList<>();
        helper(root);
        for(int i=0;i<ans.size();i++){
            double c=0;
            double sum=0;
            for(int j=0;j<ans.get(i).size();j++){
                c++;
                sum+=ans.get(i).get(j);
            }
            res.add(sum/c);
        }
        return res;
    }
    public void helper(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp=new ArrayList<>();
            while(size>0){
                TreeNode node=q.poll();
                temp.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                size--;
                
            }
            ans.add(new ArrayList<>(temp));
        }
    }
}