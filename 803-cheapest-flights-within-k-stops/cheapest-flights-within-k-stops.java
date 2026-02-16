class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            int from=flight[0];
            int to=flight[1];
            int price=flight[2];
            adj.get(from).add(new int[]{to,price});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,src,0});
        int[] min=new int[n];
        Arrays.fill(min,Integer.MAX_VALUE);
        while(!pq.isEmpty()){
            int[] val=pq.poll();
            int cost=val[0];
            int node=val[1];
            int stop=val[2];
            if(node==dst){
                return cost;

            }
            if(stop>k){
                continue;
            }
            if(min[node]<stop){
                continue;
            }
            min[node]=stop;
            for(int[] neibr:adj.get(node)){
                pq.add(new int[]{cost+neibr[1],neibr[0],stop+1});
            }
        }
        return -1;
    }

}