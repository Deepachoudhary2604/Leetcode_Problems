class Solution {
    public int findCircleNum(int[][] arr) {
        int ans=0;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] vis=new boolean[arr.length];
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                dfs(adj,i,vis);
                ans++;
            }
        }

        return ans;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int i,boolean[] vis){
        vis[i]=true;
        for(int neibr:adj.get(i)){
            if(!vis[neibr]){
                dfs(adj,neibr,vis);
            }
        }
    }
}