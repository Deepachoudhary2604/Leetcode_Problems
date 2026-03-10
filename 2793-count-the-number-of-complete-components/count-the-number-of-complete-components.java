class Solution {
    int nodes=0;
    int ed=0;
    public int countCompleteComponents(int n, int[][] edges) {
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
        int c=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                nodes = 0;
                ed = 0;

                dfs(adj, vis, i);
                if (ed == nodes * (nodes - 1)) {
                    c++;
                }
            }
        }
        return c;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int s){
        vis[s]=true;
        nodes++;
        ed += adj.get(s).size();
        for(int neibr:adj.get(s)){
            if(!vis[neibr]){
                dfs(adj,vis,neibr);
            }
        }
    }
}