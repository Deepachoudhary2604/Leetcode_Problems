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
import java.util.*;
class Solution {
    public List<Integer> level1(TreeNode root,int n,List<Integer> l1){
        if(root==null){
            return l1;
        }
        if(n==1){
            l1.add(root.val);
        }
        level1(root.left,n-1,l1);
        level1(root.right,n-1,l1);
        return l1;
    }
    public List<Integer> level2(TreeNode root,int n,List<Integer> l1){
        if(root==null){
            return l1;
        }
        if(n==1){
            l1.add(root.val);
        }
        level2(root.right,n-1,l1);
        level2(root.left,n-1,l1);
        return l1;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l2=new ArrayList<>();
        int level=height(root);
        for(int i=1;i<=level;i++){
            List<Integer> l1=new ArrayList<>();
            if(i%2==0){
                l2.add(level2(root,i,l1));
            }
            else{
                l2.add(level1(root,i,l1));
            }
        }
        return l2;
    }
}
