class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis=new boolean[n];
        if(dfs(adj,source,destination,vis)){
            return true;
        }
        return false;
        
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int s,int d,boolean[] vis){
        if(s==d){
            return true;
        }
        vis[s]=true;
        for(int neibr:adj.get(s)){
            if(!vis[neibr]){
                if(dfs(adj,neibr,d,vis)){
                    return true;
                }
            }
        }
        return false;
    }
}