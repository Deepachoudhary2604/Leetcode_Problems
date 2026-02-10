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
    public List<Integer> inorder(TreeNode root,List<Integer> l1){
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                l1.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode leftChild=curr.left;
                while(leftChild.right!=null){
                    leftChild=leftChild.right;
                }
                leftChild.right=curr;
                TreeNode temp=curr;
                curr=curr.left;
                temp.left=null;
            }
        }
        return l1;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l1=new ArrayList<>();
        return inorder(root,l1);
    }
}