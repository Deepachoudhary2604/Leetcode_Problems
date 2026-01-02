class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[][] dist=new int[n+1][2];

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{1,0});
        for(int i=1;i<=n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[1][0]=0;
        while(!q.isEmpty()){
            int[] val=q.poll();
            int node=val[0];
            int currTime=val[1];
            for(int neibr:adj.get(node)){
                int t=currTime;
                if((t/change)%2==1){
                    t=(t/change+1)*change;
                }
                int newTime=t+time;
                if(newTime<dist[neibr][0]){
                    dist[neibr][1]=dist[neibr][0];
                    dist[neibr][0]=newTime;
                    q.offer(new int[]{neibr,newTime});
                }
                else if(newTime>dist[neibr][0] && newTime<dist[neibr][1]){
                    dist[neibr][1]=newTime;
                    q.offer(new int[]{neibr,newTime});
                }
            }
        }
        return dist[n][1];
    }
}