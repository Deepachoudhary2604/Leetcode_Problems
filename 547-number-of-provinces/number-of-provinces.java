class Solution {
    
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int count=0;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); // create empty list for each node
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int[] visited=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                count++;
                dfs(adj,visited,i);
            }
        }
        return count;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int[] visited,int s){
        visited[s]=1;
        for(int val:adj.get(s)){
            if(visited[val]==0){
                dfs(adj,visited,val);

            }
        }
    }
}