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
        double[] prob=new double[n];
        prob[start]=1.0;
        PriorityQueue<double[]> q=new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        q.add(new double[]{start,1.0});
        while(!q.isEmpty()){
            double[] val=q.poll();
            int node=(int)val[0];
            double p=val[1];
            if(node==end){
                return p;
            }
            if(p<prob[node]){
                continue;
            }
            for(double[] neibr:adj.get(node)){
                int neibrNode=(int)neibr[0];
                double neibrProb=neibr[1];
                double newProb=p*neibrProb;
                if(newProb>prob[neibrNode]){
                    prob[neibrNode]=newProb;
                    q.add(new double[]{neibrNode,newProb});
                }
            }
        }
        return 0.0;
    }
}
