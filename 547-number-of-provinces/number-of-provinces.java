class Solution {
    public int findCircleNum(int[][] isConnected) {
        int c=0;
        int n=isConnected.length;
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                c++;
                dfs(isConnected,vis,i);
            }
        }
        return c;
    }
    public void dfs(int[][] isConnected, int[] vis,int s){
        vis[s]=1;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[s][i]==1 && vis[i]==0){
                dfs(isConnected,vis,i);
                
            }
        }
    }
}