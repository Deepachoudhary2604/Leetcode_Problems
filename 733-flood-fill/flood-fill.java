class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int temp=image[sr][sc];
        if(temp==color){
            return image;
        }
        dfs(image,sr,sc,color,temp);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color,int temp){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=temp){
            return;
        }
        image[sr][sc]=color;
        dfs(image,sr+1,sc,color,temp);
        dfs(image,sr-1,sc,color,temp);
        dfs(image,sr,sc+1,color,temp);
        dfs(image,sr,sc-1,color,temp);
    }
}