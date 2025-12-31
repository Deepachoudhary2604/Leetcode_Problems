class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t:times){
            int u=t[0];
            int v=t[1];
            int w=t[2];
            adj.get(u).add(new int[] {v,w});
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,k});
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int u=curr[1];
            int d=curr[0];
            if(d>dist[u]){
                continue;
            }
            for(int[] neibr:adj.get(u)){
                int node=neibr[0];
                int w=neibr[1];
                if(w+dist[u]<dist[node]){
                    dist[node]=w+dist[u];
                    pq.offer(new int[]{dist[node],node});
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<dist.length;i++){
            max=Math.max(dist[i],max);
        }
        if(max!=Integer.MAX_VALUE){
            return max;
        }
        return -1;
    }
}