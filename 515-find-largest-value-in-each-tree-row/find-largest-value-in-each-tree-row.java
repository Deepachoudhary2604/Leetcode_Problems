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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }

        List<List<Integer>> l1=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> l2=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                l2.add(temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            l1.add(l2);
        }
        for(int i=0;i<l1.size();i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<l1.get(i).size();j++){
                max=Math.max(max,l1.get(i).get(j));
            }
            ans.add(max);
        }
        return ans;
    }
}