class Solution {
    int[] dp;
    int mod=1_000_000_007;
    ArrayList<ArrayList<int[]>> adj;
    long[] dist;
    public int countRestrictedPaths(int n, int[][] edges) {
        adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        
        dijkastra(n);
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(1,n);
    }
    public void dijkastra(int n){

        dist=new long[n+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[n]=0;
        PriorityQueue<long[]> pq=new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{n,0});
        while(!pq.isEmpty()){
            long[] val=pq.poll();
            int u=(int)val[0];
            long v=val[1];
            if(v>dist[u]){
                continue;
            }
            dist[u]=v;
            for(int[] neibr:adj.get(u)){
                int node=neibr[0];
                long d=neibr[1];
                if (dist[u] + d < dist[node]) {
                    dist[node]=dist[u]+d;
                    pq.add(new long[]{node,dist[node]});
                }
            }
        }
    }
    public int dfs(int u,int n){
        if(u==n){
            return 1;

        }
        if(dp[u]!=-1){
            return dp[u];
        }
        long ways=0;
        for(int[] neibr:adj.get(u)){
            int v=neibr[0];
            if(dist[v]<dist[u]){
                ways = (ways + dfs(v, n)) % mod;
            }
        }
        return dp[u]=(int)ways;
    }
}