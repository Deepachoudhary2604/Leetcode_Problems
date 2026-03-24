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
    public long kthLargestLevelSum(TreeNode root, int k) {
        helper(root);
        Long max=Long.MAX_VALUE;
        ArrayList<Long> temp=new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            Long sum=0L;
            for(int j=0;j<ans.get(i).size();j++){
                sum+=ans.get(i).get(j);
            }
            temp.add(sum);
        }
        Collections.sort(temp);
        if(k>temp.size()){
            return -1;
        }
        return temp.get(temp.size()-k);
       
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