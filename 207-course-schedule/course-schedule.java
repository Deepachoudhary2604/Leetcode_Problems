class Solution {
    public boolean canFinish(int n, int[][] grid) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] g:grid){
            int u=g[0];
            int v=g[1];
            adj.get(u).add(v);
        }
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int neibr:adj.get(i)){
                indegree[neibr]++;
            }
        }
        ArrayList<Integer> ans =new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int val=q.poll();
            ans.add(val);
            for(int neibr:adj.get(val)){
                indegree[neibr]--;
                if(indegree[neibr]==0){
                    q.add(neibr);
                }
            }
        }
        return ans.size()==n;
    }
}