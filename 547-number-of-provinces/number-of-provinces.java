class Solution {
    public int findCircleNum(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[i].length;j++){
                if(edges[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int c=0;
        boolean[] vis=new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(!vis[i]){
                dfs(adj,vis,i);
                c++;
            }
        }
        return c;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int st){
        vis[st]=true;
        for(int neibr:adj.get(st)){
            if(!vis[neibr]){
                dfs(adj,vis,neibr);
            }
        }
    }
}