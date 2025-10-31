class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int pro=0;
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                pro++;
                dfs(adj,vis,i);
            }
        }
        return pro;
    }
    public static void dfs(List<List<Integer>> adj,int[] vis,int node){
        vis[node]=1;
        for(int n:adj.get(node)){
            if(vis[n]==0){
                dfs(adj,vis,n);
            }
        }
    }
}