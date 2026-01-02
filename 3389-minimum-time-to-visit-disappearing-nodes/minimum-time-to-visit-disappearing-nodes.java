class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] d:edges){
            int u=d[0];
            int v=d[1];
            int t=d[2];
            adj.get(u).add(new int[]{v,t});
            adj.get(v).add(new int[]{u,t});
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        if (disappear[0] == 0) return new int[n];

        while(!pq.isEmpty()){
            int[] val=pq.poll();
            int node=val[0];
            int wt=val[1];
            if(dist[node]<wt){
                continue;
            }
            if(wt>=disappear[node]){
                continue;
            }
            for(int[] neibr:adj.get(node)){
                int nd=neibr[0];
                int w=neibr[1];
                int newTime=w+wt;
                if(newTime>=disappear[nd]){
                    continue;
                }
                if(dist[nd]<w){
                    continue;
                }
                if (newTime < dist[nd]) {
                    dist[nd] = newTime;
                    pq.add(new int[]{nd, newTime});
                }
            }
        }
        int[] ans=new int[n];
        for(int i=0;i<disappear.length;i++){
            if(dist[i]>disappear[i]){
                ans[i]=-1;
            }
            else{
                ans[i]=dist[i];
            }
        }
        return ans;
    }
}