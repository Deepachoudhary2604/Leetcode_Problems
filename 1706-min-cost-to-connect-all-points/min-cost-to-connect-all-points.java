class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                adj.get(i).add(new int[]{j,dist});
                adj.get(j).add(new int[]{i,dist});
            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        int totalcost=0;
        int totaledge=0;
        boolean[] vis=new boolean[n];
        while(totaledge<n){
            int[] temp=pq.poll();
            int node=temp[0];
            int wt=temp[1];
            if(vis[node]){
                continue;

            }
            vis[node]=true;
            totalcost+=wt;
            totaledge++;
            for(int[] neibr:adj.get(node)){
                int nextNode=neibr[0];
                int nextWt=neibr[1];
                if(!vis[nextNode]){

                    pq.add(new int[]{nextNode,nextWt});
                }
            }
        }
        return totalcost;
    }
}