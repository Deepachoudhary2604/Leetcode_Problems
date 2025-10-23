class Solution {
    public boolean canFinish(int n, int[][] grid) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        for(int i=0;i<grid.length;i++){
            int u=grid[i][0];
            int v=grid[i][1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int val=q.poll();
            res.add(val);
            for(int neibr:adj.get(val)){
                indegree[neibr]--;
                if(indegree[neibr]==0){
                    q.add(neibr);
                }
            }
        }
        return res.size()==n;
    }
}