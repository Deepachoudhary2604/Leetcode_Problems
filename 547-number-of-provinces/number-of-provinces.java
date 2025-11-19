class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
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
        int c=0;
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(adj,vis,i);
                c++;
            }
        }
        return c;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int[] vis,int s){
        vis[s]=1;
        for(int i:adj.get(s)){
            if(vis[i]==0){
                dfs(adj,vis,i);
            }
        }
    }
}