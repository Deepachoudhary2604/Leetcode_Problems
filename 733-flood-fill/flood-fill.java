class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial=image[sr][sc];
        if (initial == color) return image;
        dfs(image,sr,sc,color,initial);
        return image;
    }
    public void dfs(int[][] image,int sr,int sc,int color,int initial){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=initial){
            return;
        }
        image[sr][sc]=color;
        dfs(image,sr+1,sc,color,initial);
        dfs(image,sr-1,sc,color,initial);
        dfs(image,sr,sc-1,color,initial);
        dfs(image,sr,sc+1,color,initial);
    }
}