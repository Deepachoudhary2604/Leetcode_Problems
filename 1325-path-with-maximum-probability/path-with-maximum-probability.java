class Solution {
    public double maxProbability(int n,int[][] edges,double[] succProb,int start,int end) {
        ArrayList<ArrayList<double[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double prob=succProb[i];
            adj.get(u).add(new double[]{v,prob});
            adj.get(v).add(new double[]{u,prob});
        }
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[1],a[1]));
        pq.add(new double[]{start,1.0});
        double[] prob=new double[n];
        prob[start]=1.0;
        while(!pq.isEmpty()){
            double[] val=pq.poll();
            int node=(int)val[0];
            double p=val[1];
            if(node==end){
                return p;
            }
            if(p<prob[node]){
                continue;
            }
            for(double[] neibr:adj.get(node)){
                int nextNode=(int)neibr[0];
                double nextProb=neibr[1];
                
                if(prob[node]*nextProb>prob[nextNode]){
                    prob[nextNode]=prob[node]*nextProb;
                    pq.add(new double[]{nextNode,prob[nextNode]});
                }
            }
        }
        return 0.0;

    }
}
