class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<color.length;i++){
            if(color[i]==-1){
                if(!dfs(graph,i,color,0)){
                    return false;
                }
          
            }
        }return true;
    }
    public boolean dfs(int[][] graph,int node,int[] color,int currColor){
        color[node]=currColor;
        for(int neibr:graph[node]){
            if(color[neibr]==color[node]){
                return false;
            }
            if(color[neibr]==-1){
                if(!dfs(graph,neibr,color,1-currColor)){
                    return false;
                }
            }
        }
        return true;
    }
}
