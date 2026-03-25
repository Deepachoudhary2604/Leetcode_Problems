class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!helper(graph,color,i,0)){
                    return false;
                }
            }
            
        }
        return true;
    } 
    public boolean helper(int[][] graph,int[] color,int node,int currColor){
        color[node]=currColor;
        for(int neibr:graph[node]){
            if(color[neibr]==-1){
                if(!helper(graph,color,neibr,1-currColor)){
                    return false;
                }
            }
            if(color[neibr]==color[node]){
                return false;
            }
        }
        return true;
    }
}