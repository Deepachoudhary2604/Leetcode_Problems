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
    public boolean isEvenOddTree(TreeNode root) {
        helper(root);
        for(int i=0;i<ans.size();i++){
            if(i%2==0){
                for(int j=0;j<ans.get(i).size();j++){
                    if(ans.get(i).get(j)%2==0){
                        return false;
                    }
                }
                for(int j=0;j<ans.get(i).size()-1;j++){
                    if(ans.get(i).get(j)>=ans.get(i).get(j+1)){
                        return false;
                    }
                }
            }
            else{
                for(int j=0;j<ans.get(i).size();j++){
                    if(ans.get(i).get(j)%2!=0){
                        return false;
                    }
                }
                for(int j=0;j<ans.get(i).size()-1;j++){
                    if(ans.get(i).get(j)<=ans.get(i).get(j+1)){
                        return false;
                    }
                }
            }
            
        }
        return true;
    }
    public void helper(TreeNode root){
        if (root == null) return ;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();                 
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            ans.add(level);                      
        }
        
    }
}