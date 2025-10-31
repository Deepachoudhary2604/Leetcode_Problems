class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<color.length;i++){
            if(color[i]==-1){
                if(dfs(graph,i,color,0)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph,int currNode,int[] color,int currColor){
        color[currNode]=currColor;
        for(int neibr:graph[currNode]){
            if(color[neibr]==-1){
                if(dfs(graph,neibr,color,1-currColor)==false){
                    return false;
                }
                
            }
            if(color[neibr]==color[currNode]){
                return false;
            }
        }
        return true;
    }
}
