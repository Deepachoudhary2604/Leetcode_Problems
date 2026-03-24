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
    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    public int maxLevelSum(TreeNode root) {
        helper(root);
        int temp=-1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<ans.size();i++){
            int sum=0;
            for(int j=0;j<ans.get(i).size();j++){
                sum+=ans.get(i).get(j);
            }
            if(sum>max){
                temp=i;
                max=sum;
            }
        }
        return temp+1;
    }
    public void helper(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> l=new ArrayList<>();
            while(size>0){
                TreeNode node=q.poll();
                l.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                size--;
            }
            ans.add(new ArrayList<>(l));
        }
    }
}