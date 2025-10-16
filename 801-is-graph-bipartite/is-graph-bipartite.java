class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) { 
                if (!dfs(graph, i, color, 0)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph,int s,int[] color,int currColor){
        color[s]=currColor;
        for (int neighbor : graph[s]) {
            if (color[neighbor] == -1) {
                if (!dfs(graph, neighbor, color, 1 - currColor)) {
                    return false;
                }
            } else if (color[neighbor] == color[s]) {
                return false; 
            }
        }
        return true;
    }
}