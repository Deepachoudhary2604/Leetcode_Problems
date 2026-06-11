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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int h=height(root);
        for(int i=1;i<=h;i++){
            if(i%2!=0){
                ans.add(level1(root,i,new ArrayList<>()));
            }
            else{
                ans.add(level2(root,i,new ArrayList<>()));
            }
        }
        return ans;
    }
    public List<Integer> level1(TreeNode root,int n,List<Integer> arr){
        if(root==null){
            return arr;
        }
        if(n==1){
            arr.add(root.val);
        }
        level1(root.left,n-1,arr);
        level1(root.right,n-1,arr);
        return arr;
    }
    public List<Integer> level2(TreeNode root,int n,List<Integer> arr){
        if(root==null){
            return arr;
        }
        if(n==1){
            arr.add(root.val);
        }
        level2(root.right,n-1,arr);
        level2(root.left,n-1,arr);
        return arr;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;

        }
        return 1+Math.max(height(root.left),height(root.right));
    }
}