/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        makeGraph(root,map,-1);
        Queue<Integer> q=new LinkedList<>();
        q.add(target.val);
        HashSet<Integer> set=new HashSet<>();
        set.add(target.val);
        int dist=0;;
        while(!q.isEmpty()){
            int size=q.size();
            if(dist==k){
                return new ArrayList<>(q);
            }
            while(size>0){
                int node=q.poll();
                for(int neibr:map.get(node)){
                    if(!set.contains(neibr)){
                        set.add(neibr);
                        q.add(neibr);
                    }
                }
                size--;
            }
            dist++;
        }
        return new ArrayList<>();
    }
    public void makeGraph(TreeNode root,HashMap<Integer,List<Integer>> map,int parent){
        if(root==null){
            return;
        }
        map.putIfAbsent(root.val,new ArrayList<>());
        if(parent!=-1){
            map.get(root.val).add(parent);
        }
        if(root.left!=null){
            map.get(root.val).add(root.left.val);
        }
        if(root.right!=null){
            map.get(root.val).add(root.right.val);
        }
        makeGraph(root.left,map,root.val);
        makeGraph(root.right,map,root.val);
    }
    
}