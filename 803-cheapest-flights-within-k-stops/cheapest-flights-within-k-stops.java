class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] f:flights){
            int u=f[0];
            int v=f[1];
            int w=f[2];
            adj.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);
        q.offer(new int[] {0,src,0});
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int cost=curr[0];
            int node=curr[1];
            int stops=curr[2];
            if(node==dst){
                return cost;
            }
            if(stops>k){
                continue;
            }

            if (stops >= minStops[node]) continue;
            minStops[node] = stops;
            
            for(int[] neibr:adj.get(node)){
                q.offer(new int[] {neibr[1]+cost,neibr[0],stops+1});
            }
        }
        return -1;

    }

}