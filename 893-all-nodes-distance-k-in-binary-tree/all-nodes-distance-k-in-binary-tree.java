class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        makeGraph(adj, -1, root);

        Set<Integer> vis=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(target.val);
        vis.add(target.val);
        int dist=0;
        while(!q.isEmpty()){

            int n=q.size();
            if(dist==k){
                return new ArrayList<>(q);
            }
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
            dist++;
        }
        return new ArrayList<>();
    }

    public void makeGraph(HashMap<Integer, List<Integer>> adj, int parent, TreeNode root) {
        if(root==null){
            return;
        }
        adj.putIfAbsent(root.val,new ArrayList<>());
        if(parent!=-1){
            adj.get(root.val).add(parent);
            // adj.get(parent).add(root.val);
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
