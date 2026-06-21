class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            adj.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            int node=temp[0];
            int d=temp[1];
            if(d>dist[node]){
                continue;
            }
            for(int[] neibr:adj.get(node)){
                int nextNode=neibr[0];
                int nextWt=neibr[1];
                if(dist[nextNode]>nextWt+dist[node]){
                    dist[nextNode]=nextWt+dist[node];
                    pq.add(new int[]{nextNode,dist[nextNode]});
                }
            }
        }
        int ans=0;
        for(int i=1;i<dist.length;i++){
            ans=Math.max(ans,dist[i]);
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}