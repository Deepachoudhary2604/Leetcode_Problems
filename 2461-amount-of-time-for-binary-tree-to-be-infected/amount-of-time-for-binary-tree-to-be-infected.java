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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer,List<Integer>> adj=new HashMap<>();
        makeGraph(adj,-1,root);
        Set<Integer> vis=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        vis.add(start);
        int min=-1;
        while(!q.isEmpty()){
            int n=q.size();
            while(n>0){
                int val=q.poll();
                for(int neibr:adj.get(val)){
                    if(!vis.contains(neibr)){
                        q.add(neibr);
                        vis.add(neibr);
                    }
                }
                n--;
            }
            min++;
        }
        return min;
    }
    public void makeGraph(HashMap<Integer,List<Integer>> adj,int parent,TreeNode root){
        if(root==null){
            return;
        }
        adj.putIfAbsent(root.val,new ArrayList<>());
        if(parent!=-1){
            adj.get(root.val).add(parent);
        }
        if(root.left!=null){
            adj.get(root.val).add(root.left.val);
        }
        if(root.right!=null){
            adj.get(root.val).add(root.right.val);
        }
        makeGraph(adj,root.val,root.left);
        makeGraph(adj,root.val,root.right);
    }
}