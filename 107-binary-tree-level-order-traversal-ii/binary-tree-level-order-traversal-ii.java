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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(root,ans);
        return rev(ans);
        
    }
    public void helper(TreeNode root,List<List<Integer>> ans){
        if (root == null) return ;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();                 
            ArrayList<Integer> l1 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                l1.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ans.add(l1);                      
        }
    }
    public List<List<Integer>> rev(List<List<Integer>> ans){
        List<List<Integer>> r=new ArrayList<>();
        for(int i=ans.size()-1;i>=0;i--){
            List<Integer> l=ans.get(i);
            r.add(new ArrayList<>(l));
        }
        return r;
    }
}